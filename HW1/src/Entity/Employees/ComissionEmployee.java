package Entity.Employees;

public class ComissionEmployee extends Employee {
    double commisionRate;
    double grossSales;

    public ComissionEmployee() {
        super();
    }

    public ComissionEmployee(String firstName, String lastName, String formattedSsnDashes, double commisionRate, double grossSales) {
        super(firstName, lastName, formattedSsnDashes);
        this.commisionRate = commisionRate;
        this.grossSales = grossSales;
    }

    public double getCommisionRate() {
        return commisionRate;
    }

    public void setCommisionRate(double commisionRate) {
        this.commisionRate = commisionRate;
    }

    public double getGrossSales() {
        return grossSales;
    }

    public void setGrossSales(double grossSales) {
        this.grossSales = grossSales;
    }
}

    
    

