package prj.cardealershipnew.Vehicles;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import prj.cardealershipnew.projectUtils.InputDialog;

import java.io.IOException;
import java.util.Optional;

public class CarDetailss {

    private double x = 0;
    private double y = 0;
    @FXML
    private Label carColor = new Label("Black");
    @FXML
    private Label carDrivenMi = new Label("100K Mi.");
    @FXML
    private ImageView carLogoImage = new ImageView(new Image("F:\\university\\Season 3 Chap 1\\COMP333-DATABASE\\Project\\CarDealershipDataBaseProject\\carDealerShipNew\\src\\main\\resources\\salesmanUIResources\\images\\cars_images\\carLogos\\bmw_48px.png"));
    @FXML
    private Label carName = new Label("Porsche 911");
    @FXML
    private Label carNameBanner = new Label("Porsche 911");
    @FXML
    private Label carPrice = new Label("$57,888");
    @FXML
    private Text engineCC  = new Text("Text");
    @FXML
    private Text engineFuelType =  new Text("Text");
    @FXML
    private Text gearType =  new Text("Text");
    @FXML
    private Text horsePower = new Text("Text");
    @FXML
    private Label manuFacturePlace = new Label("Text");
    @FXML
    private Text manufacturerName =  new Text("Text");
    @FXML
    private ImageView pickedCarImage = new ImageView("F:\\university\\Season 3 Chap 1\\COMP333-DATABASE\\Project\\CarDealershipDataBaseProject\\carDealerShipNew\\src\\main\\resources\\salesmanUIResources\\images\\cars_images\\BHq99JoKd7rcwbH-BMW-X5-Transparent-Background-removebg-preview.png");
    @FXML
    private Text vinNumber =  new Text("WP0AB0918HSt23493");
    @FXML
    private Label yearReleased = new Label("1988");
    @FXML
    private Button editInfo = new Button("Edit Info");
    @FXML
    private Button purchaseCar  = new Button("Purchase");
    @FXML
    private static Stage stage;
    @FXML

    static String cloneCarID ;


    public CarDetailss () {


        createUI ();
    }




    public CarDetailss(Label carColor, Label carDrivenMi, ImageView carLogoImage, Label carName, Label carNameBanner,
                       Label carPrice, Text engineCC, Text engineFuelType, Text gearType, Text horsePower, Label manuFacturePlace,
                       Text manufacturerName, ImageView pickedCarImage, Text vinNumber, Label yearReleased) {


        this.carColor = carColor;
        this.carDrivenMi = carDrivenMi;
        this.carLogoImage = carLogoImage;
        this.carName = carName;
        this.carNameBanner = carNameBanner;
        this.carPrice = carPrice;
        this.engineCC = engineCC;
        this.engineFuelType = engineFuelType;
        this.gearType = gearType;
        this.horsePower = horsePower;
        this.manuFacturePlace = manuFacturePlace;
        this.manufacturerName = manufacturerName;
        this.pickedCarImage = pickedCarImage;
        this.vinNumber = vinNumber;
        this.yearReleased = yearReleased;
        cloneCarID = vinNumber.getText();

        createUI ();


    }

