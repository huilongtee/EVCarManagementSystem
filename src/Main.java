import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<CarManufacturer> carManufacturerList = new ArrayList<>();
        ArrayList<ChargingStation> chargingStationList = new ArrayList<>();
        CarManufacturer carManufacturerTesla = new CarManufacturer("manufacturerTesla", "Tesla");
        ChargingStation chargingStation01 = new ChargingStation("station001", "JB", 2000);
        ChargingStation chargingStation02 = new ChargingStation("station002", "KL", 1500);

        ElectricCar ModelS = new Tesla("C001", "ModelS", chargingStation01, carManufacturerTesla, 100, false, true, false);
        ElectricCar ModelE = new Tesla("C002", "ModelE", chargingStation01, carManufacturerTesla, 120, true, true, true);
        ElectricCar ModelX = new Tesla("C003", "ModelX", chargingStation01, carManufacturerTesla, 130, false, true, true);
        ElectricCar ModelY = new Tesla("C004", "ModelY", chargingStation01, carManufacturerTesla, 140, true, false, true);

        carManufacturerTesla.setCarModels(ModelS);
        carManufacturerTesla.setCarModels(ModelE);
        carManufacturerTesla.setCarModels(ModelX);
        carManufacturerTesla.setCarModels(ModelY);

        CarManufacturer carManufacturerOra = new CarManufacturer("manufacturerOra", "Ora");

        ElectricCar Ora001 = new Ora("C005", "Ora001", chargingStation01, carManufacturerOra, 80, false, true);
        ElectricCar Ora002 = new Ora("C006", "Ora002", chargingStation01, carManufacturerOra, 70, true, false);

        carManufacturerList.add(carManufacturerTesla);
        carManufacturerList.add(carManufacturerOra);
        carManufacturerOra.setCarModels(Ora001);
        carManufacturerOra.setCarModels(Ora002);

        ArrayList<Customer> customerList = new ArrayList<>();

        chargingStationList.add(chargingStation01);
        chargingStationList.add(chargingStation02);
        while (true) {
            System.out.println("(1) Display a list of electric car manufacturers and their car models");
            System.out.println("(2) Purchase electric cars");
            System.out.println("(3) view and update the charging station");
            System.out.println("(4) Display the list of owned electric cars");
            System.out.println("(5) Exit the program");

            Scanner keyboard = new Scanner(System.in);
            System.out.print("Please select an action: ");
            int action = keyboard.nextInt();

            keyboard.nextLine();

            switch (action) {
                case 1:
                    showCars(carManufacturerList);
                    break;
                case 2:
                    askPurchaseCarQuestion(carManufacturerList, customerList, keyboard);
                    break;
                case 3:
                    askChargingStationQuestion(carManufacturerList, customerList,chargingStationList, keyboard);
                    break;
                case 4:
                    askCustomerIDTOGetOwnedCarList(customerList, keyboard);
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid action");
            }
        }
    }

    public static void showCars(ArrayList<CarManufacturer> carManufacturerList) {
        System.out.println("\n" + "Car Models");
        System.out.println("==================");
        for (CarManufacturer manufacturer : carManufacturerList) {
            for (Object car : manufacturer.getCarModels()) {
                System.out.println(car.toString());
            }
        }
    }

    public static void askPurchaseCarQuestion(ArrayList<CarManufacturer> carManufacturerList, ArrayList<Customer> customerList, Scanner keyboard) {
        showCars(carManufacturerList);

        System.out.print("Please enter your ID: ");
        String id = keyboard.nextLine();

        System.out.print("Please enter your name: ");
        String name = keyboard.nextLine();

        System.out.print("Enter the id of the car model you want to purchase: ");
        String carID = keyboard.nextLine();
        Object selectedCar = new ElectricCar();
        for (CarManufacturer manufacturer : carManufacturerList) {
            for (Object car : manufacturer.getCarModels()) {
                if (car instanceof Tesla) {
                    if (((Tesla) car).getId().equals(carID)) {
                        selectedCar = car;
                    }
                }
            }
        }

        Customer customer = new Customer(id, name);
        customer.setCarOwnedList((ElectricCar) selectedCar);
        customerList.add(customer);

    }

    public static void askChargingStationQuestion(ArrayList<CarManufacturer> carManufacturerList, ArrayList<Customer> customerList, ArrayList<ChargingStation> chargingStationList,Scanner keyboard) {
        System.out.println("(1)View charging station");
        System.out.println("(2)Update charging station");
        int action = keyboard.nextInt();

        keyboard.nextLine();

        System.out.println("Please enter your customer id: ");
        String customerID = keyboard.nextLine();
        Customer customer = getCustomer(customerID, customerList);
        String carID = askUpdateChargingStationQuestion(customer);


        switch (action) {
            case 1:
                for (CarManufacturer manufacturer : carManufacturerList) {
                    for (Object car : manufacturer.getCarModels()) {
                        if (car instanceof Tesla) {
                            if (((Tesla) car).getId().equals(carID)) {
                                System.out.println(((Tesla) car).getChargingStation().toString());
                            }
                        } else if (((Ora) car).getId().equals(carID)) {
                            System.out.println(((Ora) car).getChargingStation().toString());
                        }
                    }
                }
                break;
            case 2:
                System.out.println("Please enter the station id: ");
                String stationID = keyboard.nextLine();
                ChargingStation newChargingStation=null;
                for(ChargingStation chargingStation : chargingStationList) {
                    if(chargingStation.getId().equals(stationID)) {
                        newChargingStation = chargingStation;
                    }
                }

                for (CarManufacturer manufacturer : carManufacturerList) {
                    for (Object car : manufacturer.getCarModels()) {
                        if (car instanceof Tesla) {
                            if (((Tesla) car).getId().equals(carID)) {
                                ((Tesla) car).setChargingStation(newChargingStation);
                            }
                        } else if (((Ora) car).getId().equals(carID)) {
                            ((Ora) car).setChargingStation(newChargingStation);

                        }
                    }
                }
                break;
        }
    }

    public static Customer getCustomer(String id, ArrayList<Customer> customerList) {
        Customer currentCustomer = new Customer();
        for (Customer customer : customerList) {
            if (customer.getId().equals(id))
                currentCustomer = customer;
        }
        return currentCustomer;
    }

    public static String askUpdateChargingStationQuestion(Customer customer) {
        ArrayList<ElectricCar> carList = getOwnedCarList(customer);
        for (ElectricCar car : carList) {
            System.out.println(car.toString());
        }
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Please enter your car ID: ");
        String id = keyboard.nextLine();
        return id;
    }

    public static ArrayList<ElectricCar> getOwnedCarList(Customer customer) {
        ArrayList<ElectricCar> carList = new ArrayList<>();
        for (ElectricCar car : customer.getCarOwnedList()) {
            carList.add(car);
        }
        return carList;
    }

    public static void askCustomerIDTOGetOwnedCarList(ArrayList<Customer> customerList, Scanner keyboard) {
        System.out.println("Please enter your customer id: ");
        String customerID = keyboard.nextLine();
        Customer customer = getCustomer(customerID, customerList);
        ArrayList<ElectricCar> carList = getOwnedCarList(customer);
        for (ElectricCar car : carList) {
            System.out.println(car.toString());
        }
    }
}
