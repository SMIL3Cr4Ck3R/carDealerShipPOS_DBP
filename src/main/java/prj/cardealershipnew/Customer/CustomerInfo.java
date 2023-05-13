package prj.cardealershipnew.Customer;

import prj.cardealershipnew.Vehicles.Car;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerInfo {


    private String customerID ;
    private String customerName;
    private int licenseNumber ;
    private int phoneNumber ;
    private String customerDOB ;
    private String address ;
    ArrayList<Car> customerCarsList = new ArrayList<>();


    public CustomerInfo(String customerID, String customerName, int licenseNumber, int phoneNumber, String customerDOB, String address) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.licenseNumber = licenseNumber;
        this.phoneNumber = phoneNumber;
        this.customerDOB = customerDOB;
        this.address = address;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(int licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCustomerDOB() {
        return customerDOB;
    }

    public void setCustomerDOB(String customerDOB) {
        this.customerDOB = customerDOB;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Car> getCustomerCarsList() {
        return customerCarsList;
    }

    public void setCustomerCarsList(ArrayList<Car> customerCarsList) {
        this.customerCarsList = customerCarsList;
    }

    @Override
    public String toString() {
        return "CustomerInfo{" +
                "customerID='" + customerID + '\'' +
                ", customerName='" + customerName + '\'' +
                ", licenseNumber=" + licenseNumber +
                ", phoneNumber=" + phoneNumber +
                ", customerDOB='" + customerDOB + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
