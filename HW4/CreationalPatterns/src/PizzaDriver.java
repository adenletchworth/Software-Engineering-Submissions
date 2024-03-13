import Entity.Pizza.*;


public class PizzaDriver {
    public static void main(String[] args) {

        // One Pizza Chain Driver

        Pizza smallPizza = new PizzaBuilder(PizzaSize.SMALL)
                .addTopping(PizzaToppings.EXTRA_CHEESE)
                .addTopping(PizzaToppings.PEPPERONI)
                .chain(PizzaChain.PIZZA_HUT)
                .build();

        Pizza mediumPizza = new PizzaBuilder(PizzaSize.MEDIUM)
                .addTopping(PizzaToppings.HAM_AND_PINEAPPLE)
                .chain(PizzaChain.PIZZA_HUT)
                .build();

        Pizza largePizza = new PizzaBuilder(PizzaSize.LARGE)
                .addTopping(PizzaToppings.BACON)
                .addTopping(PizzaToppings.ONIONS)
                .chain(PizzaChain.PIZZA_HUT)
                .build();

        smallPizza.eat();
        mediumPizza.eat();
        largePizza.eat();

        // Franchise Driver

        Pizza smallPizzaHutPizza = new PizzaBuilder(PizzaSize.SMALL)
                .addTopping(PizzaToppings.SAUSAGE)
                .addTopping(PizzaToppings.PEPPERONI)
                .chain(PizzaChain.PIZZA_HUT)
                .build();

        Pizza largePizzaHutPizza = new PizzaBuilder(PizzaSize.LARGE)
                .addTopping(PizzaToppings.BACON)
                .addTopping(PizzaToppings.ONIONS)
                .addTopping(PizzaToppings.OLIVES)
                .chain(PizzaChain.PIZZA_HUT)
                .build();

        Pizza smallLittleCaesarsPizza = new PizzaBuilder(PizzaSize.SMALL)
                .addTopping(PizzaToppings.SAUSAGE)
                .addTopping(PizzaToppings.PEPPERONI)
                .addTopping(PizzaToppings.EXTRA_CHEESE)
                .addTopping(PizzaToppings.BACON)
                .addTopping(PizzaToppings.ONIONS)
                .addTopping(PizzaToppings.OLIVES)
                .chain(PizzaChain.LITTLE_CAESARS)
                .build();
        
        Pizza mediumLittleCaesarsPizza = new PizzaBuilder(PizzaSize.MEDIUM)
                .addTopping(PizzaToppings.SAUSAGE)
                .addTopping(PizzaToppings.PEPPERONI)
                .addTopping(PizzaToppings.EXTRA_CHEESE)
                .addTopping(PizzaToppings.BACON)
                .addTopping(PizzaToppings.ONIONS)
                .addTopping(PizzaToppings.OLIVES)
                .addTopping(PizzaToppings.HAM_AND_PINEAPPLE)
                .addTopping(PizzaToppings.SPICY_PORK)
                .chain(PizzaChain.LITTLE_CAESARS)
                .build();
        
        Pizza smallDominosPizza = new PizzaBuilder(PizzaSize.SMALL)
                .addTopping(PizzaToppings.PEPPERONI)
                .chain(PizzaChain.DOMINOS)
                .build();
        
        Pizza largeDominosPizza = new PizzaBuilder(PizzaSize.LARGE)
                .addTopping(PizzaToppings.PEPPERONI)
                .addTopping(PizzaToppings.MUSHROOMS)
                .addTopping(PizzaToppings.PEPPERS)
                .chain(PizzaChain.DOMINOS)
                .build();

                
        System.out.println();
        smallPizzaHutPizza.eat();
        largePizzaHutPizza.eat();
        smallLittleCaesarsPizza.eat();
        mediumLittleCaesarsPizza.eat();
        smallDominosPizza.eat();
        largeDominosPizza.eat();
    }
    
}
