package App;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public static final String url = "jdbc:mysql://localhost:3306/users";
    public static final String username = "root";
    public static final String password = "12345678";
    
    
    public static Connection getConnection(){
           Connection con = null;
                try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url,username,password);
                      System.out.println("Conectado a la base de datos");
                                         
		} catch (ClassNotFoundException | SQLException e) {
                    System.out.println("Conexion no establecida");
		}
                return con;
    }
}
