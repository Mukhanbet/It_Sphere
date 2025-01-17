package com.example.It_Sphere.service.impl;

import com.example.It_Sphere.mapper.MaterialMapper;
import com.example.It_Sphere.model.dto.material.MaterialRequest;
import com.example.It_Sphere.model.dto.material.MaterialResponse;
import com.example.It_Sphere.repository.MaterialRepository;
import com.example.It_Sphere.service.MaterialService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MaterialServiceImpl implements MaterialService {
    private final MaterialRepository materialRepository;
    private final MaterialMapper materialMapper;

    @Override
    public MaterialResponse create(MaterialRequest materialRequest) {
        return materialMapper.toResponse(materialRepository.save(materialMapper.toMaterial(materialRequest)));
    }

    @Override
    public void delete(Long id) {
        materialRepository.deleteById(id);
    }

    @Override
    public List<MaterialResponse> all(int page, int size) {
        return materialMapper.toResponseList(materialRepository.findAll(PageRequest.of(page, size)).toList());
    }
}
