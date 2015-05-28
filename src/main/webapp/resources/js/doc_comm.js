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
        data : {id : $("input[name='id']").val()}, // 其它请求参数  
        success : function(data, status) {  
        	console.log(data);
            if(data.success) {  
                alert(data.success);  
            }  
        },  
        error : function(data, status, e) {  
        	console.log(data);
        	console.log(status);
            alert('上传出错');  
        }  
    })  

    return false;  

} 
