package Entity.Pizza;

import java.util.ArrayList;
import java.util.List;

public class PizzaBuilder {
    private PizzaSize size; // Mandatory
    private List<PizzaToppings> toppings;
    private PizzaChain chain;

    public PizzaBuilder(PizzaSize size) {
        this.size = size;
        this.toppings = new ArrayList<>();
    }
    
    public PizzaBuilder addTopping(PizzaToppings topping) {
        this.toppings.add(topping); 
        return this;
    }
    
    public PizzaBuilder chain(PizzaChain chain) {
        this.chain = chain;
        return this;
    }

    public Pizza build() {
        if (size == null) {
            throw new IllegalStateException("Pizza size cannot be null");
        }
        return new Pizza(this);
    }

    PizzaSize getSize() {
        return size;
    }

    List<PizzaToppings> getToppings() {
        return toppings;
    }

    PizzaChain getChain() {
        return chain;
    }
}
