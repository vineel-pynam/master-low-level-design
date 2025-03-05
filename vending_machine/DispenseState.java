package vending_machine;

class DispenseState extends VMState{
    DispenseState(VendingMachineService vmService){
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
        Product product = rack.getProduct();
        rack.RemoveProduct(product);
        System.out.println("[CONGRATULATIONS]: your product is getting dispensed...");
        System.out.println("[DISPENSED]: " + product.getName());
        this.vmService.setState(this.vmService.getFinalState());
        this.vmService.giveChange();
    }

    @Override
    public void giveChange(){
        System.out.println("[ERROR]: Please Wait");
    }

    @Override
    public void cancel(){
        System.out.println("[ERROR]: Cannot cancel now");
    }
}

