$(function(){
	//添加账户
	$("#btn-save").on("click",function(){
		var username=$("#recipient-name").val();
		if(validate(username)){
			$("#form-save").submit();
		}
	})
	
	//添加还原事件
	$('#btn-add').click(function(){
		$('#edit_processId').val("");
		$("#recipient-name").val("");
	});
	//编辑赋值事件
	$('.glyphicon-edit').parent().click(function(){
		$('#edit_processId').val($(this).data('processid'));
		var thistds=$(this).parent().parent().find("td");
		$("#recipient-name").val(thistds.first().text());
	});
	
	//删除状态恢复
	$('.glyphicon-wrench').parent().click(function(){
		window.location="regain?id="+$(this).data('processid');
	})
	//删除赋值
	$('.glyphicon-trash').parent().click(function(){
		$('#del_processId').val($(this).data('processid'));
	})
		//账户删除
	$("#btn-delete").on("click",function(){
			window.location="delete?id="+$('#del_processId').val();
	})
	
	//up&dwon
	$('.glyphicon-arrow-up').parent().click(function(){
		var obj={};
		obj.upSort=$(this).parent().parent().prev('tr').find("input[name='sort']").val();
		obj.upId=$(this).parent().parent().prev('tr').find("input[name='id']").val();
		obj.downSort=$(this).parent().parent().find("input[name='sort']").val(),
		obj.downId=$(this).parent().parent().find("input[name='id']").val()
		sort(obj);
	});
	$('.glyphicon-arrow-down').parent().click(function(){
		var obj={};
		obj.upSort=$(this).parent().parent().find("input[name='sort']").val();
		obj.upId=$(this).parent().parent().find("input[name='id']").val();
		obj.downSort=$(this).parent().parent().next('tr').find("input[name='sort']").val();
		obj.downId=$(this).parent().parent().next('tr').find("input[name='id']").val();
		sort(obj);
	});
})

function validate(username){
		if(username){
			return true;
		}
		return false;
	}

function sort(obj){
	$.ajax({
		url :"sort.json",
		type : 'POST',
		dataType : 'json',
		async : false,
		data : obj,
		success : function(data) {
			if(data.success){
				window.location="index";
			}
		}
	});
}
