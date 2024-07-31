package utils;


import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {
    String excelPath = null;

    public ExcelUtils(String filePath) {
        excelPath = filePath;

    }

    public ExcelUtils() {

    }

    public Sheet getSheet(String SheetName) {
        Sheet sheet = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(excelPath);
            sheet = WorkbookFactory.create(fileInputStream).getSheet(SheetName);
        } catch (IOException e) {
            System.out.println("File not found at :" + excelPath);
        }
        return sheet;

    }

    public String getValue(Cell cell) {
        String value = "";
        if (cell != null) {
            CellType cellType = cell.getCellType();
            switch (cellType) {
                case STRING:
                    return value = cell.getStringCellValue();
                case NUMERIC:
                    if (DateUtil.isCellDateFormatted(cell)) {
                        return value = cell.getDateCellValue().toString();
                    } else {
                        return value = String.valueOf(cell.getNumericCellValue());
                    }
                case BOOLEAN:
                    return value = String.valueOf(cell.getBooleanCellValue());
                default:
                    return "";
            }
        }
        return value;

    }

    public String getPreStep(String sheetName) {
        Sheet sheet = getSheet(sheetName);
        String preStep = "";
        if (sheet != null) {
            Cell cell = sheet.getRow(0).getCell(1);
            getValue(cell);
        } else {
            System.out.println("Sheet Name not matched:" + sheetName);
        }
        return preStep;
    }

    public Row getRow(Sheet sheet, int RowNum) {
        Row row = null;
        if (sheet != null) {
            row = sheet.getRow(RowNum);
        }
        return row;
    }

    public Cell getCell(Row row, int cellNum) {
        Cell cell = null;
        if (row != null) {
            cell = row.getCell(cellNum);
        }
        return cell;
    }

    public String iterateData(Sheet sheet, int rowNum, int colNum) {
        String value = "";
        if (sheet != null) {
            Row row = sheet.getRow(rowNum);
            Cell cell = row.getCell(colNum);
            value = getValue(cell);
        }
        return value;
    }

    public String getLocator(Row row) {
        String locator = "";
        if (row != null) {
            locator = getValue(row.getCell(1));
        }
        return locator;
    }

    public String getAction(Row row) {
        String action = "";
        if (row != null) {
            action = getValue(row.getCell(2));
        }
        return action;
    }

    public String getResult(Sheet sheet, int rowNum) {
        String result = "";
        if (sheet != null) {
            Row row = sheet.getRow(rowNum);
            result = getValue(row.getCell(3));
        }
        return result;
    }


}
