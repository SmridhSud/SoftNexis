<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Contacts</title>
</head>
<body>
    <h1>Contacts</h1>

    <c:set var="contacts" value="${sessionScope.contacts}" />

    <c:if test="${empty contacts}">
        <p>No contacts yet. <a href="${pageContext.request.contextPath}/contacts/add">Add one</a>.</p>
    </c:if>

    <c:if test="${not empty contacts}">
        <table border="1" cellpadding="5">
            <tr>
                <th>ID</th><th>Name</th><th>Email</th><th>Phone</th>
            </tr>
            <c:forEach var="c" items="${contacts}">
                <tr>
                    <td>${c.id}</td>
                    <td>${c.name}</td>
                    <td>${c.email}</td>
                    <td>${c.phone}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

    <p><a href="${pageContext.request.contextPath}/contacts/add">Add New Contact</a></p>
</body>
</html>
