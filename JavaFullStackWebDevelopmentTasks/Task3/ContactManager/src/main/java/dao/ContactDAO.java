package dao;

import java.sql.SQLException;
import java.util.List;

import model.Contact;

public interface ContactDAO {
    void addContact(Contact contact) throws SQLException;
    List<Contact> getAllContacts() throws SQLException;
    List<Contact> searchContacts(String keyword) throws SQLException;
}
