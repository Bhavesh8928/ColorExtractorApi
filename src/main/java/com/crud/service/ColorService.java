package com.crud.service;

import com.crud.entity.ColorEntity;
import com.crud.repository.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ColorService {

    @Autowired
    private ColorRepository colorRepository;

    @Transactional
    public void saveImageAndColors(MultipartFile image, String imageFileName, List<String> hexCodes) throws IOException {
        // Save image (if required)
        saveImage(image, imageFileName); // Example method for saving image to file system

        // Save colors to database
        saveColors(imageFileName, hexCodes);
    }

    private void saveImage(MultipartFile image, String imageFileName) throws IOException {
        // Implement logic to save image to file system or cloud storage if needed
        // Example: Save to file system
        // Path imagePath = Paths.get("/path/to/save/" + imageFileName);
        // Files.write(imagePath, image.getBytes());
    }

    private void saveColors(String imageFileName, List<String> hexCodes) {
        // Save colors to database
        ColorEntity colorEntity = new ColorEntity();
        colorEntity.setImageFileName(imageFileName);
        colorEntity.setHexCodes(String.join(",", hexCodes)); // Convert hexCodes to comma-separated string
        colorRepository.save(colorEntity);
    }
}
