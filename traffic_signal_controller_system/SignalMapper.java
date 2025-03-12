package traffic_signal_controller_system;
import java.util.*;

class SignalMapper {
    Map<TrafficLight, Road> roadLightMap;
    Map<LightColor, TrafficAction> trafficActionMap;

    public static class SingletonHelper{
        public static final SignalMapper INSTANCE = new SignalMapper();
    }

    private SignalMapper(){
        this.roadLightMap = new HashMap<>();
        this.trafficActionMap = new HashMap<>();
        initialize();
    }

    public static SignalMapper getInstance(){
        return SingletonHelper.INSTANCE;
    }

    public void addMapper(TrafficLight trafficLight,  Road road){
        this.roadLightMap.put(trafficLight, road);
    }

    public void updateRoad(TrafficLight trafficLight){
        Road road = this.roadLightMap.getOrDefault(trafficLight, null);
        TrafficAction trafficAction = this.trafficActionMap.getOrDefault(trafficLight.getLightColor(), null);

        if( road == null || trafficAction == null){
            System.out.println("INVALID UPDATE");
        }else{  
            road.updateTrafficAction(trafficAction);
        }
    }

    // Can use Traffic Action Factory For this simple use cases, (there chances of violating, OCP).
    // For if else cases, we can use Map to solve OCP.
    private void initialize(){
        this.trafficActionMap.put(LightColor.GREEN, new Moving());
        this.trafficActionMap.put(LightColor.YELLOW, new MovingSlow());
        this.trafficActionMap.put(LightColor.RED, new NotMoving());
    }

}   
