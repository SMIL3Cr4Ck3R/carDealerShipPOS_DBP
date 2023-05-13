package prj.cardealershipnew.Vehicles;

import javafx.scene.image.Image;

public class Car {


    private String carName;
    private double carPrice ;
    private int releaseYear;
    private String milesDriven ;
    private String carColor ;
    private String manufacturer;
    private String manufacturePlace;
    private Image carImage ;
    private String vinNumber ;
    private String gearType ;
    private int engineCC ;
    private float horsePower ;
    private String fuelType ;
    private Image carLogo ;


    public Car(String carName, double carPrice, int releaseYear, String milesDriven, String carColor, String manufacturer,
               String manufacturePlace, Image carImage, String vinNumber, String gearType, int engineCC, float horsePower,
               String fuelType, Image carLogo) {
        this.carName = carName;
        this.carPrice = carPrice;
        this.releaseYear = releaseYear;
        this.milesDriven = milesDriven;
        this.carColor = carColor;
        this.manufacturer = manufacturer;
        this.manufacturePlace = manufacturePlace;
        this.carImage = carImage;
        this.vinNumber = vinNumber;
        this.gearType = gearType;
        this.engineCC = engineCC;
        this.horsePower = horsePower;
        this.fuelType = fuelType;
        this.carLogo = carLogo;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public double getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(double carPrice) {
        this.carPrice = carPrice;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getMilesDriven() {
        return milesDriven;
    }

    public void setMilesDriven(String milesDriven) {
        this.milesDriven = milesDriven;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getManufacturePlace() {
        return manufacturePlace;
    }

    public void setManufacturePlace(String manufacturePlace) {
        this.manufacturePlace = manufacturePlace;
    }

    public Image getCarImage() {
        return carImage;
    }

    public void setCarImage(Image carImage) {
        this.carImage = carImage;
    }

    public String getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }

    public String getGearType() {
        return gearType;
    }

    public void setGearType(String gearType) {
        this.gearType = gearType;
    }

    public int getEngineCC() {
        return engineCC;
    }

    public void setEngineCC(int engineCC) {
        this.engineCC = engineCC;
    }

    public float getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(float horsePower) {
        this.horsePower = horsePower;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public Image getCarLogo() {
        return carLogo;
    }

    public void setCarLogo(Image carLogo) {
        this.carLogo = carLogo;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carName='" + carName + '\'' +
                ", carPrice=" + carPrice +
                ", releaseYear=" + releaseYear +
                ", milesDriven='" + milesDriven + '\'' +
                ", carColor='" + carColor + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", manufacturePlace='" + manufacturePlace + '\'' +
                ", carImage=" + carImage +
                ", vinNumber='" + vinNumber + '\'' +
                ", gearType='" + gearType + '\'' +
                ", engineCC=" + engineCC +
                ", horsePower=" + horsePower +
                ", fuelType='" + fuelType + '\'' +
                ", carLogo=" + carLogo +
                '}';
    }
}
