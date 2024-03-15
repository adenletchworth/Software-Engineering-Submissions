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

public class RegularMealFactory implements MealFactory{
    private static RegularMealFactory instance = new RegularMealFactory();
    private List<Carb> regularCarbs;
    private List<Fat> regularFats;
    private List<Protein> regularProteins;
    private Random randomItem = new Random();

    private RegularMealFactory(){
        this.regularCarbs = Arrays.asList(
                CarbFactory.getInstance().createCarb("BREAD").get(),
                CarbFactory.getInstance().createCarb("LENTILS").get(),
                CarbFactory.getInstance().createCarb("PISTACHIO").get(),
                CarbFactory.getInstance().createCarb("CHEESE").get());
        this.regularFats = Arrays.asList(
                FatFactory.getInstance().createFat("AVOCADO").get(),
                FatFactory.getInstance().createFat("SOUR CREAM").get(),
                FatFactory.getInstance().createFat("TUNA").get(),
                FatFactory.getInstance().createFat("PEANUTS").get());
        this.regularProteins = Arrays.asList(
                ProteinFactory.getInstance().createProtein("CHICKEN").get(),
                ProteinFactory.getInstance().createProtein("BEEF").get(),
                ProteinFactory.getInstance().createProtein("FISH").get(),
                ProteinFactory.getInstance().createProtein("TOFU").get());
    }

    public static synchronized RegularMealFactory getInstance(){
        if (instance == null){
            instance = new RegularMealFactory();
        }
        return instance;
    }
    
    @Override
    public Carb createCarb() {
        return regularCarbs.get(randomItem.nextInt(regularCarbs.size()));
    }

    @Override
    public Fat createFat() {
        return regularFats.get(randomItem.nextInt(regularFats.size()));
    }

    @Override
    public Protein createProtein() {
        return regularProteins.get(randomItem.nextInt(regularProteins.size()));
    }
    
}
