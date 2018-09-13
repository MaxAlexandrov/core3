package com.exchanger.model;

import javax.persistence.*;

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
    @OneToOne
    @JoinColumn(name = "id")
    private MessageType messageType;
    @OneToOne
    @JoinColumn(name = "id")
    private MessageStatus messageStatus;

    public Message() {
    }

    public Message(String textMessage) {
        this.textMessage = textMessage;
    }

    public Message(String textMessage, User userTo, User userFrom, MessageType messageType, MessageStatus messageStatus) {
        this.textMessage = textMessage;
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

    public String getTextMessage() {
        return textMessage;
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

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public MessageStatus getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(MessageStatus messageStatus) {
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
