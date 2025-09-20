<%@ page import="java.util.List" %>
<%@ page import="model.Contact" %>
<html>
<head>
    <title>Contacts</title>
</head>
<body>
    <h2>Contact List</h2>

    <!-- Link to add a new contact -->
    <p><a href="add-contact.jsp">+ Add New Contact</a></p>

    <!-- Search form -->
    <form action="contacts" method="get">
        <input type="text" name="search" placeholder="Search contacts...">
        <button type="submit">Search</button>
    </form>

    <!-- Table to display contacts -->
    <table border="1" cellpadding="5" cellspacing="0">
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Phone</th>
        </tr>
        <%
            List<Contact> contacts = (List<Contact>) request.getAttribute("contacts");
            if (contacts != null && !contacts.isEmpty()) {
                for (Contact c : contacts) {
        %>
        <tr>
            <td><%= c.getName() %></td>
            <td><%= c.getEmail() %></td>
            <td><%= c.getPhone() %></td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="3">No contacts found.</td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
