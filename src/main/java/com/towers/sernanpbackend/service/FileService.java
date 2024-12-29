package com.towers.sernanpbackend.service;

import jakarta.annotation.PostConstruct;
import net.sourceforge.tess4j.Tesseract;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;
import java.io.File;

@Service
public class FileService {
    private final Tesseract tesseract;

    @Value("${tesseract.datapath}")
    private String tesseractDataPath;

    public FileService() {
        tesseract = new Tesseract();
    }

    @PostConstruct
    public void init() {
        tesseract.setDatapath(tesseractDataPath);
    }

    public String extractText(MultipartFile file) throws Exception {
        File tempFile = File.createTempFile("temp", ".pdf");
        file.transferTo(tempFile);

        try (PDDocument document = PDDocument.load(tempFile)) {
            PDFRenderer pdfRenderer = new PDFRenderer(document);
            StringBuilder result = new StringBuilder();

            for (int page = 0; page < document.getNumberOfPages(); page++) {
                BufferedImage image = pdfRenderer.renderImageWithDPI(page, 300);
                result.append(tesseract.doOCR(image)).append("\n");
            }

            return result.toString();
        } finally {
            tempFile.delete();
        }
    }
}
