public class Tesla extends ElectricCar

{

    private boolean isAutoPilotEnabled;
    private boolean isFullSelfDrivingEnabled;
    private boolean isTeslaTheatreEnabled;

    protected Tesla(){
        this("C001", "Tesla", null, null,100,false,false,false);
    }

    protected Tesla(boolean isAutoPilotEnabled, boolean isFullSelfDrivingEnabled, boolean isTeslaTheatreEnabled) {
        this.isAutoPilotEnabled = isAutoPilotEnabled;
        this.isFullSelfDrivingEnabled = isFullSelfDrivingEnabled;

        this.isTeslaTheatreEnabled = isTeslaTheatreEnabled;
    }
    protected Tesla(String id, String carModelName, ChargingStation chargingStation, CarManufacturer carManufacturer, int batteryCapacity,boolean isAutoPilotEnabled, boolean isFullSelfDrivingEnabled, boolean isTeslaTheatreEnabled) {
        super(id, carModelName, chargingStation, carManufacturer, batteryCapacity);
        this.isAutoPilotEnabled = isAutoPilotEnabled;
        this.isFullSelfDrivingEnabled = isFullSelfDrivingEnabled;

        this.isTeslaTheatreEnabled = isTeslaTheatreEnabled;
    }

    public boolean isAutoPilotEnabled() {
        return isAutoPilotEnabled;
    }

    public boolean isFullSelfDrivingEnabled() {
        return isFullSelfDrivingEnabled;
    }

    public boolean isTeslaTheatreEnabled() {
        return isTeslaTheatreEnabled;
    }

    public void setAutoPilotEnabled(boolean autoPilotEnabled) {
        isAutoPilotEnabled = autoPilotEnabled;
    }

    public void setFullSelfDrivingEnabled(boolean fullSelfDrivingEnabled) {
        isFullSelfDrivingEnabled = fullSelfDrivingEnabled;
    }

    public void setTeslaTheatreEnabled(boolean teslaTheatreEnabled) {
        isTeslaTheatreEnabled = teslaTheatreEnabled;
    }

    @Override
    public String toString() {
        String info="";
        return info+="ID: "+getId()+", "+"Model name: "+getCarModelName()+", "+getChargingStation().toString()+", "+getCarManufacturer().toString()+", "+getBatteryCapacity()+" kWh"+", "+"Auto Pilot Enabled: "+(isAutoPilotEnabled()?"Yes":"No")+", "+"Full Self Driving Enabled: "+(isFullSelfDrivingEnabled()?"Yes":"No")+", "+"Tesla Theatre Enabled: "+(isTeslaTheatreEnabled()?"Yes":"No");
    }
}
