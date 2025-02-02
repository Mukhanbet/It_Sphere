package com.example.It_Sphere.mapper.impl;

import com.example.It_Sphere.mapper.MaterialMapper;
import com.example.It_Sphere.model.domain.Material;
import com.example.It_Sphere.model.domain.MyFile;
import com.example.It_Sphere.model.dto.material.MaterialRequest;
import com.example.It_Sphere.model.dto.material.MaterialResponse;
import com.example.It_Sphere.model.dto.myFile.MyFileResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class MaterialMapperImpl implements MaterialMapper {
    @Override
    public Material toMaterial(MaterialRequest request, List<MyFile> files) {
        Material material = new Material();
        material.setTitle(request.getTitle());
        material.setContent(request.getContent());
        material.setTags(request.getTags());
        material.setCreatedAt(LocalDateTime.now());
        material.setMyFiles(files);
        return material;
    }

    @Override
    public MaterialResponse toResponse(Material material) {
        MaterialResponse response = new MaterialResponse();
        response.setTitle(material.getTitle());
        response.setContent(material.getContent());
        response.setTags(material.getTags());
        response.setCreatedAt(material.getCreatedAt());
        if (material.getMyFiles() != null) {
            List<MyFileResponse> filesResponse = new ArrayList<>();

            for (MyFile file : material.getMyFiles()) {
                MyFileResponse fileResponse = new MyFileResponse();
                fileResponse.setFileName(file.getFileName());
                fileResponse.setFilePath(file.getFilePath());
                fileResponse.setFileType(file.getType().toString());
                filesResponse.add(fileResponse);
            }

            response.setFiles(filesResponse);
        }
        return response;
    }

    @Override
    public List<MaterialResponse> toResponseList(List<Material> materialList) {
        List<MaterialResponse> responseList = new ArrayList<>();
        for (Material material : materialList) {
            responseList.add(toResponse(material));
        }
        return responseList;
    }
}