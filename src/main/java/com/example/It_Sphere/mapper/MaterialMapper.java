package com.example.It_Sphere.mapper;

import com.example.It_Sphere.model.domain.Material;
import com.example.It_Sphere.model.domain.MyFile;
import com.example.It_Sphere.model.dto.material.MaterialRequest;
import com.example.It_Sphere.model.dto.material.MaterialResponse;

import java.util.List;

public interface MaterialMapper {
    Material toMaterial(MaterialRequest request, List<MyFile> files);
    MaterialResponse toResponse(Material material);
    List<MaterialResponse> toResponseList(List<Material> materialList);
}
