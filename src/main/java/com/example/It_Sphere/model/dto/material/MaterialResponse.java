package com.example.It_Sphere.model.dto.material;

import com.example.It_Sphere.model.dto.myFile.MyFileResponse;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class MaterialResponse {
    private String title;
    private String content;
    private String tags;
    private LocalDateTime createdAt;
    private List<MyFileResponse> files;
}
