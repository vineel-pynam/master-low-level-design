package vending_machine;

abstract class VMState{
    protected VendingMachineService vmService;
    VMState(VendingMachineService vMachineService){
        this.vmService = vMachineService;
    }

    public abstract void selectRack(Integer rackId);
    public abstract void insertMoney(Integer value);
    public abstract void dispenseProduct(Rack rack);
    public abstract void giveChange();
    public abstract void cancel();
}

