@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String phone = request.getParameter("phone");

    model.Contact contact = new model.Contact();
    contact.setName(name);
    contact.setEmail(email);
    contact.setPhone(phone);

    try {
        contactDAO.addContact(contact);
        // Redirect back to contact list after adding
        response.sendRedirect("contacts");
    } catch (Exception e) {
        throw new ServletException("Error adding contact", e);
    }
}
