package sk.ivanmolcan;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class DataDriven {

    public static void main(String[] args) throws IOException {

        //fileInputStream argument

        FileInputStream fis = new FileInputStream("D:\\Doc\\Programovanie\\Automation Testing\\Udemy\\Rahul\\Projects\\ExcelDriven\\ExcelDriven.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        int sheets = workbook.getNumberOfSheets();
        for (int i = 0; i < sheets; i++) {
            if (workbook.getSheetName(i).equalsIgnoreCase("testdata")) {
                XSSFSheet sheet = workbook.getSheetAt(i);

                //Identifikovanie column
                Iterator<Row> rows = sheet.iterator();
                Row firstRow = rows.next();
                Iterator<Cell> cell = firstRow.cellIterator();
                int k = 0;
                int column = 0;
                while (cell.hasNext()) {
                    Cell value = cell.next();
                    if (value.getStringCellValue().equalsIgnoreCase("Testcases")) {
                        column = k;
                    }
                    k++;
                }
                //Ked je identifikovany column scanujem cely 'Testcase' stlpec aby som nasiel riadok 'Purchase'
                while (rows.hasNext()) {
                    Row r = rows.next();
                    if (r.getCell(column).getStringCellValue().equalsIgnoreCase("Purchase")) {
                        Iterator<Cell> cv = r.cellIterator();
                        while (cv.hasNext()) {
                            System.out.println(cv.next().getStringCellValue());
                        }
                    }
                }
            }
        }
    }
}
