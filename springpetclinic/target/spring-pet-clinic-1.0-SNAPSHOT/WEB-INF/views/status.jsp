<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: arkad
  Date: 24.03.2017
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Status</title>
    <link rel="stylesheet"
          href="<%=request.getContextPath()%>/resources/css/style.css"/>
    <link rel="stylesheet"
          href="<%=request.getContextPath()%>/resources/css/add-customer-style.css"/>
</head>
<body>
<div id="topbar" class="bar">
    <a href="/pet/list">Pets</a>
    <a href="/owner/list">Owners</a>
    <a href="/vet/list">Vets</a>
    <a href="/visit/list">Visits</a>
    <a href="/status/showStatus">Status</a>
</div>

<div id="container">
    <h2>Pet Clinic Status</h2>

    <form:form action="/status/sendMail" modelAttribute="mailData" method="post">
        <table>
            <tbody>
            <tr>
                <td>Vacancies: ${vacancies}</td>
            </tr>
            <tr>
                <td>Send Mail to Vets:</td>
            </tr>
            <c:forEach var="tempVet" varStatus="status" items="${mailData.theVets}">
                <tr>
                    <td><form:hidden path="theVets[${status.index}].id"/></td>
                    <td>${tempVet.firstName} ${tempVet.lastName}
                        <form:checkbox path="theMailVets[${status.index}].email" id="${tempVet.id}" value="${tempVet.email}"/>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td><label>Subject: </label></td>
                <td><form:input path="subject"/></td>
            </tr>
            <tr>
                <td><label>Text: </label></td>
                <td><form:textarea rows="10" cols="50" path="text"/></td>
            </tr>
            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Send Mail" class="save"></td>
            </tr>
            </tbody>
        </table>
        <div style="clear: both;"></div>

    </form:form>
</div>
</body>
</html>
