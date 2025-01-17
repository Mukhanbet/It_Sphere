package com.example.It_Sphere.model.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "materials")
@Data
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    // todo: Use for this column an aws
    private String content;
    private String tags;
    private LocalDateTime createdAt;
}
