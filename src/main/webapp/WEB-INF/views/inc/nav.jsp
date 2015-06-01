<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<div id="nav" class="row">
	<div class="col-xs-2"><h1>Git Review</h1></div>
	<div class="col-xs-2 col-xs-offset-6">
		<div class="input-group">
			<input type="text" class="form-control" placeholder="Search for files" id="globalSearch" value=""> 
			<span class="input-group-btn">
			<button class="btn btn-default" type="button"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
			</span>
		</div>
	</div>
	<div  class="col-xs-1 user">
    	<span class="glyphicon glyphicon-user"></span>
    	<b>
    	<shiro:user>
		 <shiro:principal property="username"/>
		</shiro:user>
    	</b>
	</div>
	<div class="col-xs-1">
		<div class="input-group">
		<button type="submit" class="btn btn-default"><a href="<%=contextPath%>/logout">退出</a></button>
		</div>
	</div>
</div>
<script>
$('.glyphicon-search').parent().on('click',function(){
	window.location.href='<%=contextPath%>/doc/index?filename='+$('#globalSearch').val();
})
</script>