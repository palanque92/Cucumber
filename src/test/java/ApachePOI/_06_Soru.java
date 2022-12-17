package ApachePOI;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class _06_Soru {
    public static void main(String[] args) {
        System.out.println("Istenen Sutun");
        Scanner oku = new Scanner(System.in);
        int sutun = oku.nextInt();

        String donenSonuc = bul(sutun);
        System.out.println("donenSonuc = \n " + donenSonuc);
    }
    public static String bul (int sutun) {
        String donecek = "";
        String path = "src/test/java/ApachePOI/resource/LoginData.xlsx";

        Sheet sheet = null;
        try {
            FileInputStream InputStream = new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(InputStream);
            sheet = workbook.getSheetAt(0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // butuun satirlari dolas
        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
            if (sheet.getRow(i).getCell(sutun) !=null)
            donecek += sheet.getRow(i).getCell(sutun)+"\n";

        }


        return donecek;
    }
}
