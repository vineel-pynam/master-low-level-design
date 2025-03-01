package parking_lot;
import java.util.*;

class Floor {
    private Integer floorNo;
    private List<ParkingSpot> parkingSpots;
    private Integer spotsCount;

    Floor(Integer floorNo, Integer spotsCount){
        this.parkingSpots = new ArrayList<>(spotsCount);
        this.spotsCount = spotsCount;
        this.floorNo = floorNo;
        
        initliazeSpots();
    }

    public void initliazeSpots(){
        // Initializing spots with ratio 50% Bikes, 30% cars & 20% Trucks
        Integer bikesSpots = (int) (this.spotsCount * 0.5);
        Integer carsSpots = (int) (this.spotsCount * 0.3);
        Integer truckSpots = (int) (this.spotsCount * 0.2);

        System.out.println("[B]: " + bikesSpots + " [C]: " + carsSpots + " [T]: " + truckSpots);

        for( int i=0; i<bikesSpots; i++ ){
            parkingSpots.add(new ParkingSpot(VehicleType.BIKE));
        }

        for( int i=0; i<carsSpots; i++ ){
            parkingSpots.add(new ParkingSpot(VehicleType.CAR));
        }

        for( int i=0; i<truckSpots; i++ ){
            parkingSpots.add(new ParkingSpot(VehicleType.TRUCK));
        }
    }

    public synchronized Boolean parkVehicle(Vehicle vehicle){
        for( ParkingSpot parkingSpot: this.parkingSpots ){
            if( parkingSpot.parkVehicle(vehicle) ){
                return true;
            }
        }
        return false;
    }

    public synchronized Boolean unParkVehicle(Vehicle vehicle){
        for( ParkingSpot parkingSpot: this.parkingSpots ){
            if( parkingSpot.unParkVehicle(vehicle) ){
                return true;
            }
        }
        return false;
    }

    public void display(){
        for( ParkingSpot parkingSpot: this.parkingSpots ){
            System.out.println("[VEHICLE_TYPE]: " + parkingSpot.getVehichleType() + ", [OCCUPIED]: " + (parkingSpot.isAvailable() ? "NO" : "YES" ) );
        }
    }
}
