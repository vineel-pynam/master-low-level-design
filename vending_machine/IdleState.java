package vending_machine;

class IdleState extends VMState{
    
    IdleState(VendingMachineService vmService){
        super(vmService);
    }

    @Override
    public void selectRack(Integer rackId){
        Rack rack = this.vmService.getInventory().selectRack(rackId);
        if( rack == null || rack.getQuantity().equals(0)){
            throw new RuntimeException("Rack is empty");
        }
        this.vmService.setRack(rack);
        this.vmService.setState(this.vmService.getReadyState());
        System.out.println("[SELECTED]: Rack-" + rack.getRackNo());
        System.out.println("[INFO]: Please add required money");
    }

    @Override
    public void insertMoney(Integer value){
        System.out.println("[ERROR]: Please select product");
    }

    @Override
    public void dispenseProduct(Rack rack){
        System.out.println("[ERROR]: Please select product");
    }

    @Override
    public void giveChange(){
        System.out.println("[ERROR]: No Money Inserted");
    }

    @Override
    public void cancel(){
        System.out.println("[ERROR]: Please select product");
    }
}

