package com.example.It_Sphere.repository;

import com.example.It_Sphere.model.domain.MyFile;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MyFileRepository extends JpaRepository<MyFile, Long> {
    Optional<MyFile> findByFileName(String fileName);
    @Transactional
    void deleteByFileName(String fileName);
}
