package parking_lot;

class ParkingSpot {
    private Vehicle vehicle;
    private VehicleType vehicleType;
    private Boolean isOccupied = false;

    ParkingSpot(VehicleType vehicleType){
        this.vehicleType = vehicleType;
    }

    public synchronized Boolean parkVehicle(Vehicle vehicle){
        if( isAvailable() && vehicle.getVehicleType() == vehicleType ){
            this.vehicle = vehicle;
            isOccupied = true;
            return true;
        }
        return false;
    }

    public synchronized Boolean unParkVehicle(Vehicle vehicle){
        if( !isAvailable() && vehicle.getVehicleType() == vehicleType && vehicle.getVehicleNo() == this.vehicle.getVehicleNo()){
            this.vehicle = null;
            isOccupied = false;
            return true;
        }
        return false;
    }

    public Boolean isAvailable(){
        return isOccupied == false;
    }

    public String getVehichleType(){
        return this.vehicleType.toString();
    }
}
