package com.exchanger.model;

import javax.persistence.*;

@Entity
@Table(name = "message_status")
public class MessageStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String status;

    public MessageStatus() {
    }

    public MessageStatus(String status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "MessageStatus{" +
                "id=" + id +
                ", role='" + status + '\'' +
                '}';
    }
}
