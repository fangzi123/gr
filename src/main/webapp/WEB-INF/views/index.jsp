<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String contextPath = pageContext.getServletContext().getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- <meta charset="utf-8"> -->
<title>GR评审系统</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="author" content="Web Layout:Silence">
<link href="<%=contextPath%>/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=contextPath%>/resources/css/css.css" rel="stylesheet">
<script type="text/javascript" src="<%=contextPath%>/resources/js/comm/jquery.min.js"></script>
<script type="text/javascript" src="<%=contextPath%>/resources/js/comm/bootstrap.min.js"></script>
</head>

<body>
<%@ include file="inc/nav.jsp"%> 
<!--nav-->
<div id="content">
<jsp:include page="inc/left_box.jsp" flush="true"/> 
	<!--left_box-->
	<div id="right_box">
		<ol class="breadcrumb">
			<li><a href="<%=contextPath%>">首页</a></li>
			<li class="active">评审进度查询</li>
			</ol>
		<!--路径导航-->
		<div class="choose">
        	<div class="btn-group" role="group" aria-label="" id="process_btn">
        	<c:forEach items="${procList}" var="process">
              <button type="button" class="btn btn-default">${process.name }</button>
            </c:forEach>
            </div>
        	<div class="btn-group" role="group" aria-label="" id="line_btn">
              <button type="button" class="btn btn-default active">全部</button>
              <button type="button" class="btn btn-default">大中华</button>
              <button type="button" class="btn btn-default">欧美</button>
              <button type="button" class="btn btn-default">韩国</button>
              <button type="button" class="btn btn-default">自研</button>
              <button type="button" class="btn btn-default">合作</button>
            </div>
		</div>
        <!--choose-->
		<div class="panel panel-default">
		<div class="panel-body">
			<table class="table tb1">
				<tbody>
                	<tr>
                    	<th width="100"></th>
                        <th>GR0</th>
                        <th>报审</th>
                        <th>GR1</th>
                        <th>用研</th>
                        <th>MR1</th>
                        <th>启宣</th>
                        <th>TR1</th>
                        <th>GR2</th>
                        <th>CCB1</th>
                        <th>CCB2</th>
                        <th>MR2</th>
                        <th>TR2</th>
                        <th>GR3</th>
                        <th>版号</th>
                        <th>CB</th>
                        <th>OB</th>
                        <th>运营</th>
                        <th>停运</th>
                    </tr>
					<tr>
						<td align="center"><a href="porject.shtml">海战世界</a>&nbsp;<a href="#" class="msg"><span class="glyphicon glyphicon-ok-circle"></span></a></td>
						<td class="over"><q></q><i class="gr" data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td class="over"><q></q><i class="cr" data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td class="over"><q></q><i class="mr" data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td class="over"><q></q><i class="gr" data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td class="over"><q></q><i class="cr" data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td class="over"><q></q><i class="mr" data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td class="over"><q></q><i class="mr" data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td class="over"><q></q><i class="gr" data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td class="over"><q></q><i class="cr" data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td class="over"><q></q><i class="cr" data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td class="now"><em class="mr"></em><q></q><i class="mr pop_show" data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="费用工：1234$<br>费用B：3131$"></i></td>
						<td><q></q><i class="mr" data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td><q></q><i class="mr" data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td><q></q><i class="mr" data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td><q></q><i class="gr" data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td><q></q><i class="cr" data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td><q></q><i class="cr" data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td><i class="gr" data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
					</tr>
					<tr class="msg_nothing">
                    	<td class="bg-success"></td>
                    	<td colspan="18" class="bg-success">
                        	<p><strong>当前进展概述</strong>：这是一个抽象的样式，用以构建不同类型的组件，这些组件都具有在文本内容的左或右侧对齐的图片（就像博客评论或 Twitter 消息等）这是一个抽象的样式，用以构建不同类型的组件</p>
                            <p>这些组件都具有在文本内容的左或右侧对齐的图片（就像博客评论或 Twitter 消息等）这是一个抽象的样式，用以构建不同类型的组件，这些组件都具有在文本内容的左或右侧对齐的图片（就像博客评论或 Twitter 消息等）。</p></td>
                    </tr>
                	<tr>
                    	<th width="100"></th>
                        <th>GR0</th>
                        <th>报审</th>
                        <th>GR1</th>
                        <th>用研</th>
                        <th>MR1</th>
                        <th>启宣</th>
                        <th>TR1</th>
                        <th>GR2</th>
                        <th>CCB1</th>
                        <th>CCB2</th>
                        <th>MR2</th>
                        <th>TR2</th>
                        <th>GR3</th>
                        <th>版号</th>
                        <th>CB</th>
                        <th>OB</th>
                        <th>运营</th>
                        <th>停运</th>
                    </tr>
					<tr>
						<td align="center"><a href="porject.shtml">蛮荒搜神记</a>&nbsp;<a href="#" class="msg"><span class="glyphicon glyphicon-exclamation-sign"></span></a></td>
						<td class="over"><q></q><i class="gr" data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td class="over"><q></q><i class="cr" data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td class="over"><q></q><i class="mr" data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td class="over"><q></q><i class="gr" data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td><td class="now"><em class="mr"></em><q></q><i class="mr pop_show" data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="2015-03-19"></i></td>
						<td><q></q><i class="mr" data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td><q></q><i class="mr" data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td><q></q><i class="mr" data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td><q></q><i class="gr" data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td><q></q><i class="cr" data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td><q></q><i class="mr" data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td><q></q><i class="gr" data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td><q></q><i class="cr" data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td><q></q><i class="mr" data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td><q></q><i class="gr" data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td><q></q><i class="cr" data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td><q></q><i class="cr" data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td><i class="gr" data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
					</tr>
					<tr class="msg_something">
                    	<td class="bg-warning"></td>
                    	<td colspan="18" class="bg-warning">
                        	<p><strong>当前进展概述</strong>：这是一个抽象的样式，用以构建不同类型的组件，这些组件都具有在文本内容的左或右侧对齐的图片（就像博客评论或 Twitter 消息等）这是一个抽象的样式，用以构建不同类型的组件</p>
                            <p>这些组件都具有在文本内容的左或右侧对齐的图片（就像博客评论或 Twitter 消息等）这是一个抽象的样式，用以构建不同类型的组件，这些组件都具有在文本内容的左或右侧对齐的图片（就像博客评论或 Twitter 消息等）。</p></td>
                    </tr>
                	<tr>
                    	<th width="100"></th>
                        <th>GR0</th>
                        <th>报审</th>
                        <th>GR1</th>
                        <th>用研</th>
                        <th>MR1</th>
                        <th>启宣</th>
                        <th>TR1</th>
                        <th>GR2</th>
                        <th>CCB1</th>
                        <th>CCB2</th>
                        <th>MR2</th>
                        <th>TR2</th>
                        <th>GR3</th>
                        <th>版号</th>
                        <th>CB</th>
                        <th>OB</th>
                        <th>运营</th>
                        <th>停运</th>
                    </tr>
					<tr>
						<td align="center">封印者&nbsp;<a href="#" class="msg"><span class="glyphicon glyphicon-ok-circle"></span></a></td>
						<td class="over"><q></q><i class="gr" data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td class="over"><q></q><i class="cr" data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td class="over"><q></q><i class="mr" data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td class="over"><q></q><i class="gr" data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td class="over"><q></q><i class="cr" data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td class="over"><q></q><i class="mr" data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td class="over"><q></q><i class="mr" data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td class="over"><q></q><i class="gr" data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td class="over"><q></q><i class="cr" data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td class="over"><q></q><i class="cr" data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td class="over"><q></q><i class="gr" data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="2015-03-19"></i></td>
						<td class="over"><q></q><i class="mr" data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td class="over"><q></q><i class="mr" data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td class="over"><q></q><i class="mr" data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td class="now"><em class="ob"></em><q></q><i class="ob pop_show" data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td><q></q><i class="cr" data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td><q></q><i class="cr" data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td><i class="gr" data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
					</tr>
					<tr class="msg_nothing">
                    	<td class="bg-success"></td>
                    	<td colspan="18" class="bg-success">
                        	<p><strong>当前进展概述</strong>：这是一个抽象的样式，用以构建不同类型的组件，这些组件都具有在文本内容的左或右侧对齐的图片（就像博客评论或 Twitter 消息等）这是一个抽象的样式，用以构建不同类型的组件</p>
                            <p>这些组件都具有在文本内容的左或右侧对齐的图片（就像博客评论或 Twitter 消息等）这是一个抽象的样式，用以构建不同类型的组件，这些组件都具有在文本内容的左或右侧对齐的图片（就像博客评论或 Twitter 消息等）。</p></td>
                    </tr>
				</tbody>
			</table>
		</div>
		</div>
        <!--GR-->
        <div class="panel panel-default">
		<div class="panel-body">
			<table class="table table-hover tb1">
				<tbody>
					<tr>
						<td align="center"><a href="porject.shtml">某某革某</a>&nbsp;<a href="#" class="msg"><span class="glyphicon glyphicon-ok-circle"></span></a></td>
						<td class="over"><q></q><i data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td class="over"><q></q><i data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td class="over"><q></q><i data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td class="over"><q></q><i data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td class="over"><q></q><i data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td class="over"><q></q><i data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td class="over"><q></q><i data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td class="over"><q></q><i data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td class="over"><q></q><i data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td class="over"><q></q><i data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td class="now"><em class="cr"></em><q></q><i class="pop_show" data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="2015-03-19"></i></td>
						<td><q></q><i data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td><q></q><i data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td><q></q><i data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td><q></q><i data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td><q></q><i data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td><q></q><i data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td><i data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
					</tr>
					<tr class="msg_nothing">
                    	<td class="bg-success"></td>
                    	<td colspan="18" class="bg-success">
                        	<p><strong>当前进展概述</strong>：这是一个抽象的样式，用以构建不同类型的组件，这些组件都具有在文本内容的左或右侧对齐的图片（就像博客评论或 Twitter 消息等）这是一个抽象的样式，用以构建不同类型的组件</p>
                            <p>这些组件都具有在文本内容的左或右侧对齐的图片（就像博客评论或 Twitter 消息等）这是一个抽象的样式，用以构建不同类型的组件，这些组件都具有在文本内容的左或右侧对齐的图片（就像博客评论或 Twitter 消息等）。</p></td>
                    </tr>
					<tr>
						<td align="center"><a href="porject.shtml">蛮荒搜神记</a>&nbsp;<a href="#" class="msg"><span class="glyphicon glyphicon-exclamation-sign"></span></a></td>
						<td class="over"><q></q><i data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td class="over"><q></q><i data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td class="over"><q></q><i data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td class="over"><q></q><i data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td class="over"><q></q><i data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td class="over"><q></q><i data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td class="over"><q></q><i data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td class="now"><em class="cr"></em><q></q><i class="pop_show" data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td><q></q><i data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td><q></q><i data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td><q></q><i data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td><q></q><i data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td><q></q><i data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td><q></q><i data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td><q></q><i data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td><q></q><i data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td><q></q><i data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
						<td><i data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="有提示内容"></i></td>
					</tr>
					<tr class="msg_something">
                    	<td class="bg-warning"></td>
                    	<td colspan="18" class="bg-warning">
                        	<p><strong>当前进展概述</strong>：这是一个抽象的样式，用以构建不同类型的组件，这些组件都具有在文本内容的左或右侧对齐的图片（就像博客评论或 Twitter 消息等）这是一个抽象的样式，用以构建不同类型的组件</p>
                            <p>这些组件都具有在文本内容的左或右侧对齐的图片（就像博客评论或 Twitter 消息等）这是一个抽象的样式，用以构建不同类型的组件，这些组件都具有在文本内容的左或右侧对齐的图片（就像博客评论或 Twitter 消息等）。</p></td>
                    </tr>
				</tbody>
			</table>
		</div>
		</div>
        <!--GR-->	
	</div>
	<!--right_box-->
</div>
<!--content-->
<script>
$('th').wrapInner("<b></b>");
//process_btn
$('#process_btn button').click(function(){
	if($(this).hasClass('active')){
		$('#process_btn button').removeClass('active');
		$('.panel').css('display','block');
	}
	else{
		$('#process_btn button').removeClass('active');
		$(this).addClass('active');
		$('.panel').css('display','none');
		$('body').find('.panel').eq($(this).index()).css('display','block');
	};
});
//line_btn
$('#line_btn button').click(function(){
	$('#line_btn button').removeClass('active');
	$(this).addClass('active');
});
$(function (){$("[data-toggle='popover']").popover({html : true});});
$(function (){$('.pop_show').popover('show');});
$('.msg').click(function (){
	if($(this).parent().parent().next('tr').hasClass('msg_nothing')){
		$(this).parent().parent().next('tr').removeClass('msg_nothing');
		$(this).parent().parent().next('tr').addClass('msg_something');
		}
	else{
		$(this).parent().parent().next('tr').removeClass('msg_something');
		$(this).parent().parent().next('tr').addClass('msg_nothing');
		};
});
</script>
</body>
</html>