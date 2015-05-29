$(function(){
	
   $('.glyphicon-send').parent().on('click',function(){
	   if($.html5Validate.isAllpass($("#form_mail"))){
		   $('#form_mail').submit();
		}
   })
	
})