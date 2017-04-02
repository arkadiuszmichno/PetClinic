<%--
  Created by IntelliJ IDEA.
  User: arkad
  Date: 22.03.2017
  Time: 23:27
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of Owners</title>

    <link rel="stylesheet"
          href="<%=request.getContextPath()%>/resources/css/style.css"/>
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
    <div id="content">


        <input type="button" value="Add Owner"
               onclick="window.location.href='showFormForAdd'; return false;"
               class="add-button">

        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Phone Number</th>
                <th>Email</th>
                <th>Pets</th>
                <th>Action</th>
            </tr>

            <c:forEach var="tempOwner" items="${owners}">
                <c:url var="updateOwner" value="/owner/showFormForUpdate">
                    <c:param name="ownerId" value="${tempOwner.id}"/>
                </c:url>
                <c:url var="deleteOwner" value="/owner/deleteOwner">
                    <c:param name="ownerId" value="${tempOwner.id}"/>
                </c:url>
                <tr>
                    <td>${tempOwner.firstName}</td>
                    <td>${tempOwner.lastName}</td>
                    <td>${tempOwner.phoneNumber}</td>
                    <td>${tempOwner.email}</td>
                    <td>
                        <c:forEach var="tempPet" items="${tempOwner.pets}">
                            ${tempPet.name},
                        </c:forEach>
                    </td>
                    <td>
                        <a href="${updateOwner}">Update</a>
                        |
                        <a href="${deleteOwner}"
                                    onclick="if(!(confirm('Are you sure you want to delete this Owner?'))) return false">Delete</a>
                    </td>

                </tr>
            </c:forEach>
        </table>

    </div>
</div>


</body>
</html>
