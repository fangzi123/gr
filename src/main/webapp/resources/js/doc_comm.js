var status=false;
function del(obj){
	$.ajax({
		url : ctx+"/doc/delete.json",
		type : 'POST',
		dataType : 'json',
		async : false,
		data : obj,
		success : function(data) {
			if(data.success){
				status=true;
			}
		}
	});
}
function ajaxFileUpload() {  
    $("#form_edit").ajaxStart(function() {  
        $(this).show();  
    }).ajaxComplete(function() {  
        $(this).hide();  
    });  
    
    $.ajaxFileUpload({  
        url : ctx+"/doc/upload.json",// servlet请求路径  
        secureuri : false,  
        fileElementId : 'fileToUpload',// 上传控件的id  
        dataType : 'json',  
        data : {
	        	id : $("input[name='id']").val(),
	        	projectId : $("input[name='projectId']").val()
        	}, // 其它请求参数  
        success : function(data, status) {
        	uploadEnd(data);
        },  
        error : function(data, status, e) {  
            alert('上传出错');  
        }  
    })  
    return false;  
}
function uploadEnd(doc,obj){
	var docHTML  = "<tr>"
			     + "<td>【"+$("#projectName").val()+"】"+doc.filename+"</td>"
			     + '<td>'+doc.author+'&nbsp;<span class="badge">'+doc.uploadTime+'</span></td>'
			     + '<td><button type="button" class="btn btn-default" name="btn_del" data-docid='+doc.id+'><span class="glyphicon glyphicon-trash"></span></button></td>'
			     + '</tr>';
	$(docHTML).insertBefore($("#fileToUpload").parent().parent());
}
