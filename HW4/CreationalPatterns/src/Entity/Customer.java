package Entity;

public class Customer {
    private String name;
    private String dietaryRestrictions;

    public Customer(String name, String dietaryRestrictions) {
        this.name = name;
        this.dietaryRestrictions = dietaryRestrictions;
    }

    public String getName() {
        return name;
    }

    public String getDietaryRestrictions() {
        return dietaryRestrictions;
    }
}
