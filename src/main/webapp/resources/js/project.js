$(function(){
	//tab1
	$('.tb1 a').click(function (){
		$('#nav_gr li').removeClass('active');
		var cls = '.'+$(this).data('nav');
		$('#nav_gr').children(cls).addClass('active');
		$('#btn-edit').data('pjnid',$(this).data('pjnid'));
	});
	//tabs 
	var pjnid=$("input[name='pjnid']").val()
	if(pjnid){
		$('#nav_gr li a[data-pjnid="'+pjnid+'"]').tab('show');
	}else{
		$('#nav_gr li[status="进行中"] a').tab('show');
	}
	
	$('#btn-edit').on('click',function(){
		window.location.href='projnview?id='+$(this).data('pjnid');
	})
	$('#nav_gr li a').on('click',function(){
		$('#btn-edit').data('pjnid',$(this).data('pjnid'));
	})
})