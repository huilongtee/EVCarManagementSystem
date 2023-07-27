import java.util.ArrayList;

public class ElectricCar {
    private String id;
    private String carModelName;
    private ChargingStation chargingStation;
    private CarManufacturer carManufacturer;
    private int batteryCapacity;

    protected ElectricCar() {
        this("C001", "Tesla", null, null, 100);
    }

    protected ElectricCar(String id, String carModelName, ChargingStation chargingStation, CarManufacturer carManufacturer, int batteryCapacity) {
        this.id = id;
        this.carModelName = carModelName;
        this.chargingStation = chargingStation;
        this.carManufacturer = carManufacturer;
        this.batteryCapacity = batteryCapacity;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public void setCarManufacturer(CarManufacturer carManufacturer) {
        this.carManufacturer = carManufacturer;
    }

    public void setCarModelName(String carModelName) {
        this.carModelName = carModelName;
    }

    public void setChargingStation(ChargingStation chargingStation) {
        this.chargingStation = chargingStation;
    }

    public CarManufacturer getCarManufacturer() {
        return carManufacturer;
    }

    public ChargingStation getChargingStation() {
        return chargingStation;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public String getCarModelName() {
        return carModelName;
    }

    public String getId() {
        return id;
    }

}
