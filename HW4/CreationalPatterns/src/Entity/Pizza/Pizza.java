package Entity.Pizza;

import java.util.List;

public class Pizza {
    private PizzaSize size;
    private List<PizzaToppings> toppings;
    private PizzaChain chain;

    public Pizza(PizzaBuilder builder){
        this.size = builder.getSize();
        this.toppings = builder.getToppings();
        this.chain = builder.getChain();
    }

    public PizzaSize getSize() {
        return size;
    }

    public List<PizzaToppings> getToppings() {
        return toppings;
    }

    public PizzaChain getChain() {
        return chain;
    }
}
