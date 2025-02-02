package com.example.It_Sphere.service.impl;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.example.It_Sphere.exception.CustomException;
import com.example.It_Sphere.model.domain.MyFile;
import com.example.It_Sphere.model.enums.FileType;
import com.example.It_Sphere.repository.MyFileRepository;
import com.example.It_Sphere.service.MyFileService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MyFileServiceImpl implements MyFileService {
    private final MyFileRepository myFileRepository;
    private final AmazonS3 s3;

    @Value("${application.bucket.name}")
    private String bucketName;

    @Override
    public MyFile save(MultipartFile file) {
        FileType fileType = determineFileType(file);

        File convertedFile = convertMultipartFileToFile(file);
        String fileName = System.currentTimeMillis() + convertedFile.getName();
        s3.putObject(new PutObjectRequest(bucketName, fileName, convertedFile)
                .withCannedAcl(CannedAccessControlList.PublicRead));

        boolean delete = convertedFile.delete();
        if (!delete) {
            throw new CustomException("File could not be deleted", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        MyFile myFile = new MyFile();
        myFile.setFileName(fileName);
        myFile.setFilePath(s3.getUrl(bucketName, fileName).toString());
        myFile.setType(fileType);

        return myFileRepository.save(myFile);
    }

    @Override
    @Transactional
    public void deleteFile(String fileName) {
        myFileRepository.deleteByFileName(fileName);
        s3.deleteObject(bucketName, fileName);
    }

    private File convertMultipartFileToFile(MultipartFile file) {
        File convertFile = new File(Objects.requireNonNull(file.getOriginalFilename()));

        try (FileOutputStream fos = new FileOutputStream(convertFile)) {
            fos.write(file.getBytes());
        } catch (Exception e) {
            throw new CustomException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return convertFile;
    }

    private FileType determineFileType(MultipartFile file) {
        String type = file.getContentType();

        if (type == null) {
            throw new CustomException("File is empty", HttpStatus.BAD_REQUEST);
        } else if (type.startsWith("image/")) {
            return FileType.IMAGE;
        } else if (type.startsWith("video/")) {
            return FileType.VIDEO;
        } else {
            throw new CustomException("File type not supported " + type, HttpStatus.BAD_REQUEST);
        }
    }
}
