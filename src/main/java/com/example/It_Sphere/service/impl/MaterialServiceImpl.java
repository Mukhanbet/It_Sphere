package com.example.It_Sphere.service.impl;

import com.example.It_Sphere.exception.CustomException;
import com.example.It_Sphere.mapper.MaterialMapper;
import com.example.It_Sphere.model.domain.Material;
import com.example.It_Sphere.model.domain.MyFile;
import com.example.It_Sphere.model.dto.material.MaterialRequest;
import com.example.It_Sphere.model.dto.material.MaterialResponse;
import com.example.It_Sphere.repository.MaterialRepository;
import com.example.It_Sphere.repository.MyFileRepository;
import com.example.It_Sphere.service.MaterialService;
import com.example.It_Sphere.service.MyFileService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class MaterialServiceImpl implements MaterialService {
    private final MaterialRepository materialRepository;
    private final MyFileRepository myFileRepository;
    private final MaterialMapper materialMapper;
    private final MyFileService myFileService;

    @Override
    public MaterialResponse create(MaterialRequest materialRequest, List<MultipartFile> files) {
        List<MyFile> fileList = new ArrayList<>();
        for (MultipartFile file : files) {
            fileList.add(myFileService.save(file));
        }

        Material material = materialRepository.save(materialMapper.toMaterial(materialRequest, fileList));
        for (MyFile file : fileList) {
            file.setMaterial(material);
        }
        myFileRepository.saveAll(fileList);

        return materialMapper.toResponse(material);
    }

    @Override
    public void delete(Long id) {
        Material material = materialRepository.findById(id).orElseThrow(() -> new CustomException("Material not found", HttpStatus.NOT_FOUND));
        for (MyFile file : material.getMyFiles()) {
            myFileService.deleteFile(file.getFileName());
        }

        materialRepository.deleteById(id);
    }

    @Override
    public List<MaterialResponse> all(int page, int size) {
        return materialMapper.toResponseList(materialRepository.findAll(PageRequest.of(page, size)).toList());
    }
}
