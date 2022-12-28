package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _09_Soru {
    /*
     Yeni bir excele merhaba Dünya 1 şeklinde yazdıktan sonra , programı tekrar
     çalıştırdığınızda aynı excelin bir alt satırına devam ediniz.
     Program her çalıştıkça aşağıdaki gibi olmalı
     Merhaba Dünya 1
     Merhaba Dünya 2
     Merhaba Dünya 3
      ....
      ....
      path="";
      File dosya=new File(path)
      if (dosya.exists())  // dosya var mı
    */
    public static void main(String[] args) throws IOException {
        String path = "src/test/java/ApachePOI/resource/YeniExcelMerhaba.xlsx";
        File f = new File(path);

        if (!f.exists()) {

            // hafizada olustur yeni oldugu icin
            XSSFWorkbook workbook = new XSSFWorkbook(); // hafizada bir workbook olusturuldu.
            XSSFSheet sheet = workbook.createSheet("Sayfa1"); // icinde sheet olusturdum.

            // bilgini yaz
            Row yeniSatir=sheet.createRow(0);
            Cell yeniHucre = yeniSatir.createCell(0);
            yeniHucre.setCellValue("Merhaba Dunya");



            FileOutputStream outputStream = new FileOutputStream(path);
            workbook.write(outputStream); // workbook excel dosyasina yazildi (save)
            workbook.close(); // workbook icin ayrilan hafiza bosaltildi.(excel kapatildi)
            outputStream.close(); // yazma icin acilan kanal kapatildi.(program excel kanali kapatildi)

            System.out.println("islem tamamlandi");

        }
        else
        {
            FileInputStream inputStream = new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(0);

            int rowCount = sheet.getPhysicalNumberOfRows();

            Row yeniSatir=sheet.createRow(rowCount);
            Cell yeniHucre = yeniSatir.createCell(0);
            yeniHucre.setCellValue("Merhaba Dunya "+(rowCount+1) );

            FileOutputStream outputStream = new FileOutputStream(path);
            workbook.write(outputStream);
            outputStream.close();

            System.out.println("islem tamamlandi var olan");
        }
    }
}
