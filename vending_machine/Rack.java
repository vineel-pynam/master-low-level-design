package vending_machine;
import java.util.*;

class Rack{
    private List<Product> products;
    private Integer rackPrice;
    private Integer rackNo;
    private Integer quantity;

    Rack(Integer rackNo){
        this.products = new ArrayList<>();
        this.rackNo = rackNo;
    }

    public Integer getRackNo(){
        return this.rackNo;
    }

    public Integer getRackPrice(){
        return this.rackPrice;
    }

    public Integer getQuantity(){
        return this.quantity;
    }

    public void addProduct(Product product){
        this.products.add(product);
        this.quantity = this.products.size();
        this.rackPrice = product.getPrice();
    }

    public Product getProduct(){
        if( this.quantity == 0 ){
            throw new RuntimeException("No Products in this rack");
        }
        Product product = this.products.get(this.quantity-1);
        return product;
    }

    public void RemoveProduct(Product product){
        if( this.quantity < 0 ) {
            this.quantity = 0;
            return;
        }
        this.products.remove(product);
        this.quantity--;
    }

}
