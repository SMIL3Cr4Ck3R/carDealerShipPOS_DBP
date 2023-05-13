package prj.cardealershipnew.Invoices;

import prj.cardealershipnew.projectUtils.Xeger;

public class Invoice {

    private String InvoiceID ;
    private String CustomerID ;
    private String customerName;
    private String employeeName;
    private String carName;
    private double price ;
    private final double tax = 16 ;
    private String date ;

    private double totalPrice ;

    public Invoice(String invoiceID, String customerID, String customerName, String employeeName, String carName, double price, String date) {
        InvoiceID = invoiceID;
        CustomerID = customerID;
        this.customerName = customerName;
        this.employeeName = employeeName;
        this.carName = carName;
        this.price = price;
        this.date = date;
        this.totalPrice = this.price * 1.16;
    }



    public String getInvoiceID() {
        return InvoiceID;
    }

    public void setInvoiceID(String invoiceID) {
        InvoiceID = invoiceID;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String customerID) {
        CustomerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTotalPrice (double initPrice ) {

            return  "" + this.totalPrice;



    }


    @Override
    public String toString() {
        return "Invoice{" +
                "InvoiceID='" + InvoiceID + '\'' +
                ", CustomerID='" + CustomerID + '\'' +
                ", customerName='" + customerName + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", carName='" + carName + '\'' +
                ", price=" + price +
                ", tax=" + tax +
                ", date='" + date + '\'' +
                ", totalPrice=" + totalPrice +
                '}';
    }

}
