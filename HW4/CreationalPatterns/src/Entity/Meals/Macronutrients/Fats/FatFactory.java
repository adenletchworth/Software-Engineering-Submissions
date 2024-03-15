package Entity.Meals.Macronutrients.Fats;

import java.util.Optional;

public class FatFactory {
    private static FatFactory instance;

    private FatFactory() {}

    public static FatFactory getInstance() {
        if (instance == null) {
            synchronized (FatFactory.class) {
                if (instance == null) {
                    instance = new FatFactory();
                }
            }
        }
        return instance;
    }

    public Optional<Fat> createFat(String type) {
        if (type.equalsIgnoreCase("AVOCADO")) {
            return Optional.of(new AvocadoFat());
        } else if (type.equalsIgnoreCase("SOUR CREAM")) {
            return Optional.of(new SourCreamFat());
        } else if (type.equalsIgnoreCase("TUNA")) {
            return Optional.of(new TunaFat());
        } else if (type.equalsIgnoreCase("PEANUTS")) {
            return Optional.of(new PeanutsFat());
        } else {
            return Optional.empty();
        }
    }
}
