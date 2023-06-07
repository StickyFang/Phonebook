public class Contact {
    int id;
    String firstName;
    String lastName;
    String phoneNumber;
    String address;

    public Contact(int id, String firstName, String lastName, String phoneNumber, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String toString() {
        return  id + ": " + firstName + " " + lastName +
                ", Phone Number: " + phoneNumber + ", Address: " + address;
    }
}
