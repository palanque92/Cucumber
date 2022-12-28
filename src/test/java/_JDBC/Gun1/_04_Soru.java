package _JDBC.Gun1;

import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _04_Soru extends JDBCParent{
    // city tablosundaki tüm kayıtlardaki isimleri next ile yazdırınız
    // city tablosundaki tüm kayıtlardaki isimleri absolute ile yazdırınız
    // city tablosundaki tüm kayıtlardaki isimleri relative ile yazdırınız
    @Test
    public void Test1 () throws SQLException {
        ResultSet rs=statement.executeQuery("select * from city");

        rs.next();
        String city = rs.getString("city");
        System.out.println("city = " + city);

        rs.absolute(15);
        city= rs.getString("city");
        System.out.println("city = " + city);

        rs.relative(1);
        city= rs.getString("city");
        System.out.println("city = " + city);
    }

    @Test
    public void Test2 () throws SQLException {
        ResultSet rs=statement.executeQuery("select * from city");

        int count=0;
        while (rs.next()){
            System.out.println(rs.getString("city"));
            count++;
        }
        System.out.println("count = " + count);
    }
    @Test
    public void Test3 () throws SQLException {
        ResultSet rs=statement.executeQuery("select * from city");

        int count=1;
        while (rs.absolute(count)){ // verilen satir numarasina konumlandirir
            System.out.println(rs.getString("city"));
            count++;
        }
        System.out.println("count = " + (count-1));
    }
    @Test
    public void Test4 () throws SQLException {
        ResultSet rs=statement.executeQuery("select * from city");

        int count=0;
        while (rs.relative(1)){ // bulundugu yerden bir satir sonraya gider
            System.out.println(rs.getString("city"));
            count++;
        }
        System.out.println("count = " + count);
    }
}
