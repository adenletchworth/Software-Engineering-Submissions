import Entity.Employees.BaseEmployee;
import Entity.Employees.ComissionEmployee;
import Entity.Employees.Employee;
import Entity.Employees.HourlyEmployee;
import Entity.Employees.SalariedEmployee;

public class EmployeeDriver {
    public static void main(String[] args) {
        SalariedEmployee joeJones = new SalariedEmployee("Joe", "Jones", "111-11-1111", 2500.00);
        HourlyEmployee stephanieSmith = new HourlyEmployee("Stephanie", "Smith", "222-22-2222", 25.00, 32.00);
        HourlyEmployee maryQuinn = new HourlyEmployee("Mary", "Quinn", "333-33-3333", 19.00, 47.00);
        ComissionEmployee nicoleDior = new ComissionEmployee("Nicole", "Dior", "444-44-4444", 0.15, 50000.00);
        SalariedEmployee renwaChanel = new SalariedEmployee("Renwa", "Chanel", "555-55-5555", 1700.00);
        BaseEmployee mikeDavenport = new BaseEmployee("Mike", "Davenport", "666-66-6666", 95000.00);
        ComissionEmployee mahnazVaziri = new ComissionEmployee("Mahnaz", "Vaziri", "777-77-7777", 0.22, 40000.00);

        Employee[] employees = { joeJones, stephanieSmith, maryQuinn, nicoleDior, renwaChanel, mikeDavenport, mahnazVaziri };

        for (Employee employee : employees) {
            System.out.println(employee.getFirstName());
        }
    }
}
