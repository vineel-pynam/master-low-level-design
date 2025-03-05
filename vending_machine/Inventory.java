package vending_machine;
import java.util.*;

class Inventory{
    private List<Rack> racks;
    private Integer inventory_size;
    Inventory(Integer inventory_size){
        this.racks = new ArrayList<>();
        this.inventory_size = inventory_size;

        for( int i=1; i<=inventory_size; i++ ){
            this.racks.add(new Rack(i));
        }

    }

    public void addProduct(Integer rackId, Product product, Integer quantity){
        Rack rack = this.racks.stream()
                        .filter(e -> e.getRackNo().equals(rackId))
                        .findFirst()
                        .orElse(null);
        if( rack == null ) throw new RuntimeException("INVALID_RACK_ID");
        for( int i=0; i<quantity; i++ ){
            rack.addProduct(product);
        } 
    }

    public Rack selectRack(Integer rackID){
        return this.racks.stream().filter(e -> e.getRackNo().equals(rackID)).findFirst().orElse(null);
    }

}

