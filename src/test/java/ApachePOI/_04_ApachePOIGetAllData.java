package ApachePOI;

import io.cucumber.java.sl.Ce;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class _04_ApachePOIGetAllData {
    public static void main(String[] args) throws IOException{

            String path = "src/test/java/ApachePOI/resource/ApacheExcel2.xlsx";

            FileInputStream fileInputStream = new FileInputStream(path);

            Workbook workbook = WorkbookFactory.create(fileInputStream);

            Sheet sheet = workbook.getSheetAt(0);

            // sayfadaki kullanilan toplam satir sayisini verir.
            int rowCount = sheet.getPhysicalNumberOfRows(); // satir sayisi

            for (int i = 0; i < rowCount; i++) {
                Row row = sheet.getRow(i); // i satir alindi.
                int cellCount = row.getPhysicalNumberOfCells(); // zoo[i].length

                for (int j = 0; j < cellCount; j++) {
                    Cell cell = row.getCell(j);
                    System.out.print(cell + "\t");
                }
                System.out.println();
            }
            // 2 .Yontem
        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {

            for (int j = 0; j < sheet.getRow(i).getPhysicalNumberOfCells(); j++) {
                System.out.print(sheet.getRow(i).getCell(j)+"\t");
            }
            System.out.println();
        }
    }
}
