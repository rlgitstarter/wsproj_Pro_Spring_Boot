package com.habuma.contacts.repository;

import com.habuma.contacts.domain_model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ContactRepository {

    private JdbcTemplate jdbc;

    // Constructor
    @Autowired
    public ContactRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Contact> findAll() {
        return jdbc.query(
                "select id, firstName, lastName, phoneNumber, emailAddress " +
                        "from contacts order by lastName",
                new RowMapper<Contact>() {
                    @Override
                    public Contact mapRow(ResultSet rSet, int rowNum) throws SQLException {
                        Contact contact = new Contact();
                        contact.setId(rSet.getLong(1));
                        contact.setFirstName(rSet.getString(2));
                        contact.setLastName(rSet.getString(3));
                        contact.setPhoneNumber(rSet.getString(4));
                        contact.setEmailAddress(rSet.getString(5));
                        return contact;
                    }
                }
        );
    }

    public void save(Contact contact) {
        jdbc.update(
                "insert into contacts " +
                        "(firstName, lastName, phoneNumber, emailAddress) " +
                        "values (?, ?, ?, ?)",
                contact.getFirstName(), contact.getLastName(),
                contact.getPhoneNumber(), contact.getEmailAddress());
    }
}
