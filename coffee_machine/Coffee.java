package coffee_machine;
import java.util.*;

abstract class Coffee {
    private String name;
    private List<MeasuredIngredient> measuredIngredients;
    private Double price;

    public String getName() {
        return this.name;
    }

    public List<MeasuredIngredient> getMeasuredIngredients() {
        return this.measuredIngredients;
    }


    public Double getPrice() {
        return this.price;
    }

    Coffee( String name, Double price, List<MeasuredIngredient> measuredIngredients){
        this.name = name;
        this.measuredIngredients = Collections.unmodifiableList(measuredIngredients);
        this.price = price;
    }

    public abstract void makeCoffee();
}

class Espresso extends Coffee{
    Espresso(){
        super("Espresso", 100.00, List.of(
            new MeasuredIngredient(new Ingredient("Hot Milk"), 30),
            new MeasuredIngredient(new Ingredient("Sugar"), 10),
            new MeasuredIngredient(new Ingredient("Water"), 10)
        ));
    }

    @Override
    public void makeCoffee(){
        // to be implemented
    }
}

class Latte extends Coffee{
    Latte(){
        super("Latte", 80.00, List.of(
            new MeasuredIngredient(new Ingredient("Water"), 10),
            new MeasuredIngredient(new Ingredient("Hot Milk"), 10),
            new MeasuredIngredient(new Ingredient("Sugar"), 10)
        ));
    }

    @Override
    public void makeCoffee(){
        // to be implemented
    }
}

class Cappuccino extends Coffee{
    Cappuccino(){
        super("Cappuccino", 100.00, List.of(
            new MeasuredIngredient(new Ingredient("Hot Milk"), 50),
            new MeasuredIngredient(new Ingredient("Sugar"), 10)
        ));
    }

    @Override
    public void makeCoffee(){
        // to be implemented
    }
}