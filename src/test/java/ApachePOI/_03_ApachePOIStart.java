package ApachePOI;

import org.apache.poi.ss.usermodel.*;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class _03_ApachePOIStart {
    public static void main(String[] args) throws IOException {
        // dosyanin yolu alindi
        String path="src/test/java/ApachePOI/resource/ApacheExcel2.xlsx";

        // JavaDosya okuma islemcisi dosyanin yolunu veriyoruz
        // boylece program ile dosya arasinda baglanti olustu.
        FileInputStream dosyaOkumaBaglantisi = new FileInputStream(path);

        Workbook calismaKitabi = WorkbookFactory.create(dosyaOkumaBaglantisi);

        Sheet calismaSayfasi = calismaKitabi.getSheet("Sheet1");
        // Sheet calismaSayfasi = calismaKitabi.getSheet("Sheet1");

        Row satir = calismaSayfasi.getRow(0);

        Cell hucre = satir.getCell(0);

        System.out.println("hucre = " + hucre);
    }
}
