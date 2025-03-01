package parking_lot;

class ParkingLot {
    public static void main(String[] args) {
        ParkingManager parkingManager = ParkingManager.getInstance();
        parkingManager.addFloor(new Floor(1, 5));

        parkingManager.getParkingData();
        System.out.println();

        Vehicle bike = new Bike("Vineel", "BK-1");
        Vehicle car = new Car("Suneel", "CK-1");
        Vehicle truck = new Truck("Raju", "TK-1");
        Vehicle truck2 = new Truck("Ramesh", "TK-2");

        Vehicle bike2 = new Bike("Vineel", "BK-2");

        parkingManager.parkVehicle(bike);
        parkingManager.parkVehicle(car);
        parkingManager.parkVehicle(truck);
        parkingManager.parkVehicle(truck2);

        System.out.println();
        parkingManager.getParkingData();
        System.out.println();

        parkingManager.unParkVehicle(bike2);
        parkingManager.unParkVehicle(bike);

        System.out.println();
        parkingManager.getParkingData();
    }
}
