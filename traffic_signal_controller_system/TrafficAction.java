package traffic_signal_controller_system;

interface TrafficAction {
    String message();
}

class Moving implements TrafficAction{
    @Override
    public String message(){
        return "vehicles are started moving, normally";
    }
}

class MovingSlow implements TrafficAction{
    @Override
    public String message(){
        return "vehicles are started moving, slowly";
    }
}

class NotMoving implements TrafficAction{
    @Override
    public String message(){
        return "all vehicles are stopped";
    }
}
