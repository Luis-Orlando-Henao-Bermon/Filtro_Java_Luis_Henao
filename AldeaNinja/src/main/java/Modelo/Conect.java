package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conect {
    private static String  user="upiiwdy2kc6ame7k";
    private static String password="xw5mvbNU6DweG0BFrrJN";
    private static String url="jdbc:mysql://upiiwdy2kc6ame7k:xw5mvbNU6DweG0BFrrJN@bpmkccfjnfr6kpulwjts-mysql.services.clever-cloud.com:3306/bpmkccfjnfr6kpulwjts";

    public static Connection getCon() throws SQLException {
        Connection con=null;
        try {
            con= DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            throw new SQLException("Error al conectar a la base de datos: "+e.getMessage());
        }
        return con;

    }
}
