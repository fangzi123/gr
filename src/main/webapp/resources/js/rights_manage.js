$(function(){
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
})
