/*
 * package com.WorkingPDF;
 * 
 * import java.io.File; import java.io.FileWriter; import java.io.IOException;
 * import java.util.List;
 * 
 * import jakarta.persistence.Table; import
 * technology.tabula.extractors.BasicExtractionAlgorithm; import
 * technology.tabula.extractors.ExtractionAlgorithm;
 * 
 * public class WorkingPdfApplication { public static void main(String[] args) {
 * String pdfFilePath = "path/to/your/pdf/file.pdf";
 * 
 * // Create a Tabula extractor instance Extractor extractor = new Extractor();
 * 
 * // Set the extraction algorithm (choose the one that suits your needs)
 * ExtractionAlgorithm algorithm = new BasicExtractionAlgorithm();
 * extractor.setExtractionAlgorithm(algorithm);
 * 
 * // Extract tables from the PDF file List<Table> tables; try { tables =
 * extractor.extract(new File(pdfFilePath)); } catch (IOException e) {
 * e.printStackTrace(); return; }
 * 
 * // Process and save the extracted table data StringBuilder csvContent = new
 * StringBuilder("column1,column2\n");
 * 
 * for (Table table : tables) { List<List<String>> tableData = table.getRows();
 * 
 * for (List<String> row : tableData) { // Access the table data String column1
 * = row.get(0); String column2 = row.get(1);
 * 
 * // Append the data to the CSV content
 * csvContent.append(column1).append(",").append(column2).append("\n"); } }
 * 
 * // Save the CSV content to a file try { FileWriter writer = new
 * FileWriter("path/to/output.csv"); writer.write(csvContent.toString());
 * writer.close(); } catch (IOException e) { e.printStackTrace(); } } }
 */