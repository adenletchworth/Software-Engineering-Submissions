package Entity.Meals;

import Entity.Customer;

public class MealService {

    public Meal createMealForUser(Customer user){
        MealFactory mealFactory = getMealFactory(user.getDietaryRestrictions());
        if (mealFactory != null){
            return new Meal(mealFactory.createCarb(), mealFactory.createFat(), mealFactory.createProtein());
        }else {
            throw new IllegalArgumentException("Invalid dietary restrictions");
        }
    }

    private MealFactory getMealFactory(String dietaryRestrictions){
        switch (dietaryRestrictions.toUpperCase()){
            case "VEGAN":
                return VeganMealFactory.getInstance();
            case "PALEO":
                return PaleoMealFactory.getInstance();
            case "REGULAR":
                return RegularMealFactory.getInstance();
            case "NUT ALLERGY":
                return NutAllergyMealFactory.getInstance();
            default:
                return null;
        }

    }
    
}
