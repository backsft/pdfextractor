/*
package com.WorkingPDF;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class PdfTableController {
    private final PdfTableParser pdfTableParser;

    public PdfTableController(PdfTableParser pdfTableParser) {
        this.pdfTableParser = pdfTableParser;
    }

    @PostMapping("/convert")
    public String convertPdfTableToCsv(@RequestParam("file") MultipartFile file) {
        try {
            File tempFile = File.createTempFile("pdf", null);
            file.transferTo(tempFile);

            List<String[]> table = pdfTableParser.parsePdfTable(tempFile);

            // Generate CSV content from the table data
            StringBuilder csvContent = new StringBuilder();
            for (String[] row : table) {
                csvContent.append(String.join(",", row)).append("\n");
            }

            // Save the CSV content to a file
            File csvFile = new File("C:\\Users\\kabir\\OneDrive\\Desktop\\test.csv");
            FileWriter fileWriter = new FileWriter(csvFile);
            CSVPrinter csvPrinter = new CSVPrinter(fileWriter, CSVFormat.DEFAULT);
            for (String[] row : table) {
                csvPrinter.printRecord((Object[]) row);
            }
            csvPrinter.close();

            return "success"; // Return a success view
        } catch (IOException e) {
            e.printStackTrace();
            return "error"; // Return an error view
        }
    }
    }


*/