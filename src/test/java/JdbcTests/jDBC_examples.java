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
       // System.out.println(resultSet.getString(2));
        //HOW CAN I IMPLEMENT THE SAME CODE FOR EACH ROW
        //WHILE LOOP OF COURSE!

        while (resultSet.next()){
            System.out.println(resultSet.getInt(1)+"-"+(resultSet.getString(2)+"-"+
        (resultSet.getInt(3)+"-"+(resultSet.getInt(4)))));
        }

        //YOU DON'T HAVE TO DO THE FIRST 3 THINGS AT THE BEGINNING ALL OVER AGAIN
        resultSet = statement.executeQuery("SELECT * FROM REGIONS");

        while (resultSet.next()){
            System.out.println(resultSet.getInt(1)+ "-"+ (resultSet.getString(2)));
        }

        resultSet.close();
        statement.close();
        connection.close();

    }
//------------------------------------------------------------------------------------------------------------
    //RESULTSET METHODS PRACTICE
    @Test
    public void test2() throws SQLException {
        Connection connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("SELECT * FROM departments");

        // HOW TO FIND HOW MANY ROWS WE HAVE IN THE DEPARTMENTS QUERY????
        //COMBINATION OF THE TWO ROWS

        //MOVE TO THE LAST ROW FIRS,
        resultSet.last();
        //THEN,GET THE ROW NUMBER
        int rowCount = resultSet.getRow();
        System.out.println(rowCount);

        //HOW TO PRINT THE WHOLE SECOND COLUMN INFORMATION OF THE DEPARTMENTS TABLE
        //WHERE IS THE POINTER AFTER I MOVED IT TO THE LAST ONE?
        //I NEED THE POINTER TO BE AT THE BEGINNING OF THE COLUMN
        //THAT'S WHY, BEFOREFIRST() METHOD SHOULD BE USED

        resultSet.beforeFirst();

        while (resultSet.next()){
            System.out.println(resultSet.getString(2));
        }





        resultSet.close();
        statement.close();
        connection.close();


    }


}
