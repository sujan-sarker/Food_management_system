<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="en"/>
<fmt:setBundle basename="net.therap.props.messages"/>
<html>
<head><title><fmt:message key="home.title"/></title></head>
<body>
<div>
    <h1 style="text-align:center;"><fmt:message key="home.title"/></h1>
    <table>
        <tr>
            <td>You are LoggedIn as :</td>
            <td><b>${verifiedUser.userName}</b>.</td>
        </tr>
        <tr>
            <td>
                <a href="/logout.html">Logout</a>
            </td>
        </tr>
    </table>

    <h1 allign="center">Meal List of This Weak</h1>

    <table border="1">
        <tr>
            <th>Day</th>
            <th>Breakfast</th>
            <th>Lunch</th>
        </tr>
        <c:forEach var="i" items="${mealList}">
            <tr>
                <td>
                    <c:out value="${i.dayId}"/>
                </td>
                <td>
                    <c:out value="${i.breakfastItem}"/>
                </td>
                <td>
                    <c:out value="${i.lunchItem}"/>
                </td>
            </tr>

        </c:forEach>

    </table>

</div>
</body>
</html>