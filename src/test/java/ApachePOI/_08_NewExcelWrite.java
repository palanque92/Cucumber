package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.FileOutputStream;
import java.io.IOException;

public class _08_NewExcelWrite {
    public static void main(String[] args) throws IOException {
        // WorkbooK VAROLAN Excel In workbook  u idi , bunu olusmamis bir excel icin kullanamiyor.

        XSSFWorkbook workbook = new XSSFWorkbook(); // hafizada bir workbook olusturuldu.
        XSSFSheet sheet = workbook.createSheet("Sayfa1"); // icinde sheet olusturdum.

        // Hafizada islemler devam ediyor
        Row yeniSatir=sheet.createRow(0); // satir olusturuldu 0.yerde
        Cell yeniHucre = yeniSatir.createCell(0); // yeni satirda ilk hucre olusturuldu
        yeniHucre.setCellValue("Merhaba Dunya"); // bilgi yazildi

        for (int i = 0; i < 10; i++) {
            yeniSatir.createCell(i).setCellValue(i); // merhaba dunya 1 2 3 4 5 6 7 8 9

            // Yazma islemini YAZMA modunda acip oyle yapacagiz (SAVE)
            String path = "src/test/java/ApachePOI/resource/YeniExcel.xlsx";
            FileOutputStream outputStream = new FileOutputStream(path);
            workbook.write(outputStream); // workbook excel dosyasina yazildi (save)
            workbook.close(); // workbook icin ayrilan hafiza bosaltildi.(excel kapatildi)
            outputStream.close(); // yazma icin acilan kanal kapatildi.(program excel kanali kapatildi)
            System.out.println("islem tamamlandi");
        }
    }
}
