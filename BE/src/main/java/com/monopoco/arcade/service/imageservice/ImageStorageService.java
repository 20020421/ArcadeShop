package com.monopoco.arcade.service.imageservice;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageStorageService {

    public Long uploadImage(MultipartFile file) throws IOException;

    public byte[] downloadImage(Long id);
}
