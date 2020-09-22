package ds;

public class Student {
    private String firstName;
    private String lastName;
    private int id;
    private String password;

    @Override
    public String toString() {
        return "First Name: '" + firstName + "'\n" +
                "Last Name: '" + lastName + "'\n" +
                "ID: " + id + "\n" +
                "Password: '" + password + "'";
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Student () {
        firstName = ""; lastName = ""; password = ""; id = 0;
    }

    public Student (String firstName, String lastName, int id, String password) {
        this.firstName = firstName; this.lastName = lastName; this.id = id; this.password = password;
    }


}
