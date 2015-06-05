<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String contextPath = pageContext.getServletContext().getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>GR评审系统</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="author" content="Web Layout:Silence">
<link href="<%=contextPath%>/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=contextPath%>/resources/css/css.css" rel="stylesheet">
<script type="text/javascript" src="<%=contextPath%>/resources/js/comm/jquery.min.js"></script>
<script type="text/javascript" src="<%=contextPath%>/resources/js/comm/bootstrap.min.js"></script>
</head>

<body class="login">

<div id="login">
	<h2>Git Review</h2> 
    <form class="form-horizontal" action="" method="post">
      <div class="form-group">
        <label for="inputEmail3" class="col-xs-3 control-label text-right">Email</label>
        <div class="col-xs-9">
          <input type="email" class="form-control" id="inputEmail3" placeholder="name@cyou-inc.com" name="name" required>
        </div>
      </div>
      <div class="form-group">
        <label for="inputPassword3" class="col-xs-3 control-label  text-right">Password</label>
        <div class="col-xs-9">
          <input type="password" class="form-control" id="inputPassword3" placeholder="password" name="password" required>
        </div>
      </div>
      <div class="form-group">
        <div class="col-xs-offset-3 col-sm-9">
          <div class="checkbox">
            <label>
              <input type="checkbox" checked name="rememberMe">Remember me
            </label>
          </div>
        </div>
      </div>
      <c:if test="${not empty error}">
      <div class="form-group">
        <div class="col-xs-offset-3 col-sm-9"><p><span class="glyphicon glyphicon-exclamation-sign"></span>&nbsp;${error}</p></div>
      </div>
      </c:if>
      <div class="form-group">
        <div class="col-xs-offset-3 col-sm-9">
          <button type="submit" class="btn btn-danger btn-block">Sign in</button>
        </div>
      </div>
    </form>
</div>
<footer>
	<p>系统意见反馈请联系 TEL：927674 MAIL：wangfangfang_yy@cyou-inc.com</p>
</footer>
<script>
</script>
</body>
</html>