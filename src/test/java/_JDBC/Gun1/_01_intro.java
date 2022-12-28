package _JDBC.Gun1;

import org.testng.annotations.Test;

import java.sql.*;

public class _01_intro {

    @Test
    public void test1 () throws SQLException {
        // Java baglanti : mysql e baglanti : url(hostname) : port / DB name
        String url = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila";
        String username = "root";
        String password = "'\"-LhCB'.%k[4S]z"; // password

        // connection aciliyor (fileinoutstream gibi)
        Connection connection = DriverManager.getConnection(url,username,password); // baglantiya click

        // sql lerin yazildigi sayfa
        Statement statement = connection.createStatement(); // sorgulari calistirmam icin sayfa ac
        ResultSet rs = statement.executeQuery("select * from actor"); // sorgunun sonucunu aldim
        // hizli calismak icin sonuclarin hepsi bilgisayarina gelmedi.

        rs.next(); // ilk satirbilgisayarina geldi, ilk satiri aldik.

        String firstname = rs.getString("first_name");
        String lastname = rs.getString("last_name");
        System.out.println("1.Satir firstname ve lastname = " + firstname+" "+lastname);

        rs.next(); // 2. Satiri gosteriyor

        firstname=rs.getString("first_name");
        lastname=rs.getString("last_name");
        System.out.println("2.Satir firstname ve lastname = " + firstname+" "+lastname);

        connection.close();
    }
}
