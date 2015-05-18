$(function(){
	init();
	//保存
	$("#a-save").on("click",function(){
		$("#form-save").submit();
	})
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

