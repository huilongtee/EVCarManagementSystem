import java.util.ArrayList;

public class Customer {

    private String id;
    private String name;
    private ArrayList<ElectricCar> carOwnedList;

    protected Customer() {
        this("","");
    }

    protected Customer(String id, String name) {
        this.id = id;
        this.name = name;
        this.carOwnedList = new ArrayList();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCarOwnedList(ElectricCar car) {
        this.carOwnedList.add(car);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<ElectricCar> getCarOwnedList() {
        return carOwnedList;
    }


}
