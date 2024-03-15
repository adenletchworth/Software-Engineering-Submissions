import Entity.Customer;
import Entity.Meals.MealService;
import Entity.Meals.Meal;

public class MealsDriver {
    public static void main(String[] args) {
        MealService mealService = new MealService();

        Customer john = new Customer("John", "Vegan");
        Customer jane = new Customer("Jane", "Regular");
        Customer jack = new Customer("Jack", "Paleo");
        Customer jill = new Customer("Jill", "Nut Allergy");
        Customer jess = new Customer("Jess", "Vegan");
        Customer josh = new Customer("Josh", "Regular");

        Meal johnsMeal = mealService.createMealForUser(john);
        Meal janesMeal = mealService.createMealForUser(jane);
        Meal jacksMeal = mealService.createMealForUser(jack);
        Meal jillsMeal = mealService.createMealForUser(jill);
        Meal jesssMeal = mealService.createMealForUser(jess);
        Meal joshsMeal = mealService.createMealForUser(josh);

        System.out.println("John's (Vegan) " + johnsMeal);
        System.out.println("Jane's (Regular) " + janesMeal);
        System.out.println("Jack's (Paleo) " + jacksMeal);
        System.out.println("Jill's (Nut Allergy) " + jillsMeal);
        System.out.println("Jesses (Vegan) " + jesssMeal);
        System.out.println("Josh's (Regular) " + joshsMeal);
    }
}
