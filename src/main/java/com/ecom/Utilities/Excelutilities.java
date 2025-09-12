package com.ecom.Utilities;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutilities {

    public static Object[][] getdata(String excelpath, String sheetname) throws IOException {
        // Load Excel file
        File file = new File(excelpath);
        FileInputStream fs = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet worksheet = workbook.getSheet(sheetname);

        // Get total rows & columns
        int rowcount = worksheet.getPhysicalNumberOfRows();
        int colcount = worksheet.getRow(0).getPhysicalNumberOfCells();

        System.out.println("Rows: " + rowcount + ", Cols: " + colcount);

        // Create array dynamically (excluding header row)
        Object[][] data = new Object[rowcount - 1][colcount];

        // Loop through rows (skip header row at index 0)
        for (int i = 1; i < rowcount; i++) {
            for (int j = 0; j < colcount; j++) {
                DataFormatter formatter = new DataFormatter();
            	data[i - 1][j] = formatter.formatCellValue(worksheet.getRow(i).getCell(j));
            }
        }

        workbook.close();
        fs.close();

        return data;
    }
}

