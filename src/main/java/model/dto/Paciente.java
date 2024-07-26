package model.dto;

public class Paciente {

    private int id;
    private String name;
    private String lastName;
    private String address;
    private String phone;

    public Paciente() {
    }

    public Paciente(int id, String name, String lastName, String address, String phone) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Paciente:" +
                "id=" + id + '\n' +
                ", name='" + name + '\n' +
                ", lastName='" + lastName + '\n' +
                ", address='" + address + '\n' +
                ", phone='" + phone + '\n';
    }
}
