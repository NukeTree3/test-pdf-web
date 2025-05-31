package com.nuketree3.example.testpdfweb.service;

import com.nuketree3.example.testpdfweb.fileworkers.FileRead;
import com.nuketree3.example.testpdfweb.fileworkers.FileReadable;
import com.nuketree3.example.testpdfweb.helpers.ImageConverter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PdfService {

    private final FileReadable fileRead;

    public PdfService() {
        fileRead = new FileRead();
    }

    public List<String> getDocumentList() {
        return fileRead.getFileList();
    }

    public PDDocument getPDF(String fileName) throws IOException {
        return fileRead.getFile(fileName);
    }

    public Image getImage(PDDocument document, int pageNumber) throws IOException {
        PDFRenderer pdfRenderer = new PDFRenderer(document);
        return pdfRenderer.renderImage(pageNumber);
    }

    public List<String> getImageToBase64List(String fileName) throws IOException {
        List<String> imageToBase64List = new ArrayList<>();
        PDDocument document = getPDF(fileName);
        for (int i = 0; i < document.getNumberOfPages(); i++) {
            imageToBase64List.add(ImageConverter.imageToBase64(getImage(document, i)));
        }
        return imageToBase64List;
    }
}
