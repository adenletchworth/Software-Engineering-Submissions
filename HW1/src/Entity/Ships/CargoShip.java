package Entity.Ships;

public class CargoShip extends Ship {
    int maxCargoInTons;

    public CargoShip() {
        super();
    }

    public CargoShip(String name, String year, int maxCargoInTons) {
        super(name, year);
        this.maxCargoInTons = maxCargoInTons;
    }

    public int getMaxCargoInTons() {
        return maxCargoInTons;
    }

    public void setMaxCargoInTons(int maxCargoInTons) {
        this.maxCargoInTons = maxCargoInTons;
    }

    @Override
    public String toString() {
        String name = getName();
        return "Name: " + name + ", Max Cargo: " + maxCargoInTons + " tons";
    }
}
