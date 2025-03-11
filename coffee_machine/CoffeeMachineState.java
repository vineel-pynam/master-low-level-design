package coffee_machine;

interface CoffeeMachineState {
    void selectCoffee(String name);
    void insertMoney(Double amount);
    void dispenseCoffee();
    void giveChange();
}

class IdleState implements CoffeeMachineState{
    private CoffeeMachineService cms;

    IdleState(CoffeeMachineService coffeeMachineService){
        this.cms = coffeeMachineService;
    }

    @Override
    public void selectCoffee(String name) {
        Coffee coffee = this.cms.getCoffee(name);
        Inventory inventory = this.cms.getInventory();
        Boolean isSufficient = inventory.hasEnoughIngredients(coffee.getMeasuredIngredients());

        if( !isSufficient ){
            throw new RuntimeException("Not Enough Ingredients, Please select another type of coffee");
        }else{
            inventory.useIngredients(coffee.getMeasuredIngredients());
        }

        System.out.println("[INFO]: Selected Coffee - " + coffee.getName() + ", Price - " + coffee.getPrice());
        this.cms.setSelectedCoffee(coffee);
        this.cms.setState(this.cms.getMoneyInsertState());
    }

    @Override
    public void insertMoney(Double amount) {
        System.out.println("[ERR]: Please Select Coffee");
    }

    @Override
    public void dispenseCoffee() {
        System.out.println("[ERR]: Please Select Coffee");
    }

    @Override
    public void giveChange() {
        System.out.println("[ERR]: Please Select Coffee");
    }

}

class MoneyInsertState implements CoffeeMachineState{
    private CoffeeMachineService cms;

    MoneyInsertState(CoffeeMachineService coffeeMachineService){
        this.cms = coffeeMachineService;
    }

    @Override
    public void selectCoffee(String name) {
        System.out.println("[ERR]: Please Insert Required Money");
    }

    @Override
    public void insertMoney(Double amount) {
        this.cms.setInsertedAmount(this.cms.getInsertedAmount() + amount);
        Coffee coffee = this.cms.getSelectedCoffee();
        Double amountInserted = this.cms.getInsertedAmount();

        if( amountInserted >= coffee.getPrice() ){
            this.cms.setState(this.cms.getDispenseState());
            this.cms.getCoffeeMachineState().dispenseCoffee();
        }else{
            System.out.println("[ERR]: Insert More - " + Math.abs(coffee.getPrice() - amountInserted ));
        }
    }

    @Override
    public void dispenseCoffee() {
        System.out.println("[ERR]: Please Insert Required Money");
    }

    @Override
    public void giveChange() {
        System.out.println("[ERR]: Please Insert Required Money");
    }

}


class DispenseState implements CoffeeMachineState{
    private CoffeeMachineService cms;

    DispenseState(CoffeeMachineService coffeeMachineService){
        this.cms = coffeeMachineService;
    }

    @Override
    public void selectCoffee(String name) {
        System.out.println("[ERR]: Coffee is getting dispensed");
    }

    @Override
    public void insertMoney(Double amount) {
        System.out.println("[ERR]: Coffee is getting dispensed");
    }

    @Override
    public void dispenseCoffee() {
        System.out.println("[SUCCESS]: You Coffee - " + this.cms.getSelectedCoffee().getName() + " is ready, Enjoy" );
        this.cms.setState(this.cms.getFinalState());
        this.cms.getCoffeeMachineState().giveChange();
    }

    @Override
    public void giveChange() {
        System.out.println("[ERR]: Coffee is getting dispensed");
    }

}


class FinalState implements CoffeeMachineState{
    private CoffeeMachineService cms;

    FinalState(CoffeeMachineService coffeeMachineService){
        this.cms = coffeeMachineService;
    }

    @Override
    public void selectCoffee(String name) {
        System.out.println("[INFO]: Please collect your change");
    }

    @Override
    public void insertMoney(Double amount) {
        System.out.println("[INFO]: Please collect your change");
    }

    @Override
    public void dispenseCoffee() {
        System.out.println("[INFO]: Please collect your change");
    }

    @Override
    public void giveChange() {
        System.out.println("[INFO]: Please collect your change");
        System.out.println("[CHANGE]: " + Math.abs(this.cms.getSelectedCoffee().getPrice() - this.cms.getInsertedAmount()));
        this.cms.setSelectedCoffee(null);
        this.cms.setInsertedAmount(0.0);
        this.cms.setState(this.cms.getIdleState());
    }

}
