package coffee_machine;

class MeasuredIngredient {
    private Ingredient ingredient;
    private Integer quantity;

    MeasuredIngredient(Ingredient ingredient, Integer quantity){
        this.ingredient = ingredient;
        this.quantity = quantity;
    }

    public Ingredient getIngredient() {
        return this.ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    
}
