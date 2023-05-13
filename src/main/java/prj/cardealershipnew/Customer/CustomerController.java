package prj.cardealershipnew.Customer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import prj.cardealershipnew.Vehicles.Car;
import prj.cardealershipnew.Vehicles.SoldCars;
import prj.cardealershipnew.projectUtils.InputDialog;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

public class CustomerController implements Initializable {

    private double x = 0;
    private double y = 0;

    @FXML
    private  Label addressLb = new Label();

    @FXML
    private  VBox carsListVB ;

    @FXML
    private  Label custDOB = new Label();

    @FXML
    private   PasswordField custLice = new PasswordField();

    @FXML
    private  Label custName = new Label();

    @FXML
    private  Label customNumber  = new Label();

    @FXML
    private  Label phoneNumber  = new Label();

    private static HashMap<String,CustomerInfo> customerInfoHashMap = new HashMap<>();

    private static String getCustNumber = "";


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        CustomerInfo c = customerInfoHashMap.get(getCustNumber);

        setTexts( c.getCustomerID(),c.getCustomerName(),String.valueOf(c.getLicenseNumber()),String.valueOf(c.getPhoneNumber())
                ,c.getAddress(),c.getCustomerDOB());

        insertCarsBlock ();
    }


    public static HashMap<String, CustomerInfo> getCustomerInfoHashMap() {
        return customerInfoHashMap;
    }


    public static void setGetCustNumber(String getCustNumber) {
        CustomerController.getCustNumber = getCustNumber;
    }

    @FXML
    void exitButtonClicked(ActionEvent event) {

        CustomerDetailsController.custStage.close();
        CustomerDetailsController.custStage = null ;

    }

    private void insertCarsBlock () {

        ArrayList<Car> c = SoldCars.getCustomersCarsLists().get(customNumber.getText());

        for (int i =0 ; i < c.size() ; i++ ){

            Label t1 = new Label(c.get(i).getCarName());
            t1.setPrefWidth(141);
            t1.setPrefHeight(36);

            t1.setMinWidth(141);
            t1.setMinHeight(36);

            t1.setMaxWidth(141);
            t1.setMaxHeight(36);

            t1.setFont(Font.font("System", FontWeight.BOLD,25));

            Label t2 = new Label("$"+c.get(i).getCarPrice());
            t2.setFont(Font.font("System", FontWeight.BOLD,18));
            t2.setPrefWidth(122);
            t2.setPrefHeight(27);

            t2.setMinWidth(122);
            t2.setMinHeight(27);

            t2.setMaxWidth(122);
            t2.setMaxHeight(27);


            HBox hb = new HBox();
            hb.setStyle(" -fx-background-radius: 10px;" +
                        " -fx-border-radius: 10px;" +
                        " -fx-background-color : #f7f7f7;");

            hb.setAlignment(Pos.CENTER_LEFT);
            hb.setSpacing(10);
            hb.setPadding(new Insets(0,15,5,10));

            hb.setPrefWidth(296);
            hb.setMinWidth(296);
            hb.setMaxWidth(296);

            hb.prefHeight(53);
            hb.setMaxHeight(53);
            hb.setMinHeight(53);



            hb.getChildren().addAll(t1,t2);
            carsListVB.getChildren().add(hb);

        }

    }

    @FXML
    void editCustomerInfo(ActionEvent event) {


        CustomerInfo cs = customerInfoHashMap.get(customNumber.getText());

        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();

        new InputDialog(5,new String[]{"Customer Name :","Customer Licence: ","Phone Number : ","Address:","Date Of Birth : "},
                new String[]{cs.getCustomerName(),String.valueOf(cs.getLicenseNumber()),String.valueOf(cs.getPhoneNumber()),cs.getAddress(),
                        cs.getCustomerDOB()},'C',customNumber.getText());

        CustomerInfo csUpdate = customerInfoHashMap.get(customNumber.getText());
        setTexts( csUpdate.getCustomerID(),csUpdate.getCustomerName(),String.valueOf(csUpdate.getLicenseNumber()),String.valueOf(csUpdate.getPhoneNumber())
                ,csUpdate.getAddress(),csUpdate.getCustomerDOB());


    }

    private void setTexts (String getCustomerID, String getCustomerName, String getLicenseNumber, String getPhoneNumber, String getAddress, String getCustomerDOB ) {

        customNumber.setText(getCustomerID);
        custName.setText(getCustomerName);
        custLice.setText(String.valueOf(getLicenseNumber));
        phoneNumber.setText(String.valueOf(getPhoneNumber));
        addressLb.setText(getAddress);
        custDOB.setText(getCustomerDOB);

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
