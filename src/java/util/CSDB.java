package util;
import java.sql.*;
public class CSDB {
    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/comsci?useSSL=false",
            "root","Golfring02");
    }
}