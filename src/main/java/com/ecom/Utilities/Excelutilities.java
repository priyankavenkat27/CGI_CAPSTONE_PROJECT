package com.ecom.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutilities {

    public static Object[][] getdata(String excelpath, String sheetname) throws IOException {
        File file = new File(excelpath);
        FileInputStream fs = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet worksheet = workbook.getSheet(sheetname);

        int rowcount = worksheet.getPhysicalNumberOfRows();
        int colcount = worksheet.getRow(0).getPhysicalNumberOfCells();

        System.out.println("Rows: " + rowcount + ", Cols: " + colcount);

        Object[][] data = new Object[rowcount - 1][colcount];

        DataFormatter formatter = new DataFormatter();
        for (int i = 1; i < rowcount; i++) {
            for (int j = 0; j < colcount; j++) {
                data[i - 1][j] = formatter.formatCellValue(worksheet.getRow(i).getCell(j));
            }
        }

        workbook.close();
        fs.close();
        return data;
    }

    public static Object[][] getExcelDataSingleRow(String excelPath, String sheetName) throws IOException {
        FileInputStream fs = new FileInputStream(new File(excelPath));
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet sheet = workbook.getSheet(sheetName);

        if (sheet == null) {
            workbook.close();
            fs.close();
            throw new RuntimeException("Sheet '" + sheetName + "' not found in " + excelPath);
        }

        XSSFRow dataRow = sheet.getRow(1);
        if (dataRow == null) {
            workbook.close();
            fs.close();
            throw new RuntimeException("No data found in first row of sheet '" + sheetName + "'");
        }

        int actualColCount = 0;
        for (int i = 0; i < dataRow.getLastCellNum(); i++) {
            XSSFCell cell = dataRow.getCell(i);
            if (cell != null && !getCellValueAsString(cell).isEmpty()) {
                actualColCount = i + 1;
            } else {
                break;
            }
        }

        Object[][] data = new Object[1][actualColCount];
        for (int j = 0; j < actualColCount; j++) {
            XSSFCell cell = dataRow.getCell(j);
            data[0][j] = (cell == null) ? "" : getCellValueAsString(cell);
        }

        workbook.close();
        fs.close();
        return data;
    }

    public static Object[] getExcelDataSpecificRow(String excelPath, String sheetName, int rowNumber) throws IOException {
        FileInputStream fs = new FileInputStream(new File(excelPath));
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet sheet = workbook.getSheet(sheetName);

        if (sheet == null) {
            workbook.close();
            fs.close();
            throw new RuntimeException("Sheet '" + sheetName + "' not found in " + excelPath);
        }

        XSSFRow dataRow = sheet.getRow(rowNumber + 1);
        if (dataRow == null) {
            workbook.close();
            fs.close();
            throw new RuntimeException("No data found in row " + rowNumber + " of sheet '" + sheetName + "'");
        }

        int actualColCount = 0;
        for (int i = 0; i < dataRow.getLastCellNum(); i++) {
            XSSFCell cell = dataRow.getCell(i);
            if (cell != null && !getCellValueAsString(cell).isEmpty()) {
                actualColCount = i + 1;
            } else {
                break;
            }
        }

        Object[] rowData = new Object[actualColCount];
        for (int j = 0; j < actualColCount; j++) {
            XSSFCell cell = dataRow.getCell(j);
            rowData[j] = (cell == null) ? "" : getCellValueAsString(cell);
        }

        workbook.close();
        fs.close();
        return rowData;
    }

    private static String getCellValueAsString(XSSFCell cell) {
        if (cell == null) return "";

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue().trim();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();
                } else {
                    double num = cell.getNumericCellValue();
                    if (num == Math.floor(num) && !Double.isInfinite(num)) {
                        return String.valueOf((int) num);
                    } else {
                        return String.valueOf(num);
                    }
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                try {
                    return cell.getStringCellValue();
                } catch (Exception e) {
                    return String.valueOf(cell.getNumericCellValue());
                }
            default:
                return "";
        }
    }
}
