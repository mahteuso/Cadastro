package connectionJDBC.repository;

import connectionJDBC.conn.SingleConnection;
import connectionJDBC.model.Client;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ClientRepository {

    private Connection connection;

    public ClientRepository(){
        connection = SingleConnection.getConnection();
    }

    public void save(Client client){
        String sql = "insert into contato (id, name, email) values ('%s', '%s', '%s')".formatted(client.getId(), client.getName(), client.getEmail());
        try{
            Statement stmt = connection.createStatement();
            int rowsAffected = stmt.executeUpdate(sql);
            System.out.println("Inserted client %s in the database rows afected = %s'".formatted(client.getName(), rowsAffected));
        } catch (SQLException e) {
            System.out.println("Error while trying insert client '{%s}'".formatted(client.getName()));
            e.printStackTrace();
        }
    }
}
