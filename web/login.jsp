<%--
  Created by IntelliJ IDEA.
  User: sujan.sarkar
  Date: 5/20/14
  Time: 12:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en"/>
<fmt:setBundle basename="net.therap.props.messages"/>

<html>
<head>
    <title><fmt:message key="login.title"/></title>
</head>

<body>
<div style="width: 400px; margin-left: auto; margin-right: auto; margin-top: 100px;">
    <h2 align="center" >Food Management System</h2>
    <form action="/login.html" method="POST">
        <fieldset>
            <legend>Login</legend>
            <table aling="center">
                <tr>
                    <td><fmt:message key="login.userName"/></td>
                    <td><input type="text" name="userName"/></td>
                </tr>

                <tr>
                    <td><fmt:message key="login.password"/></td>
                    <td><input type="password" name="password"/></td>
                </tr>

                <tr>
                    <td><input type="submit" value="login"/></td>
                </tr>

            </table>
        </fieldset>

    </form>
</div>
</body>
</html>