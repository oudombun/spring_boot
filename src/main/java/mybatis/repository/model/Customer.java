package mybatis.repository.model;

public class Customer {
    private String name;
    private String password;
    private String mobile;
    private String address;

    public Customer() {
    }

    public Customer(String name, String password, String mobile, String address) {
        this.name = name;
        this.password = password;
        this.mobile = mobile;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
