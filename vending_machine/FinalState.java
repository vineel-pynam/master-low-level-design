package vending_machine;

class FinalState extends VMState{
    FinalState(VendingMachineService vmService){
        super(vmService);
    }

    @Override
    public void selectRack(Integer rackId){
        System.out.println("[ERROR]: Rack is already selected");
    }

    @Override
    public void insertMoney(Integer value){
        System.out.println("[ERROR]: Can't add money now. Product is getting dispensed...");
    }

    @Override
    public void dispenseProduct(Rack rack){
        System.out.println("[SUCCESS]: Product Dispensed");
    }

    @Override
    public void giveChange(){
        System.out.println("[INFO]: Please Collect you change");
        System.out.println("[CHANGE]: " + Math.abs(this.vmService.getPriceDifference()));
        this.vmService.resetMoney();
        this.vmService.setRack(null);
        this.vmService.setState(this.vmService.getIdleState());
    }

    @Override
    public void cancel(){
        System.out.println("[ERROR]: Already Cancelled");
    }
}
