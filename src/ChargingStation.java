public class ChargingStation {

    private String id;
    private String location;
    private int availableChargingCapacity;
    protected ChargingStation(){
        this("","",-1);
    }
    protected ChargingStation(String id, String location, int availableChargingCapacity){
        this.id=id;
        this.location=location;
        this.availableChargingCapacity=availableChargingCapacity;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAvailableChargingCapacity(int availableChargingCapacity) {
        this.availableChargingCapacity = availableChargingCapacity;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public int getAvailableChargingCapacity() {
        return availableChargingCapacity;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        String info="";
        info+="Station ID: "+getId()+", "+"Location: "+getLocation()+", "+"Available Charging Capacity: "+getAvailableChargingCapacity()+" kWh";
        return info;
    }
}
