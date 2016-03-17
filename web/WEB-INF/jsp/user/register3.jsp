<%--
  Created by IntelliJ IDEA.
  User: peng
  Date: 2/16/16
  Time: 11:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>注册用户</title>
</head>
<body>
    <form:form modelAttribute="user" action="/user/handle91.html">
        <form:errors path="*"/>
        <table>
            <tr>
                <td>用户名：</td>
                <td>
                    <form:errors path="userName" cssClass="errorClass"/>
                    <form:input path="userName"/>
                </td>
            </tr>
            <tr>
                <td>密码：</td>
                <td>
                    <form:errors path="password" cssClass="errorClass"/>
                    <form:input path="password"/>
                </td>
            </tr>
            <tr>
                <td>Credit：</td>
                <td>
                    <form:errors path="credits" cssClass="errorClass"/>
                    <form:input path="credits"/>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" name="提交"/>
                </td>
            </tr>
        </table>
    </form:form>
</body>
</html>
