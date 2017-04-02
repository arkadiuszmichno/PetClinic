<%--
  Created by IntelliJ IDEA.
  User: arkad
  Date: 25.03.2017
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error page</title>
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
<h2>Can't add pet to Clinic, no more place</h2>
</body>
</html>
