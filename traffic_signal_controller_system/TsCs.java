package traffic_signal_controller_system;

class TsCs{
    public static void main(String[] args) {
        SignalMapper signalMapper = SignalMapper.getInstance();

        TrafficLight tl1 = new TrafficLight("Light-1");
        TrafficLight tl2 = new TrafficLight("Light-2");
        TrafficLight tl3 = new TrafficLight("Light-3");

        signalMapper.addMapper(tl1, new Road("Road-2"));
        signalMapper.addMapper(tl2, new Road("Road-3"));
        signalMapper.addMapper(tl3, new Road("Road-1"));

        TrafficController tc = new TrafficController();
        tc.addTrafficLight(tl1);
        tc.addTrafficLight(tl2);
        tc.addTrafficLight(tl3);

        tc.updateLight("Light-1", LightColor.GREEN);
        tc.updateLight("Light-2", LightColor.YELLOW);
        tc.updateLight("Light-3", LightColor.RED);

        System.out.println();
        tc.onEmergencyMode();

        System.out.println();
        tc.offEmergencyMode();

    }
}