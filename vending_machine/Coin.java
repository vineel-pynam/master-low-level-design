package vending_machine;

enum Coin {
  ONE(1), FIVE(5), TEN(10), HUNDRED(100);

  private Integer value;

  Coin(int value){
    this.value = value;
  }

  public Integer getValue(){
    return this.value;
  }
}
