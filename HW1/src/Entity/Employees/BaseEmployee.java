package Entity.Employees;

public class BaseEmployee extends Employee {
    double baseSalary;
    
    public BaseEmployee() {
        super();
    }
    
    public BaseEmployee(String firstName, String lastName, String formattedSsnDashes, double baseSalary) {
        super(firstName, lastName, formattedSsnDashes);
        this.baseSalary = baseSalary;
    }
    
    public double getBaseSalary() {
        return baseSalary;
    }
    
    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }
}


    

