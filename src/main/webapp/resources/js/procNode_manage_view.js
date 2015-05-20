$(function(){
	init();
	//保存
	$("#a-save").on("click",function(){
		if($.html5Validate.isAllpass($("#form-save"))){
			$("#form-save").submit();
		}
	});
	//返回
	$("#a-back").on("click",function(){
		window.location="index?procId="+$("#processId").val();
	})
	
	//module
	$('#module input').change(function(){
		if ($(this).prop('checked')){
			$("input[name='"+$(this).val()+"']").val(1);
			$('#'+$(this).val()+'_box').css('display','block');
		}
		else{
			$("input[name='"+$(this).val()+"']").val(0);
			$('#'+$(this).val()+'_box').css('display','none');
		};
	});
	
	//up&dwon
	$('.glyphicon-arrow-up').parent().click(function(){
		$(this).parent().parent().prev('tr').before($(this).parent().parent());
	});
	$('.glyphicon-arrow-down').parent().click(function(){
		$(this).parent().parent().next('tr').after($(this).parent().parent());
	});
	
	//+-
	$('.glyphicon-plus').parent().click(function(){
		var newTR=$(this).parent().parent().clone(true);
		newTR.find("input").val(null);
		newTR.insertAfter($(this).parent().parent());
	});
	$('.glyphicon-minus').parent().click(function(){
		var tr_length = $(this).parent().parent().parent().children('tr').length;
		if (tr_length>1)
		{
			var e=$(this).parent().parent().find("input[name$='Id']");
			var obj={};
			obj.who=e.attr("name");
			obj.whoId=e.val();
			obj.flag=false;
			del(obj);
			if(status){
				$(this).parent().parent().remove();
			}
		}
		else{
			alert('最后一行无法删除！');
			};
	});
	$('.panel-body').on('click','button[status="glyphicon-trash"]',function(){
		var tr_length = $(this).parent().parent().parent().children('tr').length;
		if (tr_length>0)
		{
			var e=$(this).parent().parent().find("input[name$='Id']");
			var obj={};
			obj.who=e.attr("name");
			obj.whoId=e.val();
			obj.flag=false;
			del(obj);
			if(status){
				$(this).find("span").removeClass("glyphicon-trash").addClass("glyphicon-wrench");
				$(this).attr("status","glyphicon-wrench");
				$(this).parent().parent().addClass("warning");
			}
		}
	});
	$('.panel-body').on('click','button[status="glyphicon-wrench"]',function(){
		var tr_length = $(this).parent().parent().parent().children('tr').length;
		if (tr_length>0)
		{
			var e=$(this).parent().parent().find("input[name$='Id']");
			var obj={};
			obj.who=e.attr("name");
			obj.whoId=e.val();
			obj.flag=true;
			del(obj);
			if(status){
				$(this).find("span").removeClass("glyphicon-wrench").addClass("glyphicon-trash");
				$(this).attr("status","glyphicon-trash");
				$(this).parent().parent().removeClass("warning");
			}
		}
	});
})

/**
 * 页面初始化
 */
function init(){
	var processType=$("select[name='processType']");
	var endType=$("select[name='endType']");
	var timeType=$("select[name='timeType']");
	processType.find("option[value='"+processType.attr("data")+"']").attr("selected",true);
	endType.find("option[value='"+endType.attr("data")+"']").attr("selected",true);
	timeType.find("option[value='"+timeType.attr("data")+"']").attr("selected",true);
}

function del(obj){
	$.ajax({
		url :"delete.json",
		type : 'POST',
		dataType : 'json',
		async : false,
		data : obj,
		success : function(data) {
			if(data.success){
				status=true;
			}
		}
	});
}
function validate(obj){
	if(obj){
		return true;
	}
	return false;
}
var status=false;
