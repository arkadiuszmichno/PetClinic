<%--
  Created by IntelliJ IDEA.
  User: arkad
  Date: 22.03.2017
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Pet Form</title>
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
    <h3> Save Pet</h3>

    <form:form action="savePet" modelAttribute="pet" method="post">
        <form:hidden path="id"/>

        <table>
            <tbody>
            <tr>
                <td><label>Name: </label></td>
                <td><form:input path="name"/></td>
            </tr>
            <tr>
                <td><label>Type: </label></td>
                <td><form:input path="type"/></td>
            </tr>
            <tr>
                <td><label>Age: </label></td>
                <td><form:input path="age"/></td>
            </tr>
            <tr>
                <td><label>Owner: </label></td>
                <td><form:select path="ownerName">
                    <c:forEach var="tempOwner" items="${owners}">
                        <form:option value="${tempOwner.lastName}"
                                     label="${tempOwner.firstName} ${tempOwner.lastName}"/>
                    </c:forEach>
                </form:select> <input type="button" value="Add Owner"
                                      onclick="window.location.href='../owner/showFormForAdd'; return false;"
                                      class="add-button">
                </td>

            </tr>
            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Save" class="save"></td>
            </tr>
            </tbody>
        </table>

        <div style="clear: both;"></div>
    </form:form>
</div>
</body>
</html>
