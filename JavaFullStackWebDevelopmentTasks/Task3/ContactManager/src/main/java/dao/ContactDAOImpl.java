package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import model.Contact;

public class ContactDAOImpl implements ContactDAO {
    private final DataSource dataSource;

    public ContactDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void addContact(Contact contact) throws SQLException {
        String sql = "INSERT INTO contacts (name, email, phone) VALUES (?, ?, ?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, contact.getName());
            stmt.setString(2, contact.getEmail());
            stmt.setString(3, contact.getPhone());
            stmt.executeUpdate();
        }
    }

    @Override
    public List<Contact> getAllContacts() throws SQLException {
        String sql = "SELECT * FROM contacts ORDER BY created_at DESC";
        List<Contact> contacts = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Contact c = new Contact();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                c.setEmail(rs.getString("email"));
                c.setPhone(rs.getString("phone"));
                c.setCreatedAt(rs.getTimestamp("created_at"));
                contacts.add(c);
            }
        }
        return contacts;
    }

    @Override
    public List<Contact> searchContacts(String keyword) throws SQLException {
        String sql = "SELECT * FROM contacts WHERE LOWER(name) LIKE LOWER(?) OR LOWER(email) LIKE LOWER(?)";
        List<Contact> contacts = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            String like = "%" + keyword + "%";
            stmt.setString(1, like);
            stmt.setString(2, like);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Contact c = new Contact();
                    c.setId(rs.getInt("id"));
                    c.setName(rs.getString("name"));
                    c.setEmail(rs.getString("email"));
                    c.setPhone(rs.getString("phone"));
                    c.setCreatedAt(rs.getTimestamp("created_at"));
                    contacts.add(c);
                }
            }
        }
        return contacts;
    }
}
