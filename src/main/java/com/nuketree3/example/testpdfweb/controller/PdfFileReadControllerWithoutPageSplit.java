package com.nuketree3.example.testpdfweb.controller;

import com.nuketree3.example.testpdfweb.service.PdfService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;

@Controller
public class PdfFileReadControllerWithoutPageSplit {
    private final PdfService pdfService;

    public PdfFileReadControllerWithoutPageSplit(PdfService pdfService) {
        this.pdfService = pdfService;
    }

    @GetMapping("/document-list-without")
    public String getDocumentList(Model model) {
        model.addAttribute("documentList", pdfService.getDocumentList());
        return "documents-without-page-split";
    }

    @GetMapping("/file-without-page-split/{documentName}")
    public String getFile(@PathVariable String documentName, Model model) throws IOException {
        model.addAttribute("documentPages", pdfService.getImageToBase64List(documentName));
        return "page-without-split";
    }
}
