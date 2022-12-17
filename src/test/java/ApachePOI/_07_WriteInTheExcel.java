package ApachePOI;

import io.cucumber.java.sl.Ce;
import org.apache.poi.ss.usermodel.*;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _07_WriteInTheExcel {
    public static void main(String[] args) throws IOException {
        // var olan execele yazma islemi
        String path = "src/test/java/ApachePOI/resource/WriteInTheExcelFile.xlsx";
        FileInputStream inputStream = new FileInputStream(path); // okuma modu acildi
        Workbook workbook = WorkbookFactory.create(inputStream); // excelde ki workbook u hafizaya aldi
        Sheet sheet = workbook.getSheetAt(0);

        // Hafizada islemler devam ediyor
        Row yeniSatir=sheet.createRow(0); // satir olusturuldu 0.yerde
        Cell yeniHucre = yeniSatir.createCell(0); // yeni satirda ilk hucre olusturuldu
        yeniHucre.setCellValue("Merhaba Dunya"); // bilgi yazildi

        for (int i = 0; i < 10; i++) {
            yeniSatir.createCell(i).setCellValue(i); // merhaba dunya 1 2 3 4 5 6 7 8 9

        }

        inputStream.close(); // okuma kanali kapatildi

        // Yazma islemini YAZMA modunda acip oyle yapacagiz (SAVE)
        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream); // workbook excel dosyasina yazildi (save)
        workbook.close(); // workbook icin ayrilan hafiza bosaltildi.(excel kapatildi)
        outputStream.close(); // yazma icin acilan kanal kapatildi.(program excel kanali kapatildi )
        System.out.println("islem tamamlandi");

    }
}