    private void createUI () {


        Stage carDetailsStage = new Stage();
        VBox mainVBx = new VBox();

        Button exitButton = new Button("X");
        VBox secondVBox = new VBox();

        HBox nameAndIconHB = new HBox();
        HBox milesColorAndLocationHB = new HBox();
        HBox nameAndPriceHB = new HBox();


        exitButton.styleProperty().bind(Bindings.when(exitButton.hoverProperty())
                .then("    -fx-background-color : #FFECEC;\n" +
                        "    -fx-text-fill: #FC4E4E;")

                .otherwise(" -fx-background-color : #B54E73;\n"));


        exitButton.setPrefWidth(29);
        exitButton.setPrefHeight(27);
        VBox.setMargin(exitButton,new Insets(0,0,0,249));

        exitButton.setOnAction(actionEvent -> carDetailsStage.close());


        carNameBanner.setFont(Font.font("Barlow Condensed",FontWeight.BOLD,36));
        HBox.setMargin(carNameBanner,new Insets(0,0,0,5));

        carLogoImage.setFitWidth(38);
        carLogoImage.setFitHeight(38);
        HBox.setMargin(carLogoImage,new Insets(5,0,0,0));

        nameAndIconHB.setSpacing(5);
        VBox.setMargin(nameAndIconHB,new Insets(0,0,0,5));
        nameAndIconHB.setPrefWidth(299);
        nameAndIconHB.setPrefHeight(47);
        nameAndIconHB.setAlignment(Pos.TOP_LEFT);
        nameAndIconHB.getChildren().addAll(carNameBanner,carLogoImage);


        pickedCarImage.setFitWidth(181);
        pickedCarImage.setFitHeight(136);

            //
            yearReleased.setPrefWidth(47);
            yearReleased.setPrefHeight(17);
            yearReleased.setTextFill(Color.web("#a2acbc"));


        carName.setFont(new Font("Barlow Condensed Black",25));
        HBox.setMargin(carName,new Insets(0,0,5,0));
        carName.setPrefWidth(180);
        carName.setPrefHeight(32);
        carName.setAlignment(Pos.CENTER_LEFT);


        carPrice.setFont(Font.font("Barlow Condensed",FontWeight.BOLD,20));
        carPrice.setPrefWidth(100);
        carPrice.setPrefHeight(32);
        carPrice.setAlignment(Pos.CENTER_LEFT);

        nameAndPriceHB.setAlignment(Pos.TOP_LEFT);
        nameAndPriceHB.setPrefHeight(20);
        nameAndPriceHB.setPrefWidth(269);

        nameAndPriceHB.getChildren().addAll(carName,carPrice);


        /////////////////////////////////

        carColor.setFont(Font.font("System",FontWeight.BOLD,14));
        carColor.setTextFill(Color.web("#989bad"));
        carColor.setPrefWidth(68);
        carColor.setPrefHeight(28);
        carColor.setPadding(new Insets(3,7,3,7));
        carColor.setAlignment(Pos.CENTER);
        carColor.setStyle("""
                    -fx-background-color: #EBEFF8;
                    -fx-border-color: #EBEFF8;
                    -fx-border-radius : 10 ;
                    -fx-background-radius: 10;
                """);

        manuFacturePlace.setFont(Font.font("System",FontWeight.BOLD,14));
        manuFacturePlace.setTextFill(Color.web("#989bad"));
        manuFacturePlace.setPadding(new Insets(3,7,3,7));
        manuFacturePlace.setPrefWidth(85);
        manuFacturePlace.setPrefHeight(28);
        manuFacturePlace.setAlignment(Pos.CENTER);
        manuFacturePlace.setStyle("""
                    -fx-background-color: #EBEFF8;
                    -fx-border-color: #EBEFF8;
                    -fx-border-radius : 10 ;
                    -fx-background-radius: 10;
                """);

        carDrivenMi.setFont(Font.font("System",FontWeight.BOLD,14));
        carDrivenMi.setTextFill(Color.web("#989bad"));
        carDrivenMi.setPrefWidth(75);
        carDrivenMi.setAlignment(Pos.CENTER);
        carDrivenMi.setPadding(new Insets(3,7,3,7));
        carDrivenMi.setStyle("""
                    -fx-background-color: #EBEFF8;
                    -fx-border-color: #EBEFF8;
                    -fx-border-radius : 10 ;
                    -fx-background-radius: 10;
                """);


        milesColorAndLocationHB.setAlignment(Pos.CENTER);
        milesColorAndLocationHB.setSpacing(5);
        milesColorAndLocationHB.setPrefWidth(284);
        milesColorAndLocationHB.setPrefHeight(36);

        milesColorAndLocationHB.getChildren().addAll(carDrivenMi,carColor,manuFacturePlace);


        final Label vinL = new Label("VIN Number");
        vinL.setFont(Font.font("System",FontWeight.BOLD,15));
        vinL.setPadding(new Insets(10,0,0,0));

        vinNumber.setFont(Font.font("System", FontWeight.BOLD,15));
        vinNumber.setFill(Color.web("#aeb3bc"));

        final Label detailsL = new Label("Details");
        detailsL.setFont(Font.font("System",FontWeight.BOLD,18));
        VBox.setMargin(detailsL,new Insets(15,0,0,0));



        styleProp(manufacturerName, gearType);
        styleProp(engineCC, horsePower);

        engineFuelType.setFont(Font.font("Barlow Condensed",FontWeight.BOLD,16));
        engineFuelType.setFill(Color.web("#575a5e"));
        VBox.setMargin(engineFuelType,new Insets(0,0,0,10));
        engineFuelType.setWrappingWidth(222.14399909973145);

        Line line = new Line();
        line.setStartX(-100);
        line.setEndX(161.2928924560547);

        line.setStartY(0);
        line.setEndY(-2.071068048477173);

        editInfo.setPrefWidth(277);
        editInfo.setPrefHeight(32);
        editInfo.setFont(Font.font("System",FontWeight.BOLD,14));
        editInfo.styleProperty().bind(Bindings.when(editInfo.hoverProperty())
                .then("""
                        -fx-background-color: #d1caca;
                        -fx-border-color: #bcbcbc;
                        -fx-border-radius : 10 ;
                        -fx-background-radius: 10;""".indent(4))

                .otherwise("""
                        -fx-background-color: #EBEFF8;
                        -fx-border-color: #bcbcbc;
                        -fx-border-radius : 10 ;
                        -fx-background-radius: 10;""".indent(4)));

        purchaseCar.setPrefWidth(277);
        purchaseCar.setPrefHeight(32);
        purchaseCar.setFont(Font.font("System",FontWeight.BOLD,14));
        purchaseCar.styleProperty().bind(Bindings.when(purchaseCar.hoverProperty())
                .then("""
                        -fx-background-color: #D98587;
                        -fx-border-color: #000000;
                        -fx-border-radius : 9 ;
                        -fx-text-fill : white;    -fx-background-radius: 10;""".indent(4))

                .otherwise("""
                        -fx-background-color: #EBEFF8;
                        -fx-border-color: #bcbcbc;
                        -fx-border-radius : 10 ;
                        -fx-background-radius: 10;""".indent(4)));



        secondVBox.setPadding(new Insets(15,15,0,15));
        secondVBox.setSpacing(4);
        secondVBox.setPrefWidth(297);
        secondVBox.setPrefHeight(438);
        secondVBox.setAlignment(Pos.TOP_LEFT);
        secondVBox.setStyle("" +
                "    -fx-background-radius: 25px 25px 15px 15px;\n" +
                "    -fx-background-color: white;");

        secondVBox.getChildren().addAll(yearReleased,nameAndPriceHB,milesColorAndLocationHB,vinL,vinNumber,
                                        detailsL,manufacturerName,gearType,engineCC,horsePower,engineFuelType,line,purchaseCar,editInfo);



        mainVBx.setStyle("""
                -fx-background-color :linear-gradient( #ffa69e,#861657);
                -fx-background-radius : 15;
                -fx-border-radius : 15 ;
                -fx-border-color: black;\s""".indent(4));

        mainVBx.setAlignment(Pos.TOP_CENTER);
        mainVBx.setPadding(new Insets(11,0,0,0));
        mainVBx.setPrefHeight(630);
        mainVBx.setPrefWidth(299);

        mainVBx.getChildren().addAll(exitButton,nameAndIconHB,pickedCarImage,secondVBox);

        mainVBx.setOnMouseDragged(this::draggedScene);
        mainVBx.setOnMousePressed(this::pressedOnScene);


        purchaseCar.setOnAction(e -> {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"newCustomer Detected",ButtonType.YES,ButtonType.NO);
            alert.setTitle("New Customer");
            alert.setHeaderText("New Customer Detection");
            alert.setContentText("Is This a New Customer ?");

            Optional<ButtonType> result = alert.showAndWait();


            if ( result.isPresent() && result.get() == ButtonType.YES ) {

                FXMLLoader fxmlLoader = new FXMLLoader(CarDetailss.class.getResource("/salesmanUIResources/fxmls/addCustomerDialog.fxml"));
                try {

                    if ( stage == null ) {
                        stage = new Stage();
                        Scene scene = new Scene(fxmlLoader.load(), 766, 402, Color.TRANSPARENT);
                        stage.setScene(scene);
                        stage.initStyle(StageStyle.TRANSPARENT);
                        stage.initModality(Modality.APPLICATION_MODAL);
                        stage.show();
                        carDetailsStage.close();
                    }else
                        stage.show();

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }else if ( result.isPresent() && result.get() == ButtonType.NO){




            }

        } );

        editInfo.setOnAction( e -> {


            Car c = VehiclesSceneController.getCarsList().get(vinNumber.getText());

            Node node = (Node) e.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();

            new InputDialog(14,new String[]{"Car Name:","Car Price:","Release Year : ","Miles Driven :","car Color :","Manufacturer :",
            "Manufacture Place : ","Car Image Url :","Vin Number: ","Gear Type:","Engine CC :","horsePower : ","Fuel Type","Logo url:"},

                    new String[]{c.getCarName(),String.valueOf(c.getCarPrice()),String.valueOf(c.getReleaseYear()),c.getMilesDriven(),c.getCarColor(),
                            c.getManufacturer(),c.getManufacturePlace(),c.getCarImage().getUrl(),c.getVinNumber(), c.getGearType(),String.valueOf(c.getEngineCC()),String.valueOf(c.getHorsePower()),c.getFuelType(),c.getCarLogo().getUrl()},

                    'V',vinNumber.getText());



        });


        Scene carDetailsScene = new Scene(mainVBx , 299, 654, Color.TRANSPARENT);
        carDetailsStage.setScene(carDetailsScene);
        carDetailsStage.setResizable(true);
        carDetailsStage.initModality(Modality.APPLICATION_MODAL);
        carDetailsStage.initStyle(StageStyle.TRANSPARENT);
        carDetailsStage.show();

    }


    private void styleProp(Text manufacturerName, Text gearType) {
        manufacturerName.setFont(Font.font("Barlow Condensed",FontWeight.BOLD,16));
        manufacturerName.setFill(Color.web("#575a5e"));
        VBox.setMargin(manufacturerName,new Insets(0,0,0,10));
        manufacturerName.setWrappingWidth(222.14399909973145);

        gearType.setFont(Font.font("Barlow Condensed",FontWeight.BOLD,16));
        gearType.setFill(Color.web("#575a5e"));
        VBox.setMargin(gearType,new Insets(0,0,0,10));
        gearType.setWrappingWidth(222.14399909973145);
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


    public static Stage getStage() {
        return stage;
    }

    public static String getCloneCarID() {
        return cloneCarID;
    }

    public static void setStage(Stage stage) {
        CarDetailss.stage = stage;
    }
}
