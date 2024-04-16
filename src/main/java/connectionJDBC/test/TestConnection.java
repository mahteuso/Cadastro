package connectionJDBC.test;

import connectionJDBC.conn.SingleConnection;
import connectionJDBC.model.Client;
import connectionJDBC.model.PhoneClient;
import connectionJDBC.repository.ClientRepository;
import connectionJDBC.service.ServicePhoneRepository;
import connectionJDBC.service.ServiceRepository;

import java.util.List;

public class TestConnection {

    public static void main(String[] args) {
        Client client = new Client("Mateus Laranjeira", "mateus@ufscar.br");
        Client client2 = new Client("Helena Leite", "helena@ufscar.br");
        Client client3 = new Client("Julia Dias", "julia@ufscar.br");
        Client client4 = new Client("Sbooby Doo", "sbooby@ufscar.br");
        Client client5 = new Client("Nina Simone", "nina@ufscar.br");
        ServiceRepository.update(4, "Mateus Silva Laranjeira");


//        ServiceRepository.save(client);
//        ServiceRepository.save(client2);
//        ServiceRepository.save(client3);
//        ServiceRepository.save(client4);
//        ServiceRepository.save(client5);
        List<Client> clients = ServiceRepository.find();
        System.out.println("========== List od clients ===========");
        for (Client client1 : clients) {
            System.out.println("Name = " + client1.getName() + "\nEmail = " + client1.getEmail() + "\nId = " + client1.getId());
            if (!clients.getLast().equals(client1)) {
                System.out.println("--------------------------------------");
            }
        }
        System.out.println("======================================");
        System.out.println();

//        PhoneClient phoneClient = new PhoneClient("Celular", 981521525);
//        ServicePhoneRepository.save(phoneClient, 3);
//
//
//        PhoneClient phoneClient = new PhoneClient("Celular", 981164070);
//        PhoneClient phoneClient1 = new PhoneClient("Fixo", 981521625);
//        ServicePhoneRepository.save(phoneClient, 4);
//        ServicePhoneRepository.save(phoneClient1, 4);

        System.out.println("========== List Phones of clients ===========");

        for (PhoneClient phone : ServicePhoneRepository.find(3)) {
            if (phone.equals(ServicePhoneRepository.find(3).getFirst())) {
                System.out.println("Client -> name: " + phone.getNameClient());
                System.out.println("---------------------------------------------");

            }
            System.out.println("Type = " + phone.getType() + "\nNumber = " + phone.getNumPhone() + "\nid_client = " + phone.getId_client());
            if (!phone.equals(ServicePhoneRepository.find(3).getLast())) {
                System.out.println("---------------------------------------------");
            }
        }
        System.out.println("=============================================");

        System.out.println("========== List Phones of clients ===========");

        for (PhoneClient phone : ServicePhoneRepository.find(4)) {
            if (phone.equals(ServicePhoneRepository.find(4).getFirst())) {
                System.out.println("Client -> name: " + phone.getNameClient());
                System.out.println("---------------------------------------------");

            }
            System.out.println("Type = " + phone.getType() + "\nNumber = " + phone.getNumPhone() + "\nid_client = " + phone.getId_client());
            if (!phone.equals(ServicePhoneRepository.find(4).getLast())) {
                System.out.println("---------------------------------------------");
            }
        }
        System.out.println("=============================================");

    }

}
