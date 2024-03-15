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

public class NutAllergyMealFactory implements MealFactory{
    private static NutAllergyMealFactory instance = new NutAllergyMealFactory();
    private List<Carb> nutAllergyCarbs;
    private List<Fat> nutAllergyFats;
    private List<Protein> nutAllergyProteins;
    private Random randomItem = new Random();

    private NutAllergyMealFactory(){
        this.nutAllergyCarbs = Arrays.asList(
                CarbFactory.getInstance().createCarb("BREAD").get(),
                CarbFactory.getInstance().createCarb("LENTILS").get(),
                CarbFactory.getInstance().createCarb("CHEESE").get());
        this.nutAllergyFats = Arrays.asList(
                FatFactory.getInstance().createFat("AVOCADO").get(),
                FatFactory.getInstance().createFat("TUNA").get(),
                FatFactory.getInstance().createFat("SOUR CREAM").get());
        this.nutAllergyProteins = Arrays.asList(
                ProteinFactory.getInstance().createProtein("CHICKEN").get(),
                ProteinFactory.getInstance().createProtein("BEEF").get(),
                ProteinFactory.getInstance().createProtein("FISH").get(),
                ProteinFactory.getInstance().createProtein("TOFU").get());
    }

    public static synchronized NutAllergyMealFactory getInstance(){
        if (instance == null){
            instance = new NutAllergyMealFactory();
        }
        return instance;
    }

    @Override
    public Carb createCarb(){
        return nutAllergyCarbs.get(randomItem.nextInt(nutAllergyCarbs.size()));
    }

    @Override
    public Fat createFat(){
        return nutAllergyFats.get(randomItem.nextInt(nutAllergyFats.size()));
    }

    @Override
    public Protein createProtein(){
        return nutAllergyProteins.get(randomItem.nextInt(nutAllergyProteins.size()));
    }
}
