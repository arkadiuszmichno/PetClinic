<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: arkad
  Date: 24.03.2017
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Visit Form</title>
    <link rel="stylesheet"
          href="<%=request.getContextPath()%>/resources/css/style.css"/>
    <link rel="stylesheet"
          href="<%=request.getContextPath()%>/resources/css/add-customer-style.css"/>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.6/jquery.min.js" type="text/javascript"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js" type="text/javascript"></script>
    <link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="Stylesheet" type="text/css" />

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
    <h3>Save Visit</h3>



    <form:form action="saveVisit" modelAttribute="visit" method="post">
        <form:hidden path="id"/>


        <table>
            <tbody>
            <tr>
                <td><label>Pet: </label></td>
                <td><form:select path="petName">
                    <c:forEach var="tempPet" items="${pets}">
                        <form:option value="${tempPet.name}" label="${tempPet.name}"/>
                    </c:forEach>
                </form:select> </td>
            </tr>
            <tr>
                <td><label>Date: </label></td>
            <td><form:input path="date" id="datepicker" /></td>
            <script>
                $(function() {
                    $("#datepicker").datepicker();
                });
            </script>
            </tr>
            <tr>
                <td><label>Description: </label></td>
                <td><form:input path="description"/></td>
            </tr>
            <tr>
                <td><label>Vet: </label></td>
                <td><form:select path="vetName">
                    <c:forEach var="tempVet" items="${vets}">
                        <form:option value="${tempVet.lastName}" label="${tempVet.firstName} ${tempVet.lastName}"/>
                    </c:forEach>
                </form:select> </td>
            </tr>
            <tr>
                <td>

                </td>
            </tr>
            <tr>
                <td><labe></labe></td>
                <td><input type="submit" value="Save" class="save"></td>
            </tr>

            </tbody>
        </table>

        <div style="clear: both;"></div>
    </form:form>

</div>

</body>
</html>
