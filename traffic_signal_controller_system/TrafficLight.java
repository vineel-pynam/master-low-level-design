package traffic_signal_controller_system;

class TrafficLight {
    private String name;
    private LightColor lightColor;

    // Here Traffic light is dependent on Singnal Mapper.(Violate Dependency Inversion)
    // We can have Interface (TrafficLightObserver)  with update method, (singleMapper should implement it.)
    // Let's we other classes implemnting the interface(TrafficLightObserver) for ex logger. we can have list of observer of TrafficLightObserver.
    // they all can know status update based on light status/color.
    private SignalMapper signalMapper;

    TrafficLight(String name){
        this.name = name;
        this.lightColor = LightColor.RED;
        this.signalMapper = SignalMapper.getInstance();
    }

    public String getName(){
        return this.name;
    }

    public LightColor getLightColor() {
        return this.lightColor;
    }

    public void setLightColor(LightColor lightColor) {
        this.lightColor = lightColor;
        System.out.println("[NAME]: " + name + ", [LIGHT_COLOR]: " + this.lightColor.toString());
        this.signalMapper.updateRoad(this);
    }
}
