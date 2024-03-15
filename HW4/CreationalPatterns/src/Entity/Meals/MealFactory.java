package Entity.Meals;

import Entity.Meals.Macronutrients.Carbs.Carb;
import Entity.Meals.Macronutrients.Fats.Fat;
import Entity.Meals.Macronutrients.Proteins.Protein;

public interface MealFactory {
    public Carb createCarb();
    public Fat createFat();
    public Protein createProtein();
}
