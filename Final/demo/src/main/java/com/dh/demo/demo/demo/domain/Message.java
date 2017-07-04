package com.dh.demo.demo.demo.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * Created by DELL on 29/06/2017.
 */
@Entity
public class Message {
    @Id
    private Long id;
    private String content;
    @ManyToOne
    Status status;
    private Date creation_date;
    @ManyToOne
    User userMessage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public User getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(User userMessage) {
        this.userMessage = userMessage;
    }
}
