<html>
<head>
  <title>Add Contact</title>
</head>
<body>
  <h2>Add New Contact</h2>
  <form action="contacts" method="post">
    <label>Name:</label>
    <input type="text" name="name" required><br><br>

    <label>Email:</label>
    <input type="email" name="email" required><br><br>

    <label>Phone:</label>
    <input type="text" name="phone"><br><br>

    <button type="submit">Save Contact</button>
  </form>

  <p><a href="contacts">Back to Contact List</a></p>
</body>
</html>
