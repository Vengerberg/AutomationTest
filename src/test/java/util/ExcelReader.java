package util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {

    private XSSFWorkbook workbook;

    public ExcelReader(String fileName) {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/" + fileName);
            workbook = new XSSFWorkbook(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String[][] getProducts() {
        return getSheetData("Product");
    }

    public String[][] getMultiProducts() {
        return getSheetData("MultiProducts");
    }

    public String[][] getBrands() {
        return getSheetData("Brand");
    }

    public String[][] getCategories() {
        return getSheetData("Category");
    }

    private String[][] getSheetData(String sheetName) {
        XSSFSheet sheet = workbook.getSheet(sheetName);
        int rowsCount = sheet.getLastRowNum() + 1;
        int colsCount = sheet.getRow(0).getLastCellNum();

        System.out.println(rowsCount);
        System.out.println(colsCount);

        String[][] res = new String[rowsCount][colsCount];

        for(int i = sheet.getFirstRowNum(); i < rowsCount; i++) {
            Row row = sheet.getRow(i);

            for(int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
                Cell cell = row.getCell(j);
                res[i][j] = cell.getStringCellValue();
            }
        }

        return res;
    }
}
