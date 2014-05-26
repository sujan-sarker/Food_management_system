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

<div id ="table">

    <h1 style="text-align:center;"><fmt:message key="home.title"/></h1>



    <h1 style="text-align:center;">Meal List of Today</h1>

    <table border="1" align="center" class="table1">
        <tr>
            <td>Day</td>
            <td>Breakfast</td>
            <td>Lunch</td>
        </tr>

        <c:forEach var="meal" items="${mealList}">

            <c:if test="${((requestScope.currentDay).trim())== ((meal.getDayName()).trim())}">
            <tr>
                <td>
                    <c:out value="${meal.getDayName()}"/>
                </td>
                <td>
                    <p align="left"><c:out value="${meal.getBreakfastItem()}"/></p>

                </td>

                <td>
                    <p align="left"><c:out value="${meal.getLunchItem()}"/></p>
                </td>
            </tr>
            </c:if>

        </c:forEach>
    </table>

        <p align="right"><a href="/home.html">
           Meal List of this Week
        </a></p>

</div>

</body>

</html>