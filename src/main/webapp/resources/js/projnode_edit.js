$(function(){
	$('.glyphicon-floppy-saved').parent().on('click',function(){
		if($.html5Validate.isAllpass($("#form_edit"))){
			$("#form_edit").submit();
		}
	})
	
	//switch
	$('.switch .btn').click(function(){
		$(this).parent().find('button').removeClass('active');
		$(this).addClass('active');
		if($(this).hasClass('btn-success')){
			$(this).siblings('input').val(true);
		}else{
			$(this).siblings('input').val(false);
		}
	});
	
	$('.panel-body').on('click','button[name="btn_del"]',function(){
		var obj={id:$(this).data('docid')};
		del(obj);
		if(status){
			$(this).parent().parent().remove();
		}
	});
	
	$('.panel-body').on('change','input[name="doc"]',function(){
		form=$("#form_edit");
		data={
	        	id : $("input[name='id']").val(),
	        	projectId : $("input[name='projectId']").val()
     	}
		ajaxFileUpload(form,data,uploadEnd);
	});
})

function uploadEnd(doc){
	var docHTML  = "<tr>"
			     + "<td>【"+$("#projectName").val()+"】"+doc.filename+"</td>"
			     + '<td>'+doc.author+'&nbsp;<span class="badge">'+doc.uploadTime+'</span></td>'
			     + '<td><button type="button" class="btn btn-default" name="btn_del" data-docid='+doc.id+'><span class="glyphicon glyphicon-trash"></span></button></td>'
			     + '</tr>';
	$(docHTML).insertBefore($("#fileToUpload").parent().parent());
}

function isDisplay(obj){
	 if($(obj).attr("checked")==true){
		 $(obj).next().val(true);
	 }else{
		 $(obj).next().val(false);
	 }
	}

