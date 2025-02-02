package com.example.It_Sphere.model.domain;

import com.example.It_Sphere.model.enums.FileType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "files")
public class MyFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String fileName;
    @Column(unique = true, nullable = false)
    private String filePath;

    @Enumerated(EnumType.STRING)
    private FileType type;

    @ManyToOne
    @JoinColumn
    private Material material;
}
