<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: arkad
  Date: 24.03.2017
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of Vets</title>

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

        <input type="button" value="Add Vet"
               onclick="window.location.href='showFormForAdd'; return false" class="add-button"/>

        <table>
            <tr>

                <th>First Name</th>
                <th>Last Name</th>
                <th>Experience</th>
                <th>Email</th>
                <th>Action</th>
            </tr>

            <c:forEach var="tempVet" items="${vets}">
                <c:url var="updateVet" value="/vet/showFormForUpdate">
                    <c:param name="vetId" value="${tempVet.id}"/>
                </c:url>
                <c:url var="deleteVet" value="/vet/deleteVet">
                    <c:param name="vetId" value="${tempVet.id}"/>
                </c:url>


                <tr>
                    <td>${tempVet.firstName}</td>
                    <td>${tempVet.lastName}</td>
                    <td>${tempVet.experience}</td>
                    <td>${tempVet.email}</td>
                    <td>
                        <a href="${updateVet}">Update</a>
                        |
                        <a href="${deleteVet}"
                           onclick="if(!(confirm('Are you sure you want to delete this vet?'))) return false">Delete</a>
                    </td>
                </tr>

            </c:forEach>
        </table>

    </div>
</div>


</body>
</html>
