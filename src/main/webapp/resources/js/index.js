$(function(){
	$('th').wrapInner("<b></b>");
	//process_btn

	$('#process_btn button').click(function(){
		if(!$(this).hasClass('active')){
			$('#process_btn button').removeClass('active');
			$(this).addClass('active');
			if('全部'==$(this).text()){
				$('.panel').show();
			}else{
				$('.panel').hide();
				$('body').find('.panel').eq($(this).index()-1).show();
			}
		}
	});
	//line_btn
	$('#line_btn button').click(function(){
		if(!$(this).hasClass('active')){
			$('#line_btn button').removeClass('active');
			$(this).addClass('active');
			if('全部'==$(this).text()){
				$('.panel').find("tbody").show();
			}else{
				$('.panel').find("tbody").hide();
				$('.panel').find("tbody[proj_releaseline='"+$(this).text()+"']").show();
			}
		}
	});
	$(function (){$("[data-toggle='popover']").popover({html : true});});
	$(function (){$('.pop_show').popover('show');});
	$('.msg').click(function (){
		if($(this).parent().parent().next('tr').hasClass('msg_nothing')){
			$(this).parent().parent().next('tr').removeClass('msg_nothing');
			$(this).parent().parent().next('tr').addClass('msg_something');
			}
		else{
			$(this).parent().parent().next('tr').removeClass('msg_something');
			$(this).parent().parent().next('tr').addClass('msg_nothing');
			};
	});
})