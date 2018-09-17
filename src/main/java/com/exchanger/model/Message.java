package com.exchanger.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String textMessage;
    @OneToOne
    @JoinColumn(name = "id")
    private User userTo;
    @OneToOne
    @JoinColumn(name = "id")
    private User userFrom;
    private Date dateSend;
    private Date dateGet;

    public Message() {
    }

    public Message(String textMessage, User userTo, User userFrom, Date dateSend, Date dateGet) {
        this.textMessage = textMessage;
        this.userTo = userTo;
        this.userFrom = userFrom;
        this.dateSend = dateSend;
        this.dateGet = dateGet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }

    public User getUserTo() {
        return userTo;
    }

    public void setUserTo(User userTo) {
        this.userTo = userTo;
    }

    public User getUserFrom() {
        return userFrom;
    }

    public void setUserFrom(User userFrom) {
        this.userFrom = userFrom;
    }

    public Date getDateSend() {
        return dateSend;
    }

    public void setDateSend(Date dateSend) {
        this.dateSend = dateSend;
    }

    public Date getDateGet() {
        return dateGet;
    }

    public void setDateGet(Date dateGet) {
        this.dateGet = dateGet;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", textMessage='" + textMessage + '\'' +
                ", userTo=" + userTo +
                ", userFrom=" + userFrom +
                ", dateSend=" + dateSend +
                ", dateGet=" + dateGet +
                '}';
    }
}
