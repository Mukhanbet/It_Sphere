package com.example.It_Sphere.controller;

import com.example.It_Sphere.model.dto.material.MaterialRequest;
import com.example.It_Sphere.model.dto.material.MaterialResponse;
import com.example.It_Sphere.service.MaterialService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/materials")
public class MaterialController {
    private final MaterialService materialService;

    @PostMapping
    public MaterialResponse create(
            @RequestPart MaterialRequest request,
            @RequestPart(required = false) List<MultipartFile> files
    ) {
        return materialService.create(request, files);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        materialService.delete(id);
    }

    @GetMapping
    public List<MaterialResponse> all(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return materialService.all(page, size);
    }
}
