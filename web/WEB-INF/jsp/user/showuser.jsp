<%--
  Created by IntelliJ IDEA.
  User: peng
  Date: 2/16/16
  Time: 11:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>宝宝淘论坛登录</title>
</head>
<body>
    <c:if test="${!empty error}">
      <font color="red"><c:out value="${error}"/></font>
    </c:if>
    <form action="<c:url value="/user/handle91.html"/>" method="post">
      用户名：
      <input type="text" name="userName">
      <br>
      密码：
      <input type="text" name="password">
      <br>
        credits：
        <input type="text" name="credits">
        <br>
      <input type="submit" value="登录"/>
      <input type="reset" value="重置"/>
    </form>
</body>
</html>
