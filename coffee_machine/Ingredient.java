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
        return Objects.equals(this.name.toLowerCase(), ing.name.toLowerCase());
    }

    @Override
    public int hashCode(){
        return Objects.hash(name);
    }
}
