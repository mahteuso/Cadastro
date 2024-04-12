package connectionJDBC.model;

import java.util.Objects;

public class Client {
    private Integer id;
    private String name;
    private String email;

    public Client(Integer id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client userData)) return false;
        return Objects.equals(name, userData.name) && Objects.equals(email, userData.email) && Objects.equals(id, userData.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, id);
    }

    @Override
    public String toString() {
        return "UserData{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", id=" + id +
                '}';
    }
}
