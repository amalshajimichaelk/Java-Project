package models;

public class Supplier {
    private int supplierId;
    private String name;
    private String email;
    private String contactNumber;
    private String location;

    public Supplier() {}

    public Supplier(int supplierId, String name, String email, String contactNumber, String location) {
        this.supplierId = supplierId;
        this.name = name;
        this.email = email;
        this.contactNumber = contactNumber;
        this.location = location;
    }

    // Getters and Setters
    public int getSupplierId() {
        return supplierId;
    }
    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
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

    public String getContactNumber() {
        return contactNumber;
    }
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Supplier [ID=" + supplierId + ", Name=" + name +
               ", Email=" + email + ", Contact=" + contactNumber +
               ", Location=" + location + "]";
    }
}
