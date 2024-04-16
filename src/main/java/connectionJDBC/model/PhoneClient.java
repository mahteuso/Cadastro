package connectionJDBC.model;

import java.util.Objects;

public class PhoneClient {
    private int id_client;
    private String type;
    private int numPhone;
    private String nameClient;

    public PhoneClient(){}

    public PhoneClient(String type, int numPhone){
        this.type = type;
        this.numPhone = numPhone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumPhone() {
        return numPhone;
    }

    public void setNumPhone(int numPhone) {
        this.numPhone = numPhone;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhoneClient telClient)) return false;
        return numPhone == telClient.numPhone && Objects.equals(type, telClient.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, numPhone);
    }

    @Override
    public String toString() {
        return "TelClient{" +
                "type='" + type + '\'' +
                ", numPhone=" + numPhone +
                ", id_client=" + id_client +
                '}';
    }
}
