package sk.ivanmolcan;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Iterator;

public class DataDriven {

    //Identify Testcases column by scanning the entire 1st row
    //once column is identified then scan entire testcase column to identify purchase testcase row
    //after you grab purchase testcase row = pull all the data of that row and feed into test

    public static void main(String[] args) throws IOException {

        //fileInputStream argument
        FileInputStream fis = new FileInputStream("D:\\Doc\\Programovanie\\Automation Testing\\Udemy\\Rahul\\Projects Rest Assure\\ExcelDriven\\src\\Data.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        int sheets = workbook.getNumberOfSheets();
        for (int i = 0; i < sheets; i++) {
            if (workbook.getSheetName(i).equalsIgnoreCase("TestData")) {
                XSSFSheet sheet = workbook.getSheetAt(i);

                Iterator<Row> rows = sheet.iterator(); //sheet is colection of rows
                Row firstrow = rows.next();
                Iterator<Cell> ce = firstrow.cellIterator(); //row is collection of cells
                int k = 0;
                int column = 0;
                while (ce.hasNext()) {
                    Cell value = ce.next();
                    if (value.getStringCellValue().equalsIgnoreCase("Testcases")) {
                        //desired column
                        column = k;
                    }
                    k++;
                }

                //once column is identified then scan entire testcase column to identify purchase testcase row
                while (rows.hasNext()) {
                    Row r = rows.next();
                    if (r.getCell(column).getStringCellValue().equalsIgnoreCase("Purchase")) {
                        //after you grab purchase testcase row = pull all the data of that row and feed into test
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
