package prj.cardealershipnew.salesman;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class ButtonsScene {


    public static class Dashboard {

        private final ScrollPane scroll = new ScrollPane();
        private static Stage ObjectsOperationStage ;
        private static final TilePane tiles = new TilePane();



        public Dashboard() {

            createPanelUI();
        }


        private void createPanelUI(){

            createBunchOdButtons ();
            createCenterUI(tiles, scroll);
            scroll.setContent(tiles);

        }

        private void createBunchOdButtons () {


            Button[] opButtons = new Button[]   {
                    new Button("Salesmen Age\n Greater Than 20"),new Button("Salesman salary\nEquals 3000"),new Button("Salesmen By Address"),
                    new Button("Customer By ID"),new Button("Customer By "),new Button("Customer BY "),
                    new Button("Car By Manufacturer"),new Button("Car By Color"),new Button("Car by Group"),
                    new Button("testing a set"),new Button("Testing a set"),new Button("Testing  a set"),
                    new Button("testing a set"),new Button("Testing a set"),new Button("Testing  a set"),
                    new Button("testing a set"),new Button("Testing a set"),new Button("Testing  a set"),
                    new Button("Testing a set"),new Button("Testing  a set")
            };

            for (int i = 0 ;  i < opButtons.length; i++) {


                opButtons[i].setFont(Font.font("System", FontWeight.BOLD,15));
                opButtons[i].setStyle("-fx-background-color: linear-gradient(#ffa69e,#861657);" +
                        "");
                DropShadow ds = new DropShadow();

                ds.setColor(Color.web("#000000"));
                opButtons[i].setEffect(ds);

                opButtons[i].setPrefWidth(165);
                opButtons[i].setMinWidth(165);
                opButtons[i].setMaxWidth(165);

                opButtons[i].setPrefHeight(100);
                opButtons[i].setMinHeight(100);
                opButtons[i].setMaxHeight(100);

                opButtons[i].setAlignment(Pos.TOP_CENTER);

                opButtons[i].setPadding(new Insets(10, 0, 15, 0));

                opButtons[i].styleProperty().bind(Bindings.when(opButtons[i].hoverProperty())
                        .then("-fx-background-color: linear-gradient(#d387ab , #b279a7 );" +
                                " -fx-background-radius: 10; " +
                                " -fx-border-radius: 10;")

                        .otherwise("-fx-background-color: linear-gradient(#eec0c6 , #e58c8a);" +
                                " -fx-background-radius: 10; " +
                                " -fx-border-radius: 10;"));

                tiles.getChildren().add(opButtons[i]);
            }

        }

        public ScrollPane getScroll() {
            return scroll;
        }

        public static Stage getObjectsOperationStage() {
            return ObjectsOperationStage;
        }

        public static void setObjectsOperationStage(Stage objectsOperationStage) {
            ObjectsOperationStage = objectsOperationStage;
        }
    }
    public static class CarsAndVehicles {

        private final ScrollPane scroll = new ScrollPane();
        private static Stage addCarStage ;
        private static final TilePane tiles = new TilePane();


        public CarsAndVehicles(){

            createPanelUI();
        }



        private void createPanelUI(){


            Button addCarButton = new Button("+");
            addCarButton.setFont(new Font(50));

            addCarButton.setAlignment(Pos.CENTER);
            addCarButton.setMaxHeight(296);
            addCarButton.setMinHeight(296);

            addCarButton.setMaxWidth(223);
            addCarButton.setMinWidth(223);


            addCarButton.styleProperty().bind(Bindings.when(addCarButton.hoverProperty())
                    .then("-fx-background-color: linear-gradient(#d387ab , #b279a7 );" +
                            " -fx-background-radius: 10; " +
                            " -fx-border-radius: 10;")

                    .otherwise("-fx-border-color: transparent ;" +
                            " -fx-background-color: #6D3050 ;" +
                            " -fx-background-radius: 10; " +
                            " -fx-border-radius: 10;"));

            addCarButton.setOnAction(e -> {

                if(addCarStage == null) {
                    addCarStage = new Stage();
                    FXMLLoader fxmll = new FXMLLoader(ButtonsScene.class.getResource("/salesmanUIResources/fxmls/addCarDialog.fxml"));
                    try {
                        addCarStage.setScene(new Scene(fxmll.load(), 766, 515, Color.TRANSPARENT));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    addCarStage.setResizable(false);
                    addCarStage.initStyle(StageStyle.TRANSPARENT);
                    addCarStage.initModality(Modality.APPLICATION_MODAL);
                    addCarStage.show();
                }else
                    addCarStage.show();

            });

            createCenterUI(tiles, scroll);

            tiles.getChildren().add(addCarButton);
            scroll.setContent(tiles);

        }

        public ScrollPane getScroll() {
            return scroll;
        }

        public static Stage getAddCarStage() {

                return addCarStage;

            }

        public static TilePane getTiles() {
            return tiles;
        }
    }
    public static class AboutUs {

        private static Stage aboutStage;

        public AboutUs () throws IOException {
            buildUI();
        }

        private void buildUI () throws IOException {


            if (aboutStage == null) {
                aboutStage = new Stage();
                FXMLLoader loadAboutFXML = new FXMLLoader(ButtonsScene.AboutUs.class.getResource("/salesmanUIResources/fxmls/aboutUsDialog.fxml"));
                aboutStage.setScene(new Scene(loadAboutFXML.load(),438,343, Color.TRANSPARENT));
                aboutStage.initModality(Modality.APPLICATION_MODAL);
                aboutStage.initStyle(StageStyle.TRANSPARENT);
                aboutStage.setResizable(true);
                aboutStage.show();
            }
            else
                aboutStage.show();

        }


        public static Stage getAboutStage() {
            return aboutStage;
        }

    }
    public static class Customers{


        private final ScrollPane scroll = new ScrollPane();

        private static  TilePane tiles = new TilePane();
        private static Stage addCustomerStage;

        public Customers(){

            createPanelUI();
        }


        private void createPanelUI(){

            createCenterUI(tiles, scroll);
            scroll.setContent(tiles);


        }


        public ScrollPane getScroll() {
            return scroll;
        }

        public static Stage getAddCustomerStage() {
            return addCustomerStage;
        }

        public static TilePane getTiles() {
            return tiles;
        }


    }
    public static class VehiclesInvoices{

        private final ScrollPane scroll = new ScrollPane();
        private static Stage addInvoiceStage ;
        private static TilePane tiles = new TilePane();

        public VehiclesInvoices ()  {

            createInvoiceUI();

        }

        private void createInvoiceUI() {

            createCenterUI(tiles, scroll);
            scroll.setContent(tiles);

        }

        public ScrollPane getScroll() {
            return scroll;
        }


        public static TilePane getTiles() {
            return tiles;
        }

        public static Stage getAddInvoiceStage() {
            return addInvoiceStage;
        }

        public static void setAddInvoiceStage(Stage addInvoiceStage) {
            VehiclesInvoices.addInvoiceStage = addInvoiceStage;
        }


    }

    private static void createCenterUI(TilePane tiles, ScrollPane scroll) {
        tiles.setTileAlignment(Pos.TOP_LEFT);
        tiles.setAlignment(Pos.TOP_LEFT);
        tiles.setHgap(10);
        tiles.setVgap(10);
        tiles.setPadding(new Insets(7,5,5,8));

        tiles.setStyle("-fx-background-color : transparent;");

        tiles.setMaxWidth(712);
        tiles.setMinWidth(712);
        tiles.setPrefWidth(712);

        scroll.setMaxWidth(715);
        scroll.setMinWidth(715);
        scroll.setPrefWidth(715);

        scroll.setMaxHeight(500);
        scroll.setMinHeight(500);
        scroll.setPrefHeight(500);

        scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        scroll.setHvalue(0);
        scroll.setVvalue(0);

        scroll.setHmin(0);
        scroll.setVmin(0);

        scroll.setHmax(10);
        scroll.setVmax(10);

        scroll.setStyle("-fx-background-color: transparent; " +
                "-fx-border-color: transparent ;" +
                "-fx-border-radius: 10 ; " +
                "-fx-background-radius: 10 ;");
    }

}
