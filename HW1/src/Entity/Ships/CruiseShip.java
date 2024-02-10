package Entity.Ships;

public class CruiseShip extends Ship {
    int maxPassengers;

    public CruiseShip() {
        super();
    }

    public CruiseShip(String name, String year, int maxPassengers) {
        super(name, year);
        this.maxPassengers = maxPassengers;
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public void setMaxPassengers(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    @Override
    public String toString() {
        String name = getName();
        return "Name: " + name + ", Max Passengers: " + maxPassengers;
    }
}
