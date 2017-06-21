package com.dh.project.project.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by DELL on 20/06/2017.
 */
@Entity
public class RegistryCarSold {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private Date dateOfShell;
    @ManyToOne
    private Seller seller;
    @ManyToOne
    private Client client;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateOfShell() {
        return dateOfShell;
    }

    public void setDateOfShell(Date dateOfShell) {
        this.dateOfShell = dateOfShell;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
