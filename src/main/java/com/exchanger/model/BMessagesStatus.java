package com.exchanger.model;

import javax.persistence.*;

@Entity
@Table(name = "b_message_status")
public class BMessagesStatus {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer id;
        private Integer message_id;
        private Integer status_id;

    public BMessagesStatus() {
    }

    public BMessagesStatus(Integer message_id, Integer status_id) {
        this.message_id = message_id;
        this.status_id = status_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMessage_id() {
        return message_id;
    }

    public void setMessage_id(Integer message_id) {
        this.message_id = message_id;
    }

    public Integer getStatus_id() {
        return status_id;
    }

    public void setStatus_id(Integer status_id) {
        this.status_id = status_id;
    }

    @Override
    public String toString() {
        return "BMessagesStatus{" +
                "id=" + id +
                ", message_id=" + message_id +
                ", status_id=" + status_id +
                '}';
    }
}
