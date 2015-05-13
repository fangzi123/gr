$(function(){
	//添加账户
	$("#btn-save").on("click",function(){
		var username=$("#recipient-name").val();
		if(username){
			$.ajax({
				url :"hasuser.json",
				type : 'POST',
				dataType : 'json',
				async : false,
				data : {
					username:username
				},
				success : function(data) {
					if(data.hasuser=="1"){
						$("#form-save").submit();
					}else{
						alert("请添加畅游内部邮箱前缀!");
					}
				}
			});
		}
	})
//del赋值事件
$('.glyphicon-trash').parent().click(function(){
	$('#del_userid').val($(this).data('userid'));
});
	//账户删除
$("#btn-delete").on("click",function(){
			window.location="delete?userId="+$('#del_userid').val();
	})
	
//编辑赋值事件
	$('.glyphicon-edit').parent().click(function(){
		$('#edit_userid').val($(this).data('userid'));
		var thistds=$(this).parent().parent().find("td");
		var name=thistds.first().text();
		$("#recipient-name").val(name);
		var type=thistds.eq(1).text();
		$("#admin").find("option[value='"+type+"']").attr("selected",true);
		
		var prosViewName=thistds.eq(2).text();
		if(prosViewName){
			prosViewName=prosViewName.substring(0,prosViewName.length-1);
			var vis=prosViewName.split("、");
			for(var i in vis){
				$('#porject_view').find("option[text='"+vis[i]+"']").attr('selected',true);
			} 
		}
		
		var prosEditName=thistds.eq(3).text();
		if(prosEditName){
			prosEditName=prosEditName.substring(0,prosEditName.length-1);
			var eds=prosEditName.split("、");
			for(var i in eds){
				$('#porject_edit').find("option[text='"+eds[i]+"']").attr('selected',true);
			} 
		}
	});
})
