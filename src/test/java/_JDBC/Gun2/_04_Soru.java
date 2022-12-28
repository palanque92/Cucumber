package _JDBC.Gun2;

import _JDBC.Gun1.JDBCParent;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class _04_Soru extends JDBCParent {
    // Soru :  Actor tablsosundaki tüm verileri yeni excel e yazdırınız.

    @Test
    public void test1() throws SQLException, IOException {
        // db den tüm verileri okuma
        // alınan her satırı aldıktan hemen sonra excele yeni bir satıra yazma
        getTable("select * from actor");
    }


    public void getTable(String sorgu) throws SQLException {
        ResultSet rs=statement.executeQuery(sorgu);
        ResultSetMetaData rsmd=rs.getMetaData();

        for(int i=1; i<= rsmd.getColumnCount(); i++)
            System.out.printf("%-20s",rsmd.getColumnName(i));

        System.out.println();

        while (rs.next())
        {
            for(int i=1; i<= rsmd.getColumnCount(); i++)
                System.out.printf("%-20s",rs.getString(i));
            System.out.println();
        }
    }
    public void getTable2(String sorgu) throws SQLException {
        ResultSet rs = statement.executeQuery(sorgu);
        ResultSetMetaData rsmd = rs.getMetaData();

        for (int i = 1; i <= rsmd.getColumnCount(); i++)
            System.out.printf("%d ", rsmd.getColumnDisplaySize(i));

        System.out.println();

        for (int i = 1; i <= rsmd.getColumnCount(); i++)
            System.out.printf("%-20s", rsmd.getColumnName(i));

        System.out.println();

        while (rs.next()) {
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {

                if (rsmd.getColumnDisplaySize(i) > 100) {
                    System.out.printf("%-100s ", rs.getString(i).substring(0, rs.getString(i).length() > 100 ? 100 : rs.getString(i).length()));
                } else
                    System.out.printf("%-" + rsmd.getColumnDisplaySize(i) + "s ", rs.getString(i));
            }

            System.out.println();
        }
    }
}
