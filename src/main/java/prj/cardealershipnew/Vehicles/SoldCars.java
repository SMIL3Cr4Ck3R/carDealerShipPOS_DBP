package prj.cardealershipnew.Vehicles;

import java.util.ArrayList;
import java.util.HashMap;

public class SoldCars {


    private static HashMap<String, ArrayList<Car>> customersCarsLists = new HashMap<>();

    public static HashMap<String, ArrayList<Car>> getCustomersCarsLists() {
        return customersCarsLists;
    }

    public static void setCustomersCarsLists(HashMap<String, ArrayList<Car>> customersCarsLists) {
        SoldCars.customersCarsLists = customersCarsLists;
    }

}
