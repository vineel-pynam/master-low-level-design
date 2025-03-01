package parking_lot;

import java.util.*;

class ParkingManager {
    List<Floor> floors;

    public static class SingletonHelper{
        public static final ParkingManager INSTANCE = new ParkingManager();
    }

    private ParkingManager(){
        this.floors = new ArrayList<>();
    }

    public static ParkingManager getInstance(){
        return SingletonHelper.INSTANCE;
    }

    public void addFloor(Floor floor){
        floors.add(floor);
    }

    public void parkVehicle(Vehicle vehicle){
        Boolean isParked = false;
        for( Floor floor: this.floors ){
            if( floor.parkVehicle(vehicle) ){
                isParked = true;
                break;
            }
        }
        
        if( isParked ){
            System.out.println("[VEHICLE_NO]: " + vehicle.getVehicleNo() + ", parked.");
        }else{
            System.out.println("[VEHICLE_NO]: " + vehicle.getVehicleNo() + ", unable to park vehicle.");
        }
    }

    public void unParkVehicle(Vehicle vehicle){
        Boolean isUnparked = false;
        for( Floor floor: this.floors ){
            if( floor.unParkVehicle(vehicle) ){
                isUnparked = true;
                break;
            }
        }
        
        if( isUnparked ){
            System.out.println("[VEHICLE_NO]: " + vehicle.getVehicleNo() + ", unparked.");
        }else{
            System.out.println("[VEHICLE_NO]: " + vehicle.getVehicleNo() + ", unable to unpark vehicle.");
        }
    }

    public void getParkingData(){
        for( Floor floor: this.floors ){
            floor.display();
        }
    }
}
