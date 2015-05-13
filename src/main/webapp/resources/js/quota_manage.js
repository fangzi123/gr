$(function(){
	//添加账户
	$("#btn-save").on("click",function(){
		var username=$("#recipient-name").val();
		if(username){
			$("#form-save").submit();
		}
	})
	
	//编辑赋值事件
	$('.glyphicon-edit').parent().click(function(){
		$('#edit_quotaId').val($(this).data('quotaid'));
		var thistds=$(this).parent().parent().find("td");
		$("#recipient-name").val(thistds.first().text());
		var type=thistds.eq(1).text();
		$("#quota_type").find("option[value='"+type+"']").attr("selected",true);
	});
	
	//删除赋值
	$('.glyphicon-trash').parent().click(function(){
		$('#del_quotaId').val($(this).data('quotaid'));
	})
		//账户删除
	$("#btn-delete").on("click",function(){
			window.location="delete?id="+$('#del_quotaId').val();
	})
	
	//up&dwon
	$('.glyphicon-arrow-up').parent().click(function(){
		$.ajax({
			url :"sort.json",
			type : 'POST',
			dataType : 'json',
			async : false,
			data : {
				upSort:$(this).parent().parent().prev('tr').find("input[name='sort']").val(),
				upId:$(this).parent().parent().prev('tr').find("input[name='id']").val(),
				downSort:$(this).parent().parent().find("input[name='sort']").val(),
				downId:$(this).parent().parent().find("input[name='id']").val()
			},
			success : function(data) {
				if(data.success){
					window.location="index";
				}
			}
		});
//		$(this).parent().parent().prev('tr').before($(this).parent().parent());
	});
	$('.glyphicon-arrow-down').parent().click(function(){
		$.ajax({
			url :"sort.json",
			type : 'POST',
			dataType : 'json',
			async : false,
			data : {
				upSort:$(this).parent().parent().find("input[name='sort']").val(),
				upId:$(this).parent().parent().find("input[name='id']").val(),
				downSort:$(this).parent().parent().next('tr').find("input[name='sort']").val(),
				downId:$(this).parent().parent().next('tr').find("input[name='id']").val()
			},
			success : function(data) {
				if(data.success){
					window.location="index";
				}
			}
		});
//		$(this).parent().parent().next('tr').after($(this).parent().parent());
	});
})
