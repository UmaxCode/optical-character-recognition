package com.umaxcode.optical_character_recognition.service;

import lombok.extern.slf4j.Slf4j;
import org.bytedeco.javacpp.lept;
import org.bytedeco.javacpp.tesseract;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@Slf4j
public class OCRService {

    @Value("${application.tessDataPath}")
    private String tessDataPath;


    public String tesseract(MultipartFile file) {

        log.info("Tesseract data path: {}", tessDataPath);

        tesseract.TessBaseAPI api = new tesseract.TessBaseAPI();
        if (api.Init(tessDataPath, "eng") != 0) {
            log.error("Could not init tesseract.");
            System.exit(1);
        }

        api.SetImage((lept.PIX) file);
        api.close();
        return api.GetUTF8Text().getString();
    }
}
