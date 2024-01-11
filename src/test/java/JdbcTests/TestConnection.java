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
        ResultSet resultSet = statement.executeQuery("SELECT * FROM regions");

        //next() >>>>move pointer to first row
        resultSet.next();

        //Getting info with column
        System.out.println(resultSet.getString("region_Name"));

        //getting info with column index (starts from 1)
        resultSet.getInt(1);
        //The result will be Europe, 'cause in the first row of the first column is Europe

        //-1 Europe
        //-2 America
        System.out.println(resultSet.getInt(1)+ "-"+resultSet.getString(2));

        //move to second row
        resultSet.next();
        System.out.println(resultSet.getInt(1)+ "-"+resultSet.getString(2));

        //move to third row
        resultSet.next();
        System.out.println(resultSet.getInt(1)+ "-"+resultSet.getString(2));

        /*
        while (resultSet.next()){
            System.out.println(resultSet.getInt(1)+ "-"+resultSet.getString(2));

        }
        */



        //close connection
        resultSet.close();
        statement.close();
        connection.close();

    }
}
