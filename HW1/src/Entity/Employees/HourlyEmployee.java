package Entity.Employees;

public class HourlyEmployee extends Employee {
    double wage;
    double numberHoursWorked;

    public HourlyEmployee() {
        super();
    }

    public HourlyEmployee(String firstName, String lastName, String formattedSsnDashes, double wage, double numberHoursWorked) {
        super(firstName, lastName, formattedSsnDashes);
        this.wage = wage;
        this.numberHoursWorked = numberHoursWorked;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public double getNumberHoursWorked() {
        return numberHoursWorked;
    }

    public void setNumberHoursWorked(double numberHoursWorked) {
        this.numberHoursWorked = numberHoursWorked;
    }
}
