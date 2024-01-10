package JdbcTests;

import java.sql.*;

public class TestConnection {

    public static void main (String []args) throws SQLException {

        String dbUrl = "jdbc:oracle:thin:@54.158.33.169:1521:XE";

        String dbUsername ="hr";
        String dbPassword = "hr";

        //Create connection first
        Connection connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);

        //Statement is used for running the query
        Statement statement = connection.createStatement();

        //Save the data in resultSet
        ResultSet resultSet = statement.executeQuery("SELECT * FROM employees");

        //close connection
        resultSet.close();
        statement.close();
        connection.close();

    }
}
