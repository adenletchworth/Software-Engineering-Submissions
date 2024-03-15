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

public class PaleoMealFactory implements MealFactory{
    private static PaleoMealFactory instance = new PaleoMealFactory();
    private List<Carb> paleoCarbs;
    private List<Fat> paleoFats;
    private List<Protein> paleoProteins;
    private Random randomItem = new Random();

    private PaleoMealFactory(){
        this.paleoCarbs = Arrays.asList(
                CarbFactory.getInstance().createCarb("PISTACHIO").get());
        this.paleoFats = Arrays.asList(
                FatFactory.getInstance().createFat("AVOCADO").get(),
                FatFactory.getInstance().createFat("TUNA").get(),
                FatFactory.getInstance().createFat("PEANUTS").get());
        this.paleoProteins = Arrays.asList(
                ProteinFactory.getInstance().createProtein("CHICKEN").get(),
                ProteinFactory.getInstance().createProtein("BEEF").get(),
                ProteinFactory.getInstance().createProtein("FISH").get());
    }

    public static synchronized PaleoMealFactory getInstance(){
        if (instance == null){
            instance = new PaleoMealFactory();
        }
        return instance;
    }
    
    @Override
    public Carb createCarb() {
        return paleoCarbs.get(randomItem.nextInt(paleoCarbs.size()));
    }

    @Override
    public Fat createFat() {
        return paleoFats.get(randomItem.nextInt(paleoFats.size()));
    }

    @Override
    public Protein createProtein() {
        return paleoProteins.get(randomItem.nextInt(paleoProteins.size()));
    }
    
}
