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
	
	
})

function isDisplay(obj){
	 if($(obj).attr("checked")==true){
		 $(obj).next().val(true);
	 }else{
		 $(obj).next().val(false);
	 }
	}