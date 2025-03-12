package traffic_signal_controller_system;

import java.util.*;

class TrafficController {
    
    Map<String, TrafficLight> trafficLightsMap;
    private String emergencyMode = "OFF";

    TrafficController(){
        this.trafficLightsMap = new HashMap<>();
    }

    public void addTrafficLight(TrafficLight trafficLight){
        this.trafficLightsMap.put(trafficLight.getName(), trafficLight);
    }

    public void updateLight(String name, LightColor lightColor){
        TrafficLight trafficLight = this.trafficLightsMap.getOrDefault(name, null);
        if( trafficLight == null ){
            System.out.println("INVALID TRAFFIC LIGHT");
        }else{
            trafficLight.setLightColor(lightColor);
        }
    }

    public void onEmergencyMode(){
        this.emergencyMode = "ON";
        this.updateLight(LightColor.RED);
    }

    public void offEmergencyMode(){
        this.emergencyMode = "OFF";
        this.updateLight(LightColor.YELLOW);
    }

    private void updateLight(LightColor lightColor){
        for( TrafficLight trafficLight : this.trafficLightsMap.values()  ){
            trafficLight.setLightColor(lightColor);
        }
    }
}

