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
	
	$('.glyphicon-trash').parent().on('click',function(){
		var obj={id:$(this).data('docid')};
		del(obj);
		if(status){
			$(this).parent().parent().remove();
		}
	});
	
	$('input[name="doc"]').on('change',function(){
//		document.form_edit.action=ctx+'/doc/upload';
//		document.form_edit.submit();
		ajaxFileUpload();
	});
})

function isDisplay(obj){
	 if($(obj).attr("checked")==true){
		 $(obj).next().val(true);
	 }else{
		 $(obj).next().val(false);
	 }
	}

