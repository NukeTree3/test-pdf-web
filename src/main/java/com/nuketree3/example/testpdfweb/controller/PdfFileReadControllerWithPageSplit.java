package com.nuketree3.example.testpdfweb.controller;

import com.nuketree3.example.testpdfweb.helpers.ImageConverter;
import com.nuketree3.example.testpdfweb.service.PdfService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;

@Controller
public class PdfFileReadControllerWithPageSplit {
    private final PdfService pdfService;

    public PdfFileReadControllerWithPageSplit(PdfService pdfService) {
        this.pdfService = pdfService;
    }

    @GetMapping("/document-list")
    public String getDocumentList(Model model) {
        model.addAttribute("documentList", pdfService.getDocumentList());
        return "documents";
    }

    @GetMapping("/file/{documentName}/{pageNumber}")
    public String getFile(@PathVariable String documentName, @PathVariable int pageNumber, Model model) throws IOException {
        model.addAttribute("documentPage", ImageConverter.imageToBase64(pdfService.getImage(pdfService.getPDF(documentName), pageNumber)));
        model.addAttribute("documentName", documentName);
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("documentSize", pdfService.getPDF(documentName).getNumberOfPages());
        return "page";
    }
}
