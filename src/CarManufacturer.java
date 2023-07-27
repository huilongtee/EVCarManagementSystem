import java.util.ArrayList;

public class CarManufacturer {

    private String id;
    private String name;
    private ArrayList<ElectricCar> carModels;

    public CarManufacturer() {
        this("","");
    }

    protected CarManufacturer(String id, String name) {
        this.id = id;
        this.name = name;
        this.carModels = new ArrayList();
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCarModels(ElectricCar carModels) {
        this.carModels.add(carModels);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList getCarModels() {
        return carModels;
    }

    @Override
    public String toString() {
        String info="";
        info+="Manufacturer ID: "+getId()+", "+"Manufacturer name: "+getName();
        return info;
    }

    public ElectricCar getElectricCar(String id) {
        for (ElectricCar electricCar : carModels) {
            if (electricCar.getId().equals(id)) {
                return electricCar;
            }
        }
        return null;
    }
}
