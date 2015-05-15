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
		$('#edit_procNodeId').val("");
		$("#recipient-name").val("");
	});
	//编辑赋值事件
	$('.glyphicon-edit').parent().click(function(){
		$('#edit_procNodeId').val($(this).data('proc_node_id'));
		var thistds=$(this).parent().parent().find("td");
		$("#recipient-name").val(thistds.first().text());
	});
	
	//删除状态恢复
	$('.glyphicon-wrench').parent().click(function(){
		var obj={};
		obj.id=$(this).data('proc_node_id');
		obj.flag=true;
		modifyFlag(obj);
	})
	//删除赋值
	$('.glyphicon-trash').parent().click(function(){
		$('#del_procNodeId').val($(this).data('proc_node_id'));
	})
		//账户删除
	$("#btn-delete").on("click",function(){
		var obj={};
		obj.id=$('#del_procNodeId').val();
		obj.flag=false;
		modifyFlag(obj);
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
				window.location="index?procId="+$("#processId").val();
			}
		}
	});
}
function modifyFlag(obj){
	$.ajax({
		url :"modifyFlag.json",
		type : 'POST',
		dataType : 'json',
		async : false,
		data : obj,
		success : function(data) {
			if(data.success){
				window.location="index?procId="+$("#processId").val();
			}
		}
	});
}
