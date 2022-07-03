package Tables.Publisher;

public class Publisher {
    private int publisherId ;
    private String name;
    private String address;
    private String phone;
    private String manager;

    public Publisher() {
    }

    public Publisher(int publisherId, String name, String address, String phone, String manager) {
        this.publisherId = publisherId;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.manager = manager;
    }

    public Publisher( String name, String address, String phone,String manager) {
        this.manager = manager;
        this.name = name;
        this.address = address;
        this.phone = phone;

    }
    public Publisher( String name, String address) {

        this.name = name;
        this.address = address;


    }


    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "publisherId=" + publisherId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", manager='" + manager + '\'' +
                '}';
    }
}
