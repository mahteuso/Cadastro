package connectionJDBC.service;

import connectionJDBC.model.PhoneClient;
import connectionJDBC.repository.ClientPhoneRepository;

import java.util.List;

public class ServicePhoneRepository {
    public static void save(PhoneClient phoneClient, int id) {
        ClientPhoneRepository clpRepository = new ClientPhoneRepository();
        idIsValid(id);
        clpRepository.save(phoneClient, id);
    }

    public static PhoneClient findOne(int id) {
        idIsValid(id);
        ClientPhoneRepository clpRepository = new ClientPhoneRepository();
         return  clpRepository.findOne(id);
    }

    public static List<PhoneClient> find(int id){
        idIsValid(id);
        ClientPhoneRepository clpRepository = new ClientPhoneRepository();
        return clpRepository.find(id);
    }

    private static void idIsValid(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid value for ID client");
        }
    }
}
