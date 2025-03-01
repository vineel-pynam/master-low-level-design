package parking_lot;

enum VehicleType{
    BIKE, CAR, TRUCK
}

abstract class Vehicle {
    private String ownerName;
    private String vehicleNo;
    private VehicleType vehicleType;

    Vehicle(String ownerName, String vehicleNo, VehicleType vehicleType){
        this.ownerName = ownerName;
        this.vehicleNo = vehicleNo;
        this.vehicleType = vehicleType;
    }

    public String getVehicleNo(){
        return this.vehicleNo;
    }

    public String getOwnerName(){
        return this.ownerName;
    }

    public VehicleType getVehicleType(){
        return this.vehicleType;
    }

    public void display(){
        System.out.println("[OWNER_NAME]: " + this.ownerName);
        System.out.println("[VEHICLE_NO]: " + this.vehicleNo);
        System.out.println("[VEHICLE_TYPE]: " + this.vehicleType.toString());
    }
}

class Bike extends Vehicle{
    Bike(String ownerName, String vehicleNo){
        super(ownerName, vehicleNo, VehicleType.BIKE);
    }
}

class Car extends Vehicle{
    Car(String ownerName, String vehicleNo){
        super(ownerName, vehicleNo, VehicleType.CAR);
    }
}

class Truck extends Vehicle{
    Truck(String ownerName, String vehicleNo){
        super(ownerName, vehicleNo, VehicleType.TRUCK);
    }
}
