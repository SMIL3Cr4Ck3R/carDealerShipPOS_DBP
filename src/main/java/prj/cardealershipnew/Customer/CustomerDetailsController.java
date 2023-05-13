package prj.cardealershipnew.Customer;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import prj.cardealershipnew.Invoices.Invoice;
import prj.cardealershipnew.Invoices.InvoiceDialogController;
import prj.cardealershipnew.Vehicles.Car;
import prj.cardealershipnew.projectUtils.AlertBox;
import prj.cardealershipnew.Vehicles.CarDetailss;
import prj.cardealershipnew.Vehicles.SoldCars;
import prj.cardealershipnew.projectUtils.Xeger;
import prj.cardealershipnew.salesman.ButtonsScene;
import prj.cardealershipnew.Vehicles.VehiclesSceneController;
import prj.cardealershipnew.salesman.SalemanUIController;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class CustomerDetailsController {
    private double x = 0;
    private double y = 0;
    @FXML
    private TextField BODTF =new TextField();

    @FXML
    private TextField custLicTF=new TextField();

    @FXML
    private TextField custNameTF=new TextField();

    @FXML
    private TextField custadrr=new TextField();

    @FXML
    private TextField idGen=new TextField();

    @FXML
    private TextField phoneTF=new TextField();

    private AlertBox altB = new AlertBox();
    static Stage custStage ;
    public static Stage invStage ;

    private FXMLLoader fxmlloader ;

    @FXML
    void exitButtonClicked(ActionEvent event) {
        CarDetailss.getStage().close();
        CarDetailss.setStage(null);
    }

    @FXML
    void generateID(ActionEvent event) {


            String vinGen = "CUST[0-9]{8}";
            Xeger vinGenByRegex = new Xeger(vinGen);
            idGen.setText(vinGenByRegex.generate());


    }

    @FXML
    void insertCustomerBA(ActionEvent event) {

        if (!custLicTF.getText().equals("") && !custNameTF.getText().equals("") && !custLicTF.getText().equals("") && !phoneTF.getText().equals("") && !BODTF.getText().equals("")) {

            if (custLicTF.getText().matches("\\d{9}") && phoneTF.getText().matches("\\d{10}") && BODTF.getText().matches("^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$")) {


                CustomerController.getCustomerInfoHashMap().put(idGen.getText(), new CustomerInfo(idGen.getText(), custNameTF.getText(), Integer.parseInt(custLicTF.getText()), Integer.parseInt(phoneTF.getText()), BODTF.getText(), custadrr.getText()));
                CustomerInfo c = CustomerController.getCustomerInfoHashMap().get(idGen.getText());

                // list of the current customer cars
                SoldCars.getCustomersCarsLists().put(idGen.getText(), new ArrayList<>());
                Car currentCar = VehiclesSceneController.getCarsList().get(CarDetailss.getCloneCarID());
                SoldCars.getCustomersCarsLists().get(idGen.getText()).add(currentCar);


                String invoiceID = genarateInvoiceID();

                InvoiceDialogController.getInvoicesHashMap().put(idGen.getText(), new Invoice(invoiceID, c.getCustomerID(),
                        c.getCustomerName(), SalemanUIController.getPrimarySalesman().getEmpName(), currentCar.getCarName(), currentCar.getCarPrice(),""+ DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDateTime.now())));

                Invoice inv = InvoiceDialogController.getInvoicesHashMap().get(idGen.getText());
                System.out.println(inv.toString());

                ButtonsScene.Customers.getTiles().getChildren().add(createCarBlock(custNameTF.getText(),custadrr.getText(),idGen.getText()));
                ButtonsScene.VehiclesInvoices.getTiles().getChildren().add(createInvoiceBlock(inv.getDate(),"Sold",inv.getInvoiceID()));


                altB.displayPopUp("Customer Has Been Added","Success",3);

                CarDetailss.getStage().close();
                CarDetailss.setStage(null);


            }else
                altB.displayPopUp("Please Check input format","Warning !",2);


        }else
            altB.displayPopUp("Please Fill all blanks !","Warning !",2);


    }

    private String genarateInvoiceID ( ) {

        String vinGen = "INV[0-9]{9}";
        Xeger vinGenByRegex = new Xeger(vinGen);
        return vinGenByRegex.generate();

    }

    private VBox createCarBlock(String customerName, String address, String CustomerID) {

        ImageView deleteCustomerImage = new ImageView(new Image("F:\\university\\Season 3 Chap 1\\COMP333-DATABASE\\Project\\CarDealershipDataBaseProject\\carDealerShipNew\\src\\main\\resources\\salesmanUIResources\\images\\Delete_25px.png"));

        VBox.setMargin(deleteCustomerImage,new Insets(0,0,0,180));

        VBox custBlock = new VBox();
        ImageView imageView = new ImageView(new Image("F:\\university\\Season 3 Chap 1\\COMP333-DATABASE\\Project\\CarDealershipDataBaseProject\\carDealerShipNew\\src\\main\\resources\\salesmanUIResources\\images\\customer_127px.png"));
        imageView.setFitWidth(200);
        imageView.setFitHeight(150);

        Text name = new Text(customerName);
        name.setFont(new Font("Barlow Condensed Black", 40));
        //name.setAlignment(Pos.CENTER);

        Label ID = new Label(CustomerID);

        Label custAddr = new Label(address);

        // ID.setFont(new Font(15));
        ID.setStyle("-fx-font-weight: bold");

        HBox addressBox = new HBox();

        ImageView addrImg = new ImageView(new Image("F:\\university\\Season 3 Chap 1\\COMP333-DATABASE\\Project\\CarDealershipDataBaseProject\\carDealerShipNew\\src\\main\\resources\\salesmanUIResources\\images\\address_30px.png"));


        stylingVB(custBlock, custAddr, addressBox, addrImg);



        name.setOnMouseClicked(mouseEvent -> {

            try {

                if ( custStage == null  ) {

                    custStage = new Stage();
                    fxmlloader = new FXMLLoader(CustomerDetailsController.class.getResource("/salesmanUIResources/fxmls/CustomerDialog.fxml"));
                    CustomerController.setGetCustNumber(idGen.getText());

                    Scene sc = new Scene(fxmlloader.load(), 381, 769, Color.TRANSPARENT);
                    custStage.setScene(sc);
                    custStage.initStyle(StageStyle.TRANSPARENT);
                    custStage.initModality(Modality.APPLICATION_MODAL);
                    custStage.show();

                }else {
                    CustomerController.setGetCustNumber(idGen.getText());
                    custStage.show();

                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }



        });


        imageView.setOnMouseClicked(mouseEvent -> {

            try {

                if ( custStage == null  ) {

                    custStage = new Stage();
                    fxmlloader = new FXMLLoader(CustomerDetailsController.class.getResource("/salesmanUIResources/fxmls/CustomerDialog.fxml"));
                    CustomerController.setGetCustNumber(idGen.getText());

                    Scene sc = new Scene(fxmlloader.load(), 381, 769, Color.TRANSPARENT);
                    custStage.setScene(sc);
                    custStage.initStyle(StageStyle.TRANSPARENT);
                    custStage.initModality(Modality.APPLICATION_MODAL);
                    custStage.show();

                }else {
                    CustomerController.setGetCustNumber(idGen.getText());
                    custStage.show();

                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }



        });

        deleteCustomerImage.setOnMouseClicked( e -> {


            Alert alert = new Alert(Alert.AlertType.WARNING,"delete", ButtonType.YES,ButtonType.NO);
            alert.setTitle("Car Deletion");
            alert.setHeaderText("Warning! Customer Will be Deleted permanently ");
            alert.setContentText("Are you sure you want to remove Customer ?");

            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.YES) {

                    ButtonsScene.Customers.getTiles().getChildren().remove(custBlock);
                    CustomerController.getCustomerInfoHashMap().remove(idGen.getText());

                }
            });

        });



        custAddr.setFont(new Font("Barlow Condensed", 23));
        //name.setAlignment(Pos.CENTER);

        custBlock.getChildren().addAll(ID,imageView, name, addressBox,deleteCustomerImage);

        return custBlock;
    }

    public VBox createInvoiceBlock(String date, String action, String invoiceID) {

        VBox invBlock = new VBox();
        ImageView imageView = new ImageView(new Image("F:\\university\\Season 3 Chap 1\\COMP333-DATABASE\\Project\\CarDealershipDataBaseProject\\carDealerShipNew\\src\\main\\resources\\salesmanUIResources\\images\\invoice_127px.png"));
        imageView.setFitWidth(200);
        imageView.setFitHeight(150);

        Text name = new Text(action);
        name.setFont(new Font("Barlow Condensed Black", 40));
        //name.setAlignment(Pos.CENTER);

        Label ID = new Label(invoiceID);

        Label custAddr = new Label(date);

        // ID.setFont(new Font(15));
        ID.setStyle("-fx-font-weight: bold");

        HBox addressBox = new HBox();

        ImageView addrImg = new ImageView(new Image("F:\\university\\Season 3 Chap 1\\COMP333-DATABASE\\Project\\CarDealershipDataBaseProject\\carDealerShipNew\\src\\main\\resources\\salesmanUIResources\\images\\ok_30px.png"));

        stylingVB(invBlock, custAddr, addressBox, addrImg);


        invBlock.setOnMouseClicked(mouseEvent -> {


            try {

                if ( invStage == null  ) {

                    invStage = new Stage();
                    fxmlloader = new FXMLLoader(CustomerDetailsController.class.getResource("/salesmanUIResources/fxmls/invoiceDialog.fxml"));
                    InvoiceDialogController.setCustomerNumber(idGen.getText());

                    Scene sc = new Scene(fxmlloader.load(), 381, 664, Color.TRANSPARENT);
                    invStage.setScene(sc);
                    invStage.initStyle(StageStyle.TRANSPARENT);
                    invStage.initModality(Modality.APPLICATION_MODAL);
                    invStage.show();

                }else {
                    InvoiceDialogController.setCustomerNumber(idGen.getText());
                    invStage.show();

                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        });

        custAddr.setFont(new Font("Barlow Condensed", 23));
        //name.setAlignment(Pos.CENTER);

        invBlock.getChildren().addAll(ID,imageView, name, addressBox);

        return invBlock;
    }

    public static void stylingVB(VBox custBlock, Label custAddr, HBox addressBox, ImageView addrImg) {
        DropShadow ds = new DropShadow();

        ds.setColor(Color.web("#000000"));
        custBlock.setEffect(ds);

        addressBox.getChildren().addAll(addrImg, custAddr);
        addressBox.setAlignment(Pos.CENTER);
        addressBox.setSpacing(5);

        custBlock.setPrefWidth(223);
        custBlock.setMinWidth(223);
        custBlock.setMaxWidth(223);

        custBlock.setPrefHeight(296);
        custBlock.setMinHeight(296);
        custBlock.setMaxHeight(296);

        custBlock.setAlignment(Pos.TOP_CENTER);

        custBlock.setPadding(new Insets(10, 0, 15, 0));

        custBlock.styleProperty().bind(Bindings.when(custBlock.hoverProperty())
                .then("-fx-background-color: linear-gradient(#d387ab , #b279a7 );" +
                        " -fx-background-radius: 10; " +
                        " -fx-border-radius: 10;")

                .otherwise("-fx-background-color: linear-gradient(#eec0c6 , #e58c8a);" +
                        " -fx-background-radius: 10; " +
                        " -fx-border-radius: 10;"));
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
