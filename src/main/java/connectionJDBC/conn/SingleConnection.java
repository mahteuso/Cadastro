package connectionJDBC.conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {
    private static String url = "jdbc:postgresql://localhost:5432/postgres";
    private static String password = "root";
    private static String user = "postgres";
    private static Connection connection = null;

    static{
        connect();
    }
    public SingleConnection() {
        connect();
    }

    private static void connect(){
        try {
            if (connection == null){
                connection = DriverManager.getConnection(url, user, password);
                connection.setAutoCommit(false);
                System.out.println("Conexão realizada com sucesso!");
            }

        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public static Connection getConnection(){
        return connection;
    }
}
