<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	首页!  

</h1>

<P>  The time on the server is ${serverTime}. </P>
<P>  
<shiro:user>
    欢迎[<shiro:principal property="username"/>]登录<br/>
</shiro:user>
</P>
</body>
</html>
