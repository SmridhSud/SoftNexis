<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add Contact</title>
</head>
<body>
    <h1>Add Contact</h1>

    <c:if test="${not empty errors['dup']}">
        <p style="color:red">${errors['dup']}</p>
    </c:if>

    <form method="post" action="${pageContext.request.contextPath}/contacts">
        Name: <input type="text" name="name" value="${name}"/>
        <c:if test="${not empty errors['name']}"><span style="color:red">${errors['name']}</span></c:if>
        <br/>

        Email: <input type="text" name="email" value="${email}"/>
        <c:if test="${not empty errors['email']}"><span style="color:red">${errors['email']}</span></c:if>
        <br/>

        Phone: <input type="text" name="phone" value="${phone}"/>
        <c:if test="${not empty errors['phone']}"><span style="color:red">${errors['phone']}</span></c:if>
        <br/>

        <button type="submit">Submit</button>
    </form>

    <p><a href="${pageContext.request.contextPath}/contacts">Back to list</a></p>
</body>
</html>
