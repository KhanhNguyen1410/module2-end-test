package model;

public class PhoneBook {
    private int sdt;
    private String group;
    private String name;
    private String gender;
    private String address;

    public PhoneBook() {
    }

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public PhoneBook(int sdt, String group, String name, String gender, String address) {
        this.sdt = sdt;
        this.group = group;
        this.name = name;
        this.gender = gender;
        this.address = address;
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "sdt=" + sdt +
                ", group='" + group + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
