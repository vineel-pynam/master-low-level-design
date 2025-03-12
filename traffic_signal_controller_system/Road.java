package traffic_signal_controller_system;

class Road {
    private String name;
    
    Road(String name){
        this.name = name;
    }

    public void updateTrafficAction(TrafficAction trafficAction){
        System.out.println("[ROAD]: " + name + " -> " + trafficAction.message() );
    }
    
}
