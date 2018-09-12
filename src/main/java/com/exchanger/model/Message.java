package com.exchanger.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String textMessadge;

    public Message() {
    }

    public Message(String textMessadge) {
        this.textMessadge = textMessadge;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTextMessadge() {
        return textMessadge;
    }

    public void setTextMessadge(String textMessadge) {
        this.textMessadge = textMessadge;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", textMessadge='" + textMessadge + '\'' +
                '}';
    }
}
