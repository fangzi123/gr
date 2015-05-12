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
//del
$('.glyphicon-trash').parent().click(function(){
	$('#del_userid').val($(this).data('userid'));
});
	//账户删除
$("#btn-delete").on("click",function(){
			window.location="delete?userId="+$('#del_userid').val();
	})
})
