package HW1.Entity.Employees;

public class SalariedEmployee extends Employee {
    double weeklySalary;

    public SalariedEmployee() {
        super();
    }

    public SalariedEmployee(String firstName, String lastName, String formattedSsnDashes, double weeklySalary) {
        super(firstName, lastName, formattedSsnDashes);
        this.weeklySalary = weeklySalary;
    }

    public double getWeeklySalary() {
        return weeklySalary;
    }

    public void setWeeklySalary(double weeklySalary) {
        this.weeklySalary = weeklySalary;
    }
}

