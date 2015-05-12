<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
	String contextPath = pageContext.getServletContext().getContextPath();
%>
<html>
	<div id="left_box">
		<ul>
			<li class="n1"><a href="index.shtml"><span class="glyphicon glyphicon-align-left"></span><b>评审进度</b></a></li>
			<li class="n2"><a href="calendart.shtml"><span class="glyphicon glyphicon-calendar"></span><b>日历</b></a></li>
			<li class="n3"><a href="files.shtml"><span class="glyphicon glyphicon-paperclip"></span><b>文档管理</b></a></li>
			<li class="n4"><a href="admin_process.shtml"><span class="glyphicon glyphicon-flag"></span><b>流程管理</b></a></li>
			<li class="n5"><a href="admin_project.shtml"><span class="glyphicon glyphicon-bookmark"></span><b>项目管理</b></a></li>
			<li class="n6"><a href="manage_target"><span class="glyphicon glyphicon-stats"></span><b>指标管理</b></a></li>
			<li class="n2"><a href="<%=contextPath%>/rights/index"><span class="glyphicon glyphicon-cog"></span><b>权限管理</b></a></li>
			<li class="n8 disabled" title="无权限"><a><span class="glyphicon glyphicon-cog"></span><b>无权限访问</b></a></li>
		</ul>
	</div>
