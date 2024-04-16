package connectionJDBC.service;

import connectionJDBC.model.Client;
import connectionJDBC.repository.ClientRepository;

import javax.management.InvalidAttributeValueException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepository {

    public static void save(Client client) {
        ClientRepository clientRepository = new ClientRepository();
        clientRepository.save(client);
    }

    public static void delete(int id) {
        idIsValid(id);
        ClientRepository clientRepository = new ClientRepository();
        clientRepository.delete(id);
    }

    public static void update(int id, String name) {
        idIsValid(id);
        ClientRepository clientRepository = new ClientRepository();
        clientRepository.update(id, name);
    }

    public static List<Client> find() {
        ClientRepository clientRepository = new ClientRepository();
        return clientRepository.find();
    }

    public static Client findOne(int id) {
        idIsValid(id);
        ClientRepository clientRepository = new ClientRepository();
        return clientRepository.findOne(id);
    }


    private static void idIsValid(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid value for ID");
        }
    }
}
