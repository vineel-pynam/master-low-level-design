package vending_machine;

class VendingMachine{
    public static void main(String[] args) {
        VendingMachineService vmService = VendingMachineService.getInstance();

        // making inventory
        Inventory inventory = new Inventory(2);
        inventory.addProduct(1, new Kitkat(), 1);
        inventory.addProduct(2, new FiveStar(), 2);

        // adding inventory
        vmService.addInvetory(inventory);

        vmService.selectRack(1);
        vmService.insertMoney(Coin.FIVE);
        vmService.insertMoney(Coin.TEN);

        System.out.println();
        vmService.selectRack(2);
        vmService.insertMoney(Coin.FIVE);
        vmService.insertMoney(Coin.TEN);
        vmService.insertMoney(Coin.HUNDRED);

    }
}