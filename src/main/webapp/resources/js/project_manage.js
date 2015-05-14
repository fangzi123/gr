$(function(){
	//添加账户
	$("#btn-save").on("click",function(){
		var username=$("#recipient-name").val();
		var processId=$("select[name='processId']").val();
		if(validate(username,processId)){
			$("#form-save").submit();
		}
	})
	
	//添加还原事件
	$('#btn-add').click(function(){
		$('#edit_projectId').val("");
		$("#recipient-name").val("");
		$("#ps_id option").attr("selected",false);
		$("#releaseLine option").attr("selected",false);
	});
	//编辑赋值事件
	$('.glyphicon-edit').parent().click(function(){
		$('#edit_projectId').val($(this).data('projectid'));
		var thistds=$(this).parent().parent().find("td");
		$("#recipient-name").val(thistds.first().text());
		var ps_name=thistds.eq(1).text();
		$("#ps_id").find("option[text='"+ps_name+"']").attr("selected",true);
		$("#releaseLine").find("option[value='"+thistds.eq(2).text()+"']").attr("selected",true);
	});
	
	//删除状态恢复
	$('.glyphicon-wrench').parent().click(function(){
		window.location="regain?id="+$(this).data('projectid');
	})
	//删除赋值
	$('.glyphicon-trash').parent().click(function(){
		$('#del_projectId').val($(this).data('projectid'));
	})
		//账户删除
	$("#btn-delete").on("click",function(){
			window.location="delete?id="+$('#del_projectId').val();
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

function validate(username, processId){
		if(username&&processId){
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
