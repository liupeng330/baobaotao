<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>宝宝淘论坛登录</title>
</head>
<body>
<form action="<c:url value="/user/upload"/>" method="post" enctype="multipart/form-data">
    <input type="text" name="name">
    <br>
    <input type="file" name="file">
    <br>
    <input type="submit" value="upload"/>
</form>
</body>
</html>