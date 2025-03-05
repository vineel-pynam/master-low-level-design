package vending_machine;

abstract class Product{
    private String name;
    private Integer price;
    Product(String name, Integer price){
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return this.name;
    }

    public Integer getPrice(){
        return this.price;
    }
}


class Kitkat extends Product{
    Kitkat(){
        super("Kitkat", 10);
    }
}

class FiveStar extends Product{
    FiveStar(){
        super("FiveStar", 20);
    }
}


