package HW1.Entity.Employees;

public class Employee {
    private String firstName;
    private String lastName;
    private String formattedSsnDashes; 

    public Employee() {
    }

    public Employee(String firstName, String lastName, String formattedSsnDashes) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.formattedSsnDashes = formattedSsnDashes;
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

    public String getformattedSsnDashes() {
        return formattedSsnDashes;
    }

    public void setformattedSsnDashes(String formattedSsnDashes) {
        this.formattedSsnDashes = formattedSsnDashes;
    }
}
