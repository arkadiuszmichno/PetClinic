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
    <title>List of Visits</title>

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


        <input type="button" value="Add Visit"
               onclick="window.location.href='showFormForAdd'; return false;"
               class="add-button">

        <table>
            <tr>
                <th>Pet</th>
                <th>Date</th>
                <th>Description</th>
                <th>Vet</th>
                <th>Action</th>
            </tr>

            <c:forEach var="tempVisit" items="${visits}">
                <c:url var="updateVisit" value="/visit/showFormForUpdate">
                    <c:param name="visitId" value="${tempVisit.id}"/>
                </c:url>
                <c:url var="deleteVisit" value="/visit/deleteVisit">
                    <c:param name="visitId" value="${tempVisit.id}"/>
                </c:url>
                <tr>
                    <td>${tempVisit.pet.name}</td>
                    <td>${tempVisit.date}</td>
                    <td>${tempVisit.description}</td>
                    <td>${tempVisit.vet.firstName} ${tempVisit.vet.lastName}</td>
                    <td>
                        <a href="${updateVisit}">Update</a>
                        |
                        <a href="${deleteVisit}"
                           onclick="if(!(confirm('Are you sure you want to delete this Visit?'))) return false">Delete</a>
                    </td>

                </tr>
            </c:forEach>
        </table>

    </div>
</div>


</body>
</html>
