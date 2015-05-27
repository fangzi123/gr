$(function(){
	$('.glyphicon-floppy-saved').parent().on('click',function(){
		if($.html5Validate.isAllpass($("#form_edit"))){
			$("#form_edit").submit();
		}
	})
})

function isDisplay(obj){
	 if($(obj).attr("checked")==true){
		 $(obj).next().val(true);
	 }else{
		 $(obj).next().val(false);
	 }
	}