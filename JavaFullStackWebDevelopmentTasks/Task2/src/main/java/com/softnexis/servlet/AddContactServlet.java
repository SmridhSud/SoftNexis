package com.softnexis.servlet;

import com.softnexis.model.Contact;
import com.softnexis.util.ValidationUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "AddContactServlet", urlPatterns = {"/contacts"})
public class AddContactServlet extends HttpServlet {

    @SuppressWarnings("unchecked")
    private List<Contact> getContactsList(HttpSession session) {
        List<Contact> contacts = (List<Contact>) session.getAttribute("contacts");
        if (contacts == null) {
            contacts = new java.util.ArrayList<>();
            session.setAttribute("contacts", contacts);
        }
        return contacts;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");
            String name = req.getParameter("name");
            String email = req.getParameter("email");
            String phone = req.getParameter("phone");

            Map<String, String> errors = ValidationUtil.validateContact(name, email, phone);

            HttpSession session = req.getSession(true);
            List<Contact> contacts = getContactsList(session);
            boolean duplicate = contacts.stream()
                .anyMatch(c -> c.getEmail().equalsIgnoreCase(email != null ? email.trim() : "") ||
                               (phone != null && !phone.trim().isEmpty() && phone.trim().equals(c.getPhone())));
            if (duplicate) {
                errors.put("dup", "A contact with same email or phone already exists");
            }

            if (!errors.isEmpty()) {
                req.setAttribute("errors", errors);
                req.setAttribute("name", name);
                req.setAttribute("email", email);
                req.setAttribute("phone", phone);
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                req.getRequestDispatcher("/WEB-INF/views/contact-form.jsp").forward(req, resp);
                return;
            }

            Contact contact = new Contact(name.trim(), email.trim(), phone == null ? "" : phone.trim());
            contacts.add(contact);

            resp.sendRedirect(req.getContextPath() + "/contacts?success=1");
        } catch (Exception e) {
            log("Unexpected error in AddContactServlet", e);
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Internal server error");
        }
    }
}
