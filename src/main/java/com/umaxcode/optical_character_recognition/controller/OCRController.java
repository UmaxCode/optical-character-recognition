package com.umaxcode.optical_character_recognition.controller;

import com.umaxcode.optical_character_recognition.service.OCRService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/convert-text-to-image")
@RequiredArgsConstructor
public class OCRController {

    private final OCRService ocrService;

    @PostMapping(value = "/tesseract")
    public String tesseractOCR(@RequestBody MultipartFile file) {

        return ocrService.tesseract(file);
    }
}
