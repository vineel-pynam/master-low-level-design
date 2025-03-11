package coffee_machine;

class CoffeeMachineService {
    private Inventory inventory;
    private CoffeeFactory coffeeFactory;
    private Coffee selectedCoffee;
    private Double insertedAmount = 0.0;

    // states
    private CoffeeMachineState coffeeMachineState;
    private IdleState idleState;
    private MoneyInsertState moneyInsertState;
    private DispenseState dispenseState;
    private FinalState finalState;

    CoffeeMachineService(){
        this.inventory = Inventory.getInventory();
        this.coffeeFactory = CoffeeFactory.getInstance();
        this.idleState = new IdleState(this);
        this.moneyInsertState = new MoneyInsertState(this);
        this.dispenseState = new DispenseState(this);
        this.finalState = new FinalState(this);

        this.coffeeMachineState = idleState;
    }

    public void addIngredient(String name, Integer quantity){
        inventory.registerIngredient(name, quantity);
    }

    public void displayStock(){
        this.inventory.displayStockAvailabiltiy();
    }

    public void displayMenu(){
        this.coffeeFactory.display();
    }

    public void setState(CoffeeMachineState coffeeMachineState){
        this.coffeeMachineState = coffeeMachineState;
    }

    public void setSelectedCoffee(Coffee coffee){
        this.selectedCoffee = coffee;
    }

    public Coffee getSelectedCoffee(){
        return this.selectedCoffee;
    }


    public void setInsertedAmount(Double amount){
        this.insertedAmount = amount;
    }

    public Double getInsertedAmount(){
        return this.insertedAmount;
    }

    public Inventory getInventory(){
        return this.inventory;
    }

    // coffee factory
    public Coffee getCoffee(String name){
        return this.coffeeFactory.getCoffee(name);
    }

    // state based methods
    public void selectCoffee(String name){
        this.coffeeMachineState.selectCoffee(name);
    }

    public void insertMoney(Double amount){
        this.coffeeMachineState.insertMoney(amount);
    }

    public CoffeeMachineState getCoffeeMachineState() {
        return this.coffeeMachineState;
    }

    public IdleState getIdleState() {
        return this.idleState;
    }

    public MoneyInsertState getMoneyInsertState() {
        return this.moneyInsertState;
    }

    public DispenseState getDispenseState() {
        return this.dispenseState;
    }

    public FinalState getFinalState() {
        return this.finalState;
    }

}
