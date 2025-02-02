package com.example.It_Sphere.service;

import com.example.It_Sphere.model.domain.MyFile;
import org.springframework.web.multipart.MultipartFile;

public interface MyFileService {
    MyFile save(MultipartFile file);
    void deleteFile(String fileName);
}
