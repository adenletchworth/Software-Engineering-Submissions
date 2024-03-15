package Entity.Meals.Macronutrients.Carbs;

import java.util.Optional;

public class CarbFactory {
    private static CarbFactory instance;

    private CarbFactory() {}

    public static CarbFactory getInstance() {
        if (instance == null) {
            synchronized (CarbFactory.class) {
                if (instance == null) {
                    instance = new CarbFactory();
                }
            }
        }
        return instance;
    }

    public Optional<Carb> createCarb(String type) {
        if (type.equalsIgnoreCase("CHEESE")) {
            return Optional.of(new CheeseCarb());
        } else if (type.equalsIgnoreCase("BREAD")) {
            return Optional.of(new BreadCarb());
        } else if (type.equalsIgnoreCase("LENTILS")) {
            return Optional.of(new LentilCarb());
        } else if (type.equalsIgnoreCase("PISTACHIO")) {
            return Optional.of(new PistachioCarb());
        } else {
            return Optional.empty();
        }
    }
}
