package prj.cardealershipnew.Invoices;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import prj.cardealershipnew.Customer.CustomerDetailsController;
import prj.cardealershipnew.Invoices.Invoice;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.ResourceBundle;

public class InvoiceDialogController implements Initializable {

    private double x = 0;
    private double y = 0;


    @FXML
    private Label actionTook = new Label();

    @FXML
    private Label carModel   = new Label();

    @FXML
    private Label carPrice  = new Label();

    @FXML
    private Label custID   = new Label();
    @FXML
    private Label custName  = new Label();

    @FXML
    private Label dateOfAction  = new Label();

    @FXML
    private Label empName  = new Label();

    @FXML
    private Label invoiceNumber  = new Label();

    @FXML
    private Label totalPrice  = new Label();

    private static HashMap<String, Invoice> invoicesHashMap = new HashMap<>();

    private static String customerNumber = " ";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        System.out.println("" + customerNumber);
       Invoice inv =  invoicesHashMap.get(customerNumber);

        this. carModel.setText(inv.getCarName()) ;
        this. carPrice.setText("$ "+inv.getPrice()) ;
        this. custID.setText(inv.getCustomerID());
        this. custName.setText(inv.getCustomerName()) ;
        this. dateOfAction.setText(inv.getDate());
        this. empName.setText(inv.getEmployeeName());
        this. invoiceNumber.setText(inv.getInvoiceID());
        this. totalPrice.setText("$ "+ new DecimalFormat("#.##").format(calculateTotalPrice(inv.getPrice())));


    }

    @FXML
    void printInvoiceButtonAction(ActionEvent event) {

    }

    private double calculateTotalPrice(double initPrice){

        return initPrice * 1.16 ;

    }

    public static HashMap<String, Invoice> getInvoicesHashMap() {
        return invoicesHashMap;
    }

    public static String getCustomerNumber() {
        return customerNumber;
    }

    public static void setCustomerNumber(String customerNumber) {
        InvoiceDialogController.customerNumber = customerNumber;
    }


    @FXML
    void exitButtonClicked(ActionEvent event) {

        CustomerDetailsController.invStage.close();
        CustomerDetailsController.invStage = null ;

    }

    @FXML
    void draggedScene(MouseEvent event) {

        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();

        stage.setX(event.getScreenX() - x);
        stage.setY(event.getScreenY() - y);

    }

    @FXML
    void pressedOnScene(MouseEvent event) {

        x = event.getSceneX();
        y = event.getSceneY();
    }

}

