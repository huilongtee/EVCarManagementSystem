public class Ora extends ElectricCar {

    private boolean hasPanaromicSunroof;
    private boolean hasWirelessCharging;

    protected Ora() {
        this("", "", null, null, -1, false, false);
    }

    protected Ora(boolean hasPanaromicSunroof, boolean hasWirelessCharging) {
        this.hasPanaromicSunroof = hasPanaromicSunroof;
        this.hasWirelessCharging = hasWirelessCharging;
    }

    protected Ora(String id, String carModelName, ChargingStation chargingStation, CarManufacturer carManufacturer, int batteryCapacity, boolean hasPanaromicSunroof, boolean hasWirelessCharging) {
        super(id, carModelName, chargingStation, carManufacturer, batteryCapacity);
        this.hasPanaromicSunroof = hasPanaromicSunroof;
        this.hasWirelessCharging = hasWirelessCharging;
    }

    public void setHasPanaromicSunroof(boolean hasPanaromicSunroof) {
        this.hasPanaromicSunroof = hasPanaromicSunroof;
    }

    public void setHasWirelessCharging(boolean hasWirelessCharging) {
        this.hasWirelessCharging = hasWirelessCharging;
    }

    public boolean isHasPanaromicSunroof() {
        return hasPanaromicSunroof;
    }

    public boolean isHasWirelessCharging() {
        return hasWirelessCharging;
    }

    @Override
    public String toString() {
        String info = "";
        return info += "ID: " + getId() + ", " + "Model name: " + getCarModelName() + ", " + getChargingStation().toString() + ", "+getCarManufacturer().toString() + ", " + "Battery capacity: "+getBatteryCapacity() +" kWh"+ ", " + "Panaromic Sunroof: "+(isHasPanaromicSunroof()?"Yes":"No") + ", " + "Wireless Charging: "+ (isHasWirelessCharging()?"Yes":"No");
    }
}
