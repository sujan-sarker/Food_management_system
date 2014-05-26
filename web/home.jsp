<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="en"/>
<fmt:setBundle basename="net.therap.props.messages"/>

<html>

<head>

    <title><fmt:message key="home.title"/></title>
    <link rel="stylesheet" type="text/css" href="style.css">

</head>

<body>

<div id="table">

    <h1 style="text-align:center;"><fmt:message key="home.title"/></h1>

    <table align="right">
        <tr>
            <c:choose>
                <c:when test="${verifiedUser.getUserType() == 1 }">
                    <td>You are Logged In as Admin :</td>
                    <td><b>${verifiedUser.userName}</b>.</td>
                </c:when>
                <c:otherwise>
                    <td>You are Logged In as User :</td>
                    <td><b>${verifiedUser.userName}</b>.</td>
                </c:otherwise>
            </c:choose>
        </tr>
        <tr>
            <td>
                <a href="/logout.html">Logout</a>
            </td>
        </tr>
    </table>
    </br></br>

    <h1 style="text-align:center;">Meal List of This Week</h1>

    <table border="1" align="center" class="table1">
        <tr>
            <td>Day</td>
            <td>Breakfast</td>
            <td>Lunch</td>
        </tr>
        <c:forEach var="meal" items="${mealList}">
            <tr>
                <td>
                    <c:out value="${meal.getDayName()}"/>
                </td>
                <td>
                    <p align="left"><c:out value="${meal.getBreakfastItem()}"/></p>
                    <c:if test="${verifiedUser.getUserType() == 1}">
                        <c:url value="edit_menu.html" var="displayURL">
                            <c:param name="dayId" value="${meal.getDayId()}"/>
                            <c:param name="mealType" value="breakfast"/>
                        </c:url>
                        <p align="right"><a href='<c:out value="${displayURL}" />'>
                            Edit
                        </a></p>
                    </c:if>
                </td>

                <td>
                    <p align="left"><c:out value="${meal.getLunchItem()}"/></p>
                    <c:if test="${verifiedUser.getUserType() == 1}">
                        <c:url value="edit_menu.html" var="displayURL">
                            <c:param name="dayId" value="${meal.getDayId()}"/>
                            <c:param name="mealType" value="lunch"/>
                        </c:url>
                        <p align="right"><a href='<c:out value="${displayURL}" />'>
                            Edit
                        </a></p>
                    </c:if>
                </td>
            </tr>

        </c:forEach>
    </table>

    <c:if test="${verifiedUser.getUserType() == 1 }">
        <p align="right"><a href="/count_user.html">
            view logged in user
        </a></p>
    </c:if>

    <c:if test="${verifiedUser.getUserType() == 0 }">
        <p align="right"><a href="/current_day.html">
            view Today's List
        </a></p>
    </c:if>

</div>

</body>

</html>