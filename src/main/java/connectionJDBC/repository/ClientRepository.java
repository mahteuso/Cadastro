package connectionJDBC.repository;

import connectionJDBC.conn.SingleConnection;
import connectionJDBC.model.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientRepository {

    private Connection connection;

    public ClientRepository() {
        connection = SingleConnection.getConnection();
    }

    public void save(Client client) {
        String sql = "insert into contato (name, email) values ('%s', '%s')".formatted(client.getName(), client.getEmail());
        try {
            Statement stmt = connection.createStatement();
            int rowsAffected = stmt.executeUpdate(sql);
            stmt.getConnection().commit();
            System.out.println("Inserted client %s in the database, rows afected = %s'".formatted(client.getName(), rowsAffected));
        } catch (SQLException e) {
            System.out.println("Error while trying insert client '{%s}'".formatted(client.getName()));
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM contato WHERE id = '%s'".formatted(id);
        try {
            Statement stmt = connection.createStatement();
            int rowsAffected = stmt.executeUpdate(sql);
            stmt.getConnection().commit();
            System.out.println("Deleted client id =  %s from database, rows afected = %s'".formatted(id, rowsAffected));
        } catch (SQLException e) {
            System.out.println("Error while trying delete client id = '{%s}'".formatted(id));
            e.printStackTrace();
        }
    }

    public void update(int id, String name) {
        String sql = "UPDATE contato  SET name = '%s' WHERE id = '%s'".formatted(name, id);
        try {
            Statement stmt = connection.createStatement();
            int rowsAffected = stmt.executeUpdate(sql);
            stmt.getConnection().commit();
            System.out.println("Updated client id = %s from database, rows afected = %s'".formatted(id, rowsAffected));
        } catch (SQLException e) {
            System.out.println("Error while trying update client id = '{%s}'".formatted(id));
            e.printStackTrace();
        }
    }

    public List<Client> find() {
        String sql = "Select * from contato";
        List<Client> clients = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();

            while (result.next()) {
                Client client1 = new Client();
                client1.setId(result.getInt("id"));
                client1.setName(result.getString("name"));
                client1.setEmail(result.getString("email"));
                clients.add(client1);

            }
        } catch (SQLException e) {
            System.out.println("Error while trying find client");
            e.printStackTrace();
        }

        return clients;
    }

    public Client findOne(int id) {
        String sql = "Select * from contato where id = " + id;
        Client client1 = new Client();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();

            if (result.next()) {
                client1.setId(result.getInt("id"));
                client1.setName(result.getString("name"));
                client1.setEmail(result.getString("email"));
            }

        } catch (SQLException e) {
            System.out.println("Error while trying find client");
            e.printStackTrace();
        }
        return client1;
    }
}
