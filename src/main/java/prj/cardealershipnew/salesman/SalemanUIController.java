package prj.cardealershipnew.salesman;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class SalemanUIController implements Initializable {

    @FXML
    private BorderPane centerBorderPane;

    @FXML
    private Label empIDLoggedIn;


    private double x = 0;
    private double y = 0;

    private ButtonsScene.Dashboard dashboardScene ;
    private ButtonsScene.CarsAndVehicles carScene ;
    private ButtonsScene.VehiclesInvoices invoiceScene;

    private ButtonsScene.Customers customerScene ;

    private static HashMap<String,Salesman> salesmanMap = new HashMap<>();

    private static String currentLoggedInSM ;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        empIDLoggedIn.setText(currentLoggedInSM);

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

    @FXML
    void closeButtonClicked(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"yesAndNo", ButtonType.YES,ButtonType.NO);


        alert.setTitle("Confirm Exit");
        alert.setHeaderText("Confirm Exit");
        alert.setContentText("Are you sure you want to leave ?");

        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.YES) {
                SalemanUI.getSalemanStage().close();
            }
        });
    }


    @FXML
    void dashboardButtonAction(ActionEvent event) {


            if (dashboardScene == null ){
                dashboardScene = new ButtonsScene.Dashboard();
                centerBorderPane.setCenter(dashboardScene.getScroll());
            } else
                centerBorderPane.setCenter(dashboardScene.getScroll());


    }

    @FXML
    void invoicesButtonAction(ActionEvent event) {

        if (invoiceScene == null ) {
            invoiceScene = new ButtonsScene.VehiclesInvoices();
            centerBorderPane.setCenter(invoiceScene.getScroll());
        } else
            centerBorderPane.setCenter(invoiceScene.getScroll());

    }

    @FXML
    void carButtonAction(ActionEvent event) {

        if (carScene == null ) {
            carScene = new ButtonsScene.CarsAndVehicles();
            centerBorderPane.setCenter(carScene.getScroll());
        } else
            centerBorderPane.setCenter(carScene.getScroll());

    }


    @FXML
    void customersButtonAction(ActionEvent event) {

        if (customerScene == null ) {
            customerScene = new ButtonsScene.Customers();
            centerBorderPane.setCenter(customerScene.getScroll());
        } else
            centerBorderPane.setCenter(customerScene.getScroll());


    }


    @FXML
    void aboutButtonAction(ActionEvent event) throws IOException {

         new ButtonsScene.AboutUs();

    }


    public static Salesman getPrimarySalesman() {
        return salesmanMap.get("EMP001");
    }

    public static HashMap<String, Salesman> getSalesmanMap() {
        return salesmanMap;
    }

    public static String getCurrentLoggedInSM() {
        return currentLoggedInSM;
    }

    public static void setCurrentLoggedInSM(String currentLoggedInSM) {
        SalemanUIController.currentLoggedInSM = currentLoggedInSM;
    }


    @FXML
    void empIDLabelClicked(MouseEvent event) {

        FXMLLoader fxmlLoader = new FXMLLoader(SalemanUIController.class.getResource("/salesmanUIResources/fxmls/employeeDialog.fxml"));
        try {

            Scene sc= new Scene(fxmlLoader.load(),381,552,Color.TRANSPARENT);
            Stage stage = new Stage();
            stage.setScene(sc);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
