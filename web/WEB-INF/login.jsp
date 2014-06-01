<%--
  Created by IntelliJ IDEA.
  User: sujan.sarkar
  Date: 5/20/14
  Time: 12:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="en"/>
<fmt:setBundle basename="net.therap.props.messages"/>

<html>

<head>
    <title><fmt:message key="login.title"/></title>

    <link rel="stylesheet" type="text/css" href="<c:url value="/style.css"/>
">
</head>

<body>
<div id="login">
    <h2>Food Management System</h2>

    <form action="login.html" method="POST">

        <fieldset>
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
                <tr>
                    <c:if test="${requestScope.message ne null }">
                        <p style="color: red"><c:out value="${requestScope.message}">
                        </c:out></p>
                    </c:if>

                </tr>

            </table>
        </fieldset>

    </form>

</div>
</body>
</html>