<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
	String contextPath = pageContext.getServletContext().getContextPath();
%>
	<div id="left_box">
		<ul>
			<li class="n1"><a href="<%=contextPath%>/gr/index"><span class="glyphicon glyphicon-align-left"></span><b>评审进度</b></a></li>
			<li class="n2"><a href="<%=contextPath%>/calendar/index"><span class="glyphicon glyphicon-calendar"></span><b>日历</b></a></li>
			<li class="n3"><a href="<%=contextPath%>/doc/index"><span class="glyphicon glyphicon-paperclip"></span><b>文档管理</b></a></li>
			<shiro:hasRole name="admin">
			<li class="n4"><a href="<%=contextPath%>/process/index"><span class="glyphicon glyphicon-flag"></span><b>流程管理</b></a></li>
			<li class="n5"><a href="<%=contextPath%>/project/index"><span class="glyphicon glyphicon-bookmark"></span><b>项目管理</b></a></li>
			<li class="n6"><a href="<%=contextPath%>/quota/index"><span class="glyphicon glyphicon-stats"></span><b>指标管理</b></a></li>
			<li class="n2"><a href="<%=contextPath%>/rights/index"><span class="glyphicon glyphicon-cog"></span><b>权限管理</b></a></li>
			</shiro:hasRole>
			<shiro:lacksRole name="admin">
			<li class="n4 disabled"><a><span class="glyphicon glyphicon-flag"></span><b>流程管理</b></a></li>
			<li class="n5 disabled"><a><span class="glyphicon glyphicon-bookmark"></span><b>项目管理</b></a></li>
			<li class="n6 disabled"><a><span class="glyphicon glyphicon-stats"></span><b>指标管理</b></a></li>
			<li class="n2 disabled"><a><span class="glyphicon glyphicon-cog"></span><b>权限管理</b></a></li>
			</shiro:lacksRole>
		</ul>
	</div>
