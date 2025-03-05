package vending_machine;

class VendingMachineService{

    private Inventory inventory;
    private Rack selectedRack;
    private VMState vendingMachineState;
    private Integer insertedMoney = 0;

    private final VMState idelState;
    private final VMState readyState;
    private final VMState dispenseState;
    private final VMState finalState;

    VendingMachineService(){

        this.idelState = new IdleState(this);
        this.readyState = new ReadyState(this);
        this.dispenseState = new DispenseState(this);
        this.finalState = new FinalState(this);

        this.vendingMachineState = idelState;
    }

    private static class SingletonHelper{
        public final static VendingMachineService INSTANCE = new VendingMachineService();
    } 

    public static VendingMachineService getInstance(){
        return SingletonHelper.INSTANCE;
    }

    public void addInvetory(Inventory inventory){
        this.inventory = inventory;
    }

    public Inventory getInventory(){
        return this.inventory;
    }

    public void selectRack(Integer rackNo){
        vendingMachineState.selectRack(rackNo);
    }

    public void setRack(Rack rack){
        this.selectedRack = rack;
    }

    public void addMoney(Integer value){
        this.insertedMoney += value;
    }

    public void insertMoney(Coin coin){
        this.vendingMachineState.insertMoney(coin.getValue());
    }

    public Boolean isSufficientMoney(){
        return this.insertedMoney >= selectedRack.getRackPrice();
    }

    public void setState(VMState vmState){
        this.vendingMachineState = vmState;
    }

    public VMState getDispenseState(){
        return this.dispenseState;
    }

    public VMState getIdleState(){
        return this.idelState;
    }


    public VMState getReadyState(){
        return this.readyState;
    }

    public VMState getFinalState(){
        return this.finalState;
    }

    
    public Integer getPriceDifference(){
        return this.selectedRack.getRackPrice() - this.insertedMoney;
    }

    public Rack getSelectedRack(){
        return this.selectedRack;
    }

    public void dispenseProduct(){
        this.vendingMachineState.dispenseProduct(selectedRack);
    }

    public void giveChange(){
        this.vendingMachineState.giveChange();
    }

    public void Cancel(){
        this.vendingMachineState.cancel();
    }

    public void resetMoney(){
        this.insertedMoney = 0;
    }

}
