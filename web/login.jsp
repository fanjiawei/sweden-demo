<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title></title>
</head>
<body>
<form method="post">
    <div><label>username:</label><input name="username"></div>
    <div><label>password:</label><input type="password" name="password"/> </div>
    <div><label><input type="checkbox" name="rememberMe" />remember me </label></div>
    <div><button type="submit">提交</button> </div>
</form>
</body>
</html>
