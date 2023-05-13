package prj.cardealershipnew.Vehicles;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import prj.cardealershipnew.projectUtils.AlertBox;
import prj.cardealershipnew.Customer.CustomerDetailsController;
import prj.cardealershipnew.projectUtils.Xeger;
import prj.cardealershipnew.salesman.ButtonsScene;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class VehiclesSceneController {


    private AlertBox alertBox = new AlertBox();

    private double x = 0;
    private double y = 0;

    private static HashMap<String,Car> carsList = new HashMap<>();

    private static int numberOfBlocks = 0 ;

    @FXML
    private TextField carNameTF = new TextField();

    @FXML
    private TextField carPriceTF = new TextField();

    @FXML
    private TextField imageID = new TextField();

    @FXML
    private TextField carColor = new TextField();

    @FXML
    private TextField carLogo = new TextField();

    @FXML
    private TextField carReleaseDate = new TextField();

    @FXML
    private TextField engineCC = new TextField();

    @FXML
    private TextField fuelType = new TextField();

    @FXML
    private TextField horsePower = new TextField();

    @FXML
    private TextField manufacturer = new TextField();

    @FXML
    private TextField milesDriven = new TextField();

    @FXML
    private TextField vinNumberGen = new TextField();

    @FXML
    private TextField gearType = new TextField();

    @FXML
    private TextField manufacturePlaceTF = new TextField();

    private static ArrayList<Car> arrayList = new ArrayList<>();


    static Stage carBoxClickedStage;

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
    void browseImageButtonAction(ActionEvent event) {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("F:\\university\\Season 3 Chap 1\\COMP333-DATABASE\\Project\\CarDealershipDataBaseProject\\carDealerShipNew\\src\\main\\resources\\salesmanUIResources\\images"));
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
        File imageFile = fileChooser.showOpenDialog(null);
        if (imageFile != null) {
            imageID.setText(imageFile.getAbsolutePath());
        } else
            alertBox.displayPopUp("Please Check your Image Path", "warning", 2);

    }

    @FXML
    void listCarButtonAction(ActionEvent event) {

        if (!imageID.getText().equals("") && !carNameTF.getText().equals("") && !carPriceTF.getText().equals("") &&
            !carColor.getText().equals("") && !carLogo.getText().equals("") && !carReleaseDate.getText().equals("") &&
            !engineCC.getText().equals("") && !fuelType.getText().equals("") && !horsePower.getText().equals("") &&
            !manufacturer.getText().equals("") && !milesDriven.getText().equals("") && !vinNumberGen.getText().equals("") &&
            !gearType.getText().equals("") ) {

            //here to edit code to insert to a database
            //but for testing using arraylist

           arrayList.add(new Car(carNameTF.getText(), Double.parseDouble(carPriceTF.getText()), Integer.parseInt(carReleaseDate.getText()),
                    milesDriven.getText(), carColor.getText(), manufacturer.getText(),manufacturePlaceTF.getText() ,new Image(imageID.getText()), vinNumberGen.getText()
                    , gearType.getText(), Integer.parseInt(engineCC.getText()), Float.parseFloat(horsePower.getText()), fuelType.getText(), new Image(carLogo.getText())));

            // use sql here
            carsList.put(vinNumberGen.getText(),arrayList.get(arrayList.size() - 1));

            ButtonsScene.CarsAndVehicles.getTiles().getChildren().add(0, createCarBlock(imageID.getText(), carNameTF.getText(), carPriceTF.getText(),vinNumberGen.getText()));

            carNameTF.clear();carPriceTF.clear();imageID.clear();
            carReleaseDate.clear();milesDriven.clear();carColor.clear();
            manufacturer.clear();vinNumberGen.clear();gearType.clear();
            engineCC.clear();horsePower.clear();carLogo.clear();fuelType.clear();
            manufacturePlaceTF.clear();

            ButtonsScene.CarsAndVehicles.getAddCarStage().close();


        } else
            alertBox.displayPopUp("Please Fill All The Blanks", "Warning !", 2);

    }

    @FXML
    void exitButtonClicked(ActionEvent event) {
        ButtonsScene.CarsAndVehicles.getAddCarStage().hide();

    }

    public static  VBox createCarBlock(String imageURL, String carName, String carPrice,String vinNumber) {


        VBox carBlock = new VBox();
        ImageView imageView = new ImageView(new Image(imageURL));
        imageView.setFitWidth(180);
        imageView.setFitHeight(130);

        Label name = new Label(carName);
        name.setFont(new Font("Barlow Condensed Black", 45));
        name.setAlignment(Pos.CENTER);


        Label price = new Label(carPrice + " $");

        ImageView deleteCarImage = new ImageView(new Image("F:\\university\\Season 3 Chap 1\\COMP333-DATABASE\\Project\\CarDealershipDataBaseProject\\carDealerShipNew\\src\\main\\resources\\salesmanUIResources\\images\\Delete_25px.png"));


        VBox.setMargin(deleteCarImage,new Insets(7,0,0,180));

        Label ID = new Label(vinNumber);
            ID.setFont(Font.font("System", FontWeight.BOLD,15));

        HBox priceBox = new HBox();

        ImageView priceTagImage = new ImageView(new Image("F:\\university\\Season 3 Chap 1\\COMP333-DATABASE\\Project\\CarDealershipDataBaseProject\\carDealerShipNew\\src\\main\\resources\\salesmanUIResources\\images\\price_30px.png"));

        CustomerDetailsController.stylingVB(carBlock, price, priceBox, priceTagImage);


        name.setOnMouseClicked(mouseEvent -> {


            Car temp =  carsList.get(vinNumber);

            new CarDetailss(new Label(temp.getCarColor()),new Label(temp.getMilesDriven() + "K Mi."),new ImageView(temp.getCarLogo()),new Label(temp.getCarName()),
                    new Label(temp.getCarName()),new Label("$ "+ temp.getCarPrice()),new Text("• Engine CC : " + temp.getEngineCC()),
                    new Text("• Fuel Type : " + temp.getFuelType()),new Text("• Gear Type : " + temp.getGearType()),new Text("• Horse Power : " + temp.getHorsePower()),
                    new Label(temp.getManufacturePlace()),new Text("• Manufacture Company : " + temp.getManufacturer()),new ImageView(temp.getCarImage()),new Text(temp.getVinNumber()),
                    new Label(String.valueOf(temp.getReleaseYear())));


        });

        imageView.setOnMouseClicked(mouseEvent -> {


           Car temp =  carsList.get(vinNumber);

           new CarDetailss(new Label(temp.getCarColor()),new Label(temp.getMilesDriven() + "K Mi."),new ImageView(temp.getCarLogo()),new Label(temp.getCarName()),
                            new Label(temp.getCarName()),new Label("$ "+ temp.getCarPrice()),new Text("• Engine CC : " + temp.getEngineCC()),
                            new Text("• Fuel Type : " + temp.getFuelType()),new Text("• Gear Type : " + temp.getGearType()),new Text("• Horse Power : " + temp.getHorsePower()),
                            new Label(temp.getManufacturePlace()),new Text("• Manufacture Company : " + temp.getManufacturer()),new ImageView(temp.getCarImage()),new Text(temp.getVinNumber()),
                            new Label(String.valueOf(temp.getReleaseYear())));


        });


        deleteCarImage.setOnMouseClicked( e -> {

            Alert alert = new Alert(Alert.AlertType.WARNING,"delete", ButtonType.YES,ButtonType.NO);
            alert.setTitle("Car Deletion");
            alert.setHeaderText("Warning! Car Will be Deleted permanently");
            alert.setContentText("Are you sure you want to remove car?");
            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.YES) {
                    ButtonsScene.CarsAndVehicles.getTiles().getChildren().remove(carBlock);
                    carsList.remove(vinNumber);

                }
            });


        });


        price.setFont(new Font("Barlow Condensed", 23));
        name.setAlignment(Pos.CENTER);


        carBlock.getChildren().addAll(ID,imageView, name, priceBox,deleteCarImage);

        return carBlock;
    }


    @FXML
    void browseLogoButtonAction(ActionEvent event) {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("F:\\university\\Season 3 Chap 1\\COMP333-DATABASE\\Project\\CarDealershipDataBaseProject\\carDealerShipNew\\src\\main\\resources\\salesmanUIResources\\images\\cars_images\\carLogos"));
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
        File imageFile = fileChooser.showOpenDialog(null);

        if (imageFile != null) {
            carLogo.setText(imageFile.getAbsolutePath());
        } else
            alertBox.displayPopUp("Please Check your Image logo Path", "warning", 2);

    }

    @FXML
    void vinGeneratorButtonAction(ActionEvent event) {

        String vinGen = "[A-HJ-NPR-Z0-9]{17}";
        Xeger vinGenByRegex = new Xeger(vinGen);
        vinNumberGen.setText(vinGenByRegex.generate());

    }

    public static HashMap<String, Car> getCarsList() {
        return carsList;
    }

    public static int getNumberOfBlocks() {
        return numberOfBlocks;
    }

    public static void setNumberOfBlocks(int numberOfBlocks) {

        VehiclesSceneController.numberOfBlocks = numberOfBlocks;
    }

    public static void setCarsList(HashMap<String, Car> carsList) {
        VehiclesSceneController.carsList = carsList;
    }
}
