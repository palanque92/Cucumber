package _JDBC.Gun1;

import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _03_AbsoluteRelative extends JDBCParent{

    @Test
    public void test1 () throws SQLException {
        ResultSet rs=statement.executeQuery("select * from film");

        rs.absolute(10); // direk 10. satira gider
        String title = rs.getString("title");
        System.out.println("title = " + title);

        rs.absolute(15); // direk 15 satira gider
        title= rs.getString("title");
        System.out.println("title = " + title);

        rs.absolute(-15); // sondan 15. satira gider
        title= rs.getString("title");
        System.out.println("title = " + title);

        rs.absolute(10); // direk 10. satira gider
        title= rs.getString("title");
        System.out.println("title = " + title);

        rs.relative(1); // en son bulundugu yerden itibaren 5 satir ileri gider
        title= rs.getString("title");
        System.out.println("title = " + title);
    }
}
