package com.apress.spring.domain_model;

/*
* Because you are using the JPA technology, you need to use the @Entity, @Id, and @GeneratedValue annotations
* so this class gets marked as JPA entity and can be persisted to the database.
* Anm.: @Table und @Column hier nicht dabei - ev. hat's mit h2 DB zu tun. Wäre z.B. bei PostgreSQL DB nötig.
 * */

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Journal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private Date created;
    private String summary;

    @Transient
    private SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");

    /*
    * This class has two constructors, one with no arguments and is needed for the JPA engine
    * and the other with some arguments that you are going to use to populate the database.
    * */
    public Journal() {

    }

    public Journal(String title, String date, String summary) throws ParseException {
        this.title = title;
        this.created = format.parse(date);
        this.summary = summary;
    }

    /* Standard Getter + Setter */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    /* toString Impl. */
    @Override
    public String toString() {
        return "Journal{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", created=" + created +
                ", summary='" + summary + '\'' +
                '}';
    }

    /* Datums-Formatierung */
    public String getCreatedAsShort() {
        return format.format(created);
    }
}
