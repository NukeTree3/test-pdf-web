package com.nuketree3.example.testpdfweb.fileworkers;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class FileRead implements FileReadable{

    private static final String SOURCE_PATH = "src/main/resources/static/documents/";

    @Override
    public List<String> getFileList(){
        List<String> list = new ArrayList<>();
        File folder = new File(SOURCE_PATH);
        File[] listOfFiles = folder.listFiles();

        assert listOfFiles != null;
        for(File file : listOfFiles){
            if(file.isFile()){
                list.add(file.getName());
            }
        }
        return list;
    }

    @Override
    public PDDocument getFile(String fileName) throws IOException {
        File file = new File(SOURCE_PATH + fileName);
        try {
            return Loader.loadPDF(file);
        }catch (Exception e){
            return null;
        }
    }
}
