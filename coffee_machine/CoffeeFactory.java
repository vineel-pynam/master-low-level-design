package coffee_machine;

import java.util.*;

class CoffeeFactory {
    private final Map<String, Coffee> coffeeRegistry = new HashMap<>();
    
    CoffeeFactory(){
        initialize();
    }

    public void registerCoffee(String name, Coffee coffee){
        coffeeRegistry.put(name, coffee);
    }

    public Coffee getCoffee(String name){
        Coffee coffee = coffeeRegistry.get(name);
        if( coffee == null ){
            throw new RuntimeException("Invalid coffee");
        }
        return coffee;
    }

    public void display(){
        System.out.println("Choose Coffee");
        Integer ind = 0;
        for( String name : coffeeRegistry.keySet() ){
            ind++;
            System.out.println( ind + ". " + name );
        }
    }

    private void initialize(){
        this.registerCoffee("Latte", new Latte());
        this.registerCoffee("Cappuccino", new Cappuccino());
        this.registerCoffee("Espresso", new Espresso());
    }
}
