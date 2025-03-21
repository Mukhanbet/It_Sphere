package com.example.It_Sphere.model.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "feedbacks")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user_email", referencedColumnName = "email")
    private User user;
}
