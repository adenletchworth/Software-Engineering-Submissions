package Entity.Macronutrients.Proteins;

import java.util.Optional;

public class ProteinFactory {
    private static ProteinFactory instance;

    private ProteinFactory() {}

    public static ProteinFactory getInstance() {
        if (instance == null) {
            synchronized (ProteinFactory.class) {
                if (instance == null) {
                    instance = new ProteinFactory();
                }
            }
        }
        return instance;
    }

    public Optional<Protein> createProtein(String type) {
        if (type.equalsIgnoreCase("CHICKEN")) {
            return Optional.of(new ChickenProtein());
        } else if (type.equalsIgnoreCase("BEEF")) {
            return Optional.of(new BeefProtein());
        } else if (type.equalsIgnoreCase("FISH")) {
            return Optional.of(new FishProtein());
        } else if (type.equalsIgnoreCase("Tofu")) {
            return Optional.of(new TofuProtein());
        } else {
            return Optional.empty();
        }
    }
        
}
