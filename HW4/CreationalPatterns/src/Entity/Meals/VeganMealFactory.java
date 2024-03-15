package Entity.Meals;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import Entity.Meals.Macronutrients.Carbs.Carb;
import Entity.Meals.Macronutrients.Carbs.CarbFactory;
import Entity.Meals.Macronutrients.Fats.Fat;
import Entity.Meals.Macronutrients.Fats.FatFactory;
import Entity.Meals.Macronutrients.Proteins.Protein;
import Entity.Meals.Macronutrients.Proteins.ProteinFactory;

public class VeganMealFactory implements MealFactory{
    private static VeganMealFactory instance = new VeganMealFactory();
    private List<Carb> veganCarbs; 
    private List<Fat> veganFats; 
    private List<Protein> veganProteins; 
    private Random randomItem = new Random();

    private VeganMealFactory(){
        this.veganCarbs = Arrays.asList(
                CarbFactory.getInstance().createCarb("BREAD").get(),
                CarbFactory.getInstance().createCarb("LENTILS").get(),
                CarbFactory.getInstance().createCarb("PISTACHIO").get());
        this.veganFats = Arrays.asList(
                FatFactory.getInstance().createFat("AVOCADO").get(),
                FatFactory.getInstance().createFat("PEANUTS").get());
        this.veganProteins = Arrays.asList(
                ProteinFactory.getInstance().createProtein("TOFU").get());
    }

    public static synchronized VeganMealFactory getInstance(){
        if (instance == null){
            instance = new VeganMealFactory();
        }
        return instance;
    }

    @Override
    public Carb createCarb() {
        return veganCarbs.get(randomItem.nextInt(veganCarbs.size()));
    }

    @Override
    public Fat createFat() {
        return veganFats.get(randomItem.nextInt(veganFats.size()));
    }

    @Override
    public Protein createProtein() {
        return veganProteins.get(randomItem.nextInt(veganProteins.size()));
    }
    
}
