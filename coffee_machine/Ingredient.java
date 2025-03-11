package coffee_machine;

import java.util.*;

class Ingredient {
    private String name;

    Ingredient(String name){
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj){
        if( obj == this ) return true;
        if( obj == null || getClass() != obj.getClass() ) return false;
        Ingredient ing = (Ingredient) obj;
        return name != null && ing.name != null && name.equalsIgnoreCase(ing.name);
    }

    @Override
    public int hashCode(){
        return Objects.hash(name);
    }
}
