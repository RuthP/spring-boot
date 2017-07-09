package com.dh.demo.demo.demo.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by DELL on 17/06/2017.
 */
@Entity
@Table(name="groups")
public class Group {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @JoinColumn(name="owner_id")
    @ManyToOne
    private User owner;

    @Column(name="logo")
    private String logo;

    @Column(name="name")
    private String name;

    @Column(name="createdate")
    private Date createdate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}
