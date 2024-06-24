package com.crud.controller;

import com.crud.entity.ColorEntity;
import com.crud.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/colors")
public class ColorController {

    @Autowired
    private ColorService colorService;

    @Value("${spring.servlet.multipart.max-file-size}")
    private String maxFileSize;

    @Value("${spring.servlet.multipart.max-request-size}")
    private String maxRequestSize;

    @PostMapping("/save")
    public ResponseEntity<?> saveColors(
            @RequestParam("image") MultipartFile image,
            @RequestParam("imageFileName") String imageFileName,
            @RequestParam("hexCodes") List<String> hexCodes
    ) {
        try {
            // Save image and associated colors using service method
            colorService.saveImageAndColors(image, imageFileName, hexCodes);

            return ResponseEntity.ok("Colors and image saved successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error saving colors and image: " + e.getMessage());
        }
    }
}
