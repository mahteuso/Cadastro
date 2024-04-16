package connectionJDBC.repository;

import connectionJDBC.conn.SingleConnection;
import connectionJDBC.model.Client;
import connectionJDBC.model.PhoneClient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientPhoneRepository {

    private Connection conn;

    public ClientPhoneRepository(){
        conn = SingleConnection.getConnection();
    }

    public void save(PhoneClient  phoneClient, int id){
        String sql = "insert into client_phone (id_client, type, numphone) values " +
                "('%s', '%s', '%s')".formatted(id, phoneClient.getType(), phoneClient.getNumPhone());

        try{
            Statement stmt = conn.createStatement();
            int rowsAffected = stmt.executeUpdate(sql);
            stmt.getConnection().commit();
            System.out.println("Inserted phone number %s in the database, rows affected".formatted(id, rowsAffected));
        } catch (SQLException e){
            try {
                conn.rollback();
            } catch (SQLException ex) {
                System.out.println("Error while trying delete client id = '{%s}'".formatted(id));
                ex.printStackTrace();
            }
        }
    }

    public PhoneClient findOne(int id){
        String sql = "select * from client_phone where id = " + id;
        PhoneClient phoneClient = new PhoneClient();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();

            if (result.next()){
                phoneClient.setId_client(result.getInt("id_client"));
                phoneClient.setType(result.getString("type"));
                phoneClient.setNumPhone(result.getInt("numphone"));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return phoneClient;
    }

    public List<PhoneClient> find(int id){
        String sql = "select c.id_client, c.\"type\" , c.numphone, contato.\"name\" \n" +
                "from client_phone c\n" +
                "inner join contato \n" +
                "on c.id_client=contato.id\n" +
                "where c.id_client = " + id + ";";
        List<PhoneClient> phoneClientList = new ArrayList<>();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();

            while (result.next()){
                PhoneClient phoneClient = new PhoneClient();
                phoneClient.setId_client(result.getInt("id_client"));
                phoneClient.setType(result.getString("type"));
                phoneClient.setNameClient(result.getString("name"));
                phoneClient.setNumPhone(result.getInt("numphone"));
                phoneClientList.add(phoneClient);
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return phoneClientList;
    }


}
