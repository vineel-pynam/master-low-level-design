package coffee_machine;

import java.util.*;

class Inventory {
    Map<Ingredient, Integer> stock;

    Inventory(){
        this.stock = new HashMap<>();
        initialize();
    }

    public void registerIngredient(String name, Integer quantity){
        Ingredient ingredient = new Ingredient(name);
        this.stock.put(ingredient, quantity);
    }

    public void removeIngredient(Ingredient ingredient){
        this.stock.remove(ingredient);
    }

    public Integer getQuantity(Ingredient ingredient){
        return this.stock.get(ingredient);
    }

    public Boolean hashEnoughIngredients(List<MeasuredIngredient> measuredIngredients){
        for( MeasuredIngredient measuredIngredient : measuredIngredients ){
            if( this.stock.get(measuredIngredient.getIngredient()) < measuredIngredient.getQuantity() ){
                return false;
            }
        }

        return true;
    }

    public void useIngredients(List<MeasuredIngredient> measuredIngredients){
        
        for( MeasuredIngredient measuredIngredient : measuredIngredients ){
            Integer updatedQuantity = this.stock.get(measuredIngredient.getIngredient()) - measuredIngredient.getQuantity();
            this.stock.put(measuredIngredient.getIngredient(), updatedQuantity);
        }
    }

    public void displayStockAvailabiltiy(){
        System.out.println("Stock Data");
        for( Map.Entry<Ingredient, Integer> entry : this.stock.entrySet() ){
            System.out.println("[Ingredient]: " + entry.getKey().getName() + ", [Quantity]: " + entry.getValue());
        }
    }

    public void initialize(){
        this.stock.put(new Ingredient("Water"), 30);
        this.stock.put(new Ingredient("Sugar"), 30);
        this.stock.put(new Ingredient("Hot Milk"), 30);
    }

}
