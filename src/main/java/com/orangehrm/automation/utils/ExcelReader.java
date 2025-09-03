package com.orangehrm.automation.utils;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

public class ExcelReader {
    private String filePath;

    public ExcelReader(String filePath) {
        this.filePath = filePath;
    }

    public String getCellData(String sheetName, String columnName, int rowNum) {
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = WorkbookFactory.create(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            Row headerRow = sheet.getRow(0);

            Map<String, Integer> colMap = new HashMap<>();
            for (Cell cell : headerRow) {
                colMap.put(cell.getStringCellValue(), cell.getColumnIndex());
            }

            Row row = sheet.getRow(rowNum);
            Cell cell = row.getCell(colMap.get(columnName));

            return cell.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
