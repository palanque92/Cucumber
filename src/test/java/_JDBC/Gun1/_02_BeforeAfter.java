package _JDBC.Gun1;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.*;

public class _02_BeforeAfter {

    public static Statement statement;

    public static Connection connection;

    @BeforeTest
    public void DBConnectionOpen () throws SQLException {
        String url = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila";
        String username = "root";
        String password = "'\"-LhCB'.%k[4S]z"; // password
        connection = DriverManager.getConnection(url,username,password);
        statement = connection.createStatement();
    }

    @AfterTest
    public void DBConnectionClose () throws SQLException {
        connection.close();
    }

    @Test
    public void test1 () throws SQLException {
        ResultSet rs=statement.executeQuery("select * from language");

        rs.next();
        String dilAdi=rs.getString(2);
        System.out.println("dilAdi = " + dilAdi); // english

        rs.next();
        System.out.println("rs.getString(2) = " + rs.getString(2)); // italian

        rs.next();
        System.out.println("rs.getString(2) = " + rs.getString(2)); // japanese
    }

    @Test
    public void test2 () throws SQLException {
        ResultSet rs=statement.executeQuery("select * from language");

        rs.next();
        String dilAdi=rs.getString(2);
        System.out.println("dilAdi = " + dilAdi); // english

        rs.next();
        System.out.println("rs.getString(2) = " + rs.getString(2)); // italian

        rs.previous();
        System.out.println("rs.getString(2) = " + rs.getString(2)); // english
    }
}
