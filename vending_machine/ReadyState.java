package vending_machine;

class ReadyState extends VMState{
    ReadyState(VendingMachineService vmService){
        super(vmService);
    }

    @Override
    public void selectRack(Integer rackId){
        System.out.println("Rack is already selected");
    }

    @Override
    public void insertMoney(Integer value){
        this.vmService.addMoney(value);
        if( this.vmService.isSufficientMoney() ){
            this.vmService.setState(this.vmService.getDispenseState());
            this.vmService.dispenseProduct();
        }else{
            System.out.println("[ADD_MORE]: " + this.vmService.getPriceDifference());
        }
    }

    @Override
    public void dispenseProduct(Rack rack){
        System.out.println("[INSUFFICIENT_MONEY]: Please add more money");
    }

    @Override
    public void giveChange(){
        System.out.println("[ERROR]: Please cancel");
    }

    @Override
    public void cancel(){
        System.out.println("Cancelled");
        this.vmService.setState(this.vmService.getFinalState());
        this.vmService.giveChange();
    }
}
