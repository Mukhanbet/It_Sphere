package com.example.It_Sphere.service;

import com.example.It_Sphere.model.dto.material.MaterialRequest;
import com.example.It_Sphere.model.dto.material.MaterialResponse;

import java.util.List;

public interface MaterialService {
    MaterialResponse create(MaterialRequest materialRequest);
    void delete(Long id);
    List<MaterialResponse> all(int page, int size);
}
