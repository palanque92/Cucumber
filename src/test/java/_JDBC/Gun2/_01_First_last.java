package _JDBC.Gun2;

import _JDBC.Gun1.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _01_First_last extends JDBCParent {
    @Test
    public void test () throws SQLException {
        ResultSet rs = statement.executeQuery("select city_id, city, country_id from city");

        rs.last(); // sonuncu satira gider.
        String id = rs.getString(1); // city_id
        System.out.println("id = " + id);

        int idInt = rs.getInt(1);
        System.out.println("idInt = " + idInt);

        // int nameInt=rs.getInt(2);
        // System.out.println("nameInt = " + nameInt);
        // tipi uygun olan dönüşümle , mesala hepsini String olarak alabilirsin.
        // ancak tipi uygun olmayan mesala isimleri , int olarak zaten alinmaz

        int kacinciSatirdayim = rs.getRow();
        // dolayisiyla bir sorgunun sonucunda kac satir geldigini
        // rs.last() dedikten sonra rs.getRow ile alabilirim.
        System.out.println("kacinciSatirdayim = " + kacinciSatirdayim);

        rs.first(); // ilk satira gider

    }
}
