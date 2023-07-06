package com.WorkingPDF;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Component;

@Component
public class PdfTableParser {
    public List<String[]> parsePdfTable(File file) throws IOException {
        PDDocument document = PDDocument.load(file);
        PDFTextStripper pdfTextStripper = new PDFTextStripper();
        String tableText = pdfTextStripper.getText(document);

        List<String[]> rows = new ArrayList<>();
        String[] lines = tableText.split("\n");

        for (String line : lines) {
            // Assuming the table uses comma (",") as the column separator
            String[] columns = line.split(",");
            rows.add(columns);
        }

        document.close();
        return rows;
    }
}
