package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils
{
    private static String dbURL = "jdbc:h2:mem:test;INIT=RUNSCRIPT FROM 'classpath:init.sql'";
    private static String dbUserName = "root";
    private static String dbPassword = "root";

    public static Connection getConnection()
    {
        Connection connection = null;

        try
        {
            connection = DriverManager.getConnection(dbURL, dbUserName, dbPassword);
        }
        catch (SQLException e)
        {
            System.err.println("Не удалось выполнить соединение!");
            e.printStackTrace();
        }

        return connection;
    }
}
