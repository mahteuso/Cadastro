package connectionJDBC.test;

import connectionJDBC.conn.SingleConnection;
import connectionJDBC.model.Client;
import connectionJDBC.repository.ClientRepository;

public class TestConnection {

    public static void main(String[] args) {
        Client client = new Client(1, "Mateus Laranjeira", "mateus@ufscar.br");
        ClientRepository repo = new ClientRepository();
        repo.save(client);
    }

}
