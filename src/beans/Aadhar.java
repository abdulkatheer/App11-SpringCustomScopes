package beans;

public class Aadhar {

    static {
        System.out.println("Aadhar bean class loading...");
    }

    public Aadhar() {
        System.out.println("Aadhar bean class instantiating...");
    }

    private String id;
    private String firstName;
    private String lastName;
    private String dob;
    private String address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
