package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {

    private static Connection conn;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String password = "sanlorenzo";
    private static final String url = "jdbc:mysql://localhost:3306/prueba";


    public DataBase() {
        conn = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba?useTimezone=true&serverTimezone=UTC", "root", "sanlorenzo");
            if (conn != null) {
                System.out.println("Ha conectado ");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("No ha conectado  " + e);
            e.printStackTrace();

        }
    }

    //Con este conectamos a la base de datos
    public Connection getConnection() {
        return conn;
    }

    //Asi se desconecta
    public void desconectar() {
        conn = null;
        System.out.println("Se ha desconectado");
    }
}
