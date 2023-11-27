package com.VirtualVision.VirtualVision.domain;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
@Table(name = "Message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chat_id", nullable = false)
    private Chat chat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "content", length = 1000)
    private String content; // Contenido del mensaje

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "sent_at")
    private Date sentAt; // Fecha y hora de envío

    public Message() {
        // Constructor vacío necesario para JPA
    }

    // Aquí agregar métodos constructores, getters y setters
}