import Entity.Ships.CargoShip;
import Entity.Ships.CruiseShip;
import Entity.Ships.Ship;

public class ShipDriver {
    public static void main(String[] args) {
        Ship blackPearl = new Ship("Black Pearl", "1729");
        CruiseShip carnivalExplorer = new CruiseShip("Carnival Explorer", "2000", 2000);
        CargoShip evergreenBlocker = new CargoShip("Evergreen Blocker", "2010", 20000);

        Ship[] ships = { blackPearl, carnivalExplorer, evergreenBlocker };

        for (Ship ship : ships) {
            System.out.println(ship);
            System.out.println();
        }
    }
}
