package com.softnexis.servlet;

import com.softnexis.model.Contact;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ContactServlet", urlPatterns = {"/contacts", "/contacts/add"})
public class ContactServlet extends HttpServlet {

    @SuppressWarnings("unchecked")
    private List<Contact> getContactsList(HttpSession session) {
        List<Contact> contacts = (List<Contact>) session.getAttribute("contacts");
        if (contacts == null) {
            contacts = new ArrayList<>();
            session.setAttribute("contacts", contacts);
        }
        return contacts;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String path = req.getRequestURI();
            HttpSession session = req.getSession(true);
            getContactsList(session);

            if (path.endsWith("/add")) {
                req.getRequestDispatcher("/WEB-INF/views/contact-form.jsp").forward(req, resp);
            } else {
                req.getRequestDispatcher("/WEB-INF/views/contact-list.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            log("ContactServlet error", e);
            req.setAttribute("error", "Internal server error");
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            req.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(req, resp);
        }
    }
}
