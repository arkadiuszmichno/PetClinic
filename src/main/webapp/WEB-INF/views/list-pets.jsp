<%--
  Created by IntelliJ IDEA.
  User: arkad
  Date: 22.03.2017
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pets List</title>

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

        <input type="button" value="Add Pet"
               onclick="window.location.href='showFormForAdd'" ; return false;
               class="add-button"/>

        <table>
            <tr>
                <th>Name</th>
                <th>Type</th>
                <th>Age</th>
                <th>Owner</th>
                <th>Action</th>
            </tr>

            <c:forEach var="tempPet" items="${pets}">
                <c:url var="updateLink" value="/pet/showFormForUpdate">
                    <c:param name="petId" value="${tempPet.id}"/>
                </c:url>

                <c:url var="deleteLink" value="/pet/deletePet">
                    <c:param name="petId" value="${tempPet.id}"/>
                </c:url>

                <tr>
                    <td>${tempPet.name}</td>
                    <td>${tempPet.type}</td>
                    <td>${tempPet.age}</td>
                    <td>${tempPet.owner.firstName} ${tempPet.owner.lastName}</td>
                    <td>
                        <a href="${updateLink}">Update</a>
                        |
                        <a href="${deleteLink}"
                                        onclick="if(!(confirm('Are you sure you want to delete this pet?'))) return false">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

</body>
</html>
