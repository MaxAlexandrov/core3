package com.exchanger.model;

import javax.persistence.*;

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String textMessage;
    private Integer userTo;
    private Integer userFrom;
    private Integer messageType;
    private Integer messageStatus;


    public Message() {
    }

    public Message(String textMessage) {
        this.textMessage = textMessage;
    }

    public Message(String textMessadge, Integer userTo, Integer userFrom, Integer messageType, Integer messageStatus) {
        this.textMessage = textMessadge;
        this.userTo = userTo;
        this.userFrom = userFrom;
        this.messageType = messageType;
        this.messageStatus = messageStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTextMessadge() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }

    public Integer getUserTo() {
        return userTo;
    }

    public void setUserTo(Integer userTo) {
        this.userTo = userTo;
    }

    public Integer getUserFrom() {
        return userFrom;
    }

    public void setUserFrom(Integer userFrom) {
        this.userFrom = userFrom;
    }

    public Integer getMessageType() {
        return messageType;
    }

    public void setMessageType(Integer messageType) {
        this.messageType = messageType;
    }

    public Integer getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(Integer messageStatus) {
        this.messageStatus = messageStatus;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", textMessage='" + textMessage + '\'' +
                ", userTo=" + userTo +
                ", userFrom=" + userFrom +
                ", messageType=" + messageType +
                ", messageStatus=" + messageStatus +
                '}';
    }
}
