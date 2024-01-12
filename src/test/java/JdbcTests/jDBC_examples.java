package JdbcTests;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class jDBC_examples {

    String dbUrl = "jdbc:oracle:thin:@54.158.33.169:1521:XE";

    String dbUsername ="hr";
    String dbPassword = "hr";

    @Test
    public void test1() throws SQLException {
        Connection connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM departments");

        resultSet.next();

        //Display departments table in 10-administration-200-1700
        System.out.println(resultSet.getString(2));
        //HOW CAN I IMPLEMENT THE SAME CODE FOR EACH ROW
        //WHILE LOOP OF COURSE!

        resultSet.close();
        statement.close();
        connection.close();

    }



}
