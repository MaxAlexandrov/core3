package com.exchanger.model;

import javax.persistence.*;

@Entity
@Table(name = "message_type")
public class MessageType {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer id;
        private String type;

        public MessageType() {
        }

        public MessageType(String type) {
            this.type = type;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return "MessageType{" +
                    "id=" + id +
                    ", role='" + type + '\'' +
                    '}';
        }
}
