<%--
  Created by IntelliJ IDEA.
  User: arkad
  Date: 24.03.2017
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Vet Form</title>
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
    <h3>Save Vet</h3>

    <form:form action="saveVet" modelAttribute="vet" method="post">
        <form:hidden path="id"/>

    <table>
        <tbody>
        <tr>
            <td><label>First Name: </label></td>
            <td><form:input path="firstName"/></td>
        </tr>
        <tr>
            <td><label>Last Name: </label></td>
            <td><form:input path="lastName"/></td>
        </tr>
        <tr>
            <td><label>Experience: </label></td>
            <td><form:input path="experience"/></td>
        </tr>
        <tr>
            <td><label>Email: </label></td>
            <td><form:input path="email"/></td>
        </tr>
        <tr>
            <td><labe></labe></td>
            <td><input type="submit" value="Save" class="save"></td>
        </tr>

        </tbody>
    </table>

    <div style="clear: both;"></div>
    </form:form>
</body>
</html>
