package Entity.Meals;

import Entity.Meals.Macronutrients.Carbs.Carb;
import Entity.Meals.Macronutrients.Fats.Fat;
import Entity.Meals.Macronutrients.Proteins.Protein;

public class Meal {
    private Carb carb;
    private Fat fat;
    private Protein protein;


    public Meal(Carb carb, Fat fat, Protein protein) {
        this.carb = carb;
        this.fat = fat;
        this.protein = protein;
    }

    public Carb getCarb() {
        return carb;
    }

    public Fat getFat() {
        return fat;
    }

    public Protein getProtein() {
        return protein;
    }

    @Override
    public String toString() {
        return "Meal{" +
               "carb=" + carb.getClass().getSimpleName() + 
               ", fat=" + fat.getClass().getSimpleName() + 
               ", protein=" + protein.getClass().getSimpleName() + 
               '}';
    }
}

