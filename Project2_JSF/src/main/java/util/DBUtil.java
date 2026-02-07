package util;
import java.sql.*;
public class DBUtil {
    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/comsci2?useSSL=false",
            "root","Golfring02");
    }
}