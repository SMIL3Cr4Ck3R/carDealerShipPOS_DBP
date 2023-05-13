package prj.cardealershipnew.projectUtils;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import prj.cardealershipnew.Customer.CustomerController;
import prj.cardealershipnew.Customer.CustomerInfo;
import prj.cardealershipnew.Main;
import prj.cardealershipnew.Vehicles.Car;
import prj.cardealershipnew.Vehicles.VehiclesSceneController;
import prj.cardealershipnew.salesman.ButtonsScene;
import prj.cardealershipnew.salesman.SalemanUIController;
import prj.cardealershipnew.salesman.Salesman;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class InputDialog {

    private final int rows;



    private final String[] col1;

    private final String[] col2;

    private final char objType;

    private final String ID ;

    private final AlertBox altbx = new AlertBox() ;

    public InputDialog(int rows, String[] col1, String[] col2,char objType,String ID) {

        this.rows = rows;
        this.col1 = col1;
        this.col2 = col2;
        this.objType = objType;
        this.ID = ID ;

        createUI();

    }

    private void createUI(){

        Scene sc;

        Label[] primaryLabels = new Label[rows];
        TextField[] textFields = new TextField[rows];

        Label editInfo = new Label("Edit Information");

        editInfo.setFont(Font.font("System",FontWeight.BOLD,25));

        Button editButton = new Button("Edit Info");
        editButton.setFont(Font.font(20));

        editButton.setPrefHeight(50);
        editButton.setPrefWidth(150);
        editButton.setStyle("-fx-background-color: #E5E5E5;" +
                "-fx-border-color: black ; " +
                "-fx-border-radius: 9px;" +
                "-fx-background-radius: 10px");


        VBox mainVB = new VBox();

        mainVB.setStyle("-fx-background-color: white");

        Stage stage = new Stage();


        GridPane gp = new GridPane();

        gp.setHgap(10);
        gp.setVgap(8);
        gp.setAlignment(Pos.TOP_CENTER);

        for (int i = 0 ; i < rows ; i++){

            primaryLabels[i] = new Label(col1[i]);
            textFields[i] = new TextField(col2[i]);
            gp.add(primaryLabels[i],0,i);
            gp.add(textFields[i],1,i);

            primaryLabels[i].setFont(Font.font("System", FontWeight.BOLD,12));
            textFields[i].setFont(Font.font(12));
            textFields[i].setStyle("-fx-background-color: white;" +
                    "-fx-border-color: black;" +
                    "-fx-background-radius: 10px;" +
                    "-fx-border-radius: 10px");
        }

        editButton.setOnAction( e -> {


            switch (objType) {
                case 'S', 'E', 's', 'e' -> {

                    try (PreparedStatement ps = Main.getConnect().prepareStatement("Update Employee " +
                            "set employeeName = ? , employeePhone = ? ,employeeAddress = ? , emailAddr = ? , DOB = ? " +
                            "where employeeID = ? ")){

                        ps.setString(1,textFields[0].getText());
                        ps.setInt(2,Integer.parseInt(textFields[1].getText()));
                        ps.setString(3,textFields[2].getText());
                        ps.setString(4, textFields[3].getText());



                        String[] split = textFields[4].getText().split("-");
                        ps.setDate(5,new Date(Integer.parseInt(split[0]) - 1900,Integer.parseInt(split[1]),Integer.parseInt(split[2])));

                        ps.setString(6,ID);

                        ps.executeUpdate();

                        altbx.displayPopUp("Information Updated", "Updated !", 3);
                        stage.close();

                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }

                }

                case 'C', 'c' -> {
                    CustomerController.getCustomerInfoHashMap().remove(ID);
                    CustomerController.getCustomerInfoHashMap().put(ID, new CustomerInfo(ID, textFields[0].getText(), Integer.parseInt(textFields[1].getText()),
                            Integer.parseInt(textFields[2].getText()), textFields[3].getText(), textFields[4].getText()));




                    altbx.displayPopUp("Information Updated", "Updated !", 3);
                    stage.close();
                }

                case 'V', 'v' -> {
                    VehiclesSceneController.getCarsList().remove(ID);
                    VehiclesSceneController.getCarsList().put(ID, new Car(textFields[0].getText(), Double.parseDouble(textFields[1].getText()),
                            Integer.parseInt(textFields[2].getText()), textFields[3].getText(), textFields[4].getText(), textFields[5].getText(),
                            textFields[6].getText(), new Image(textFields[7].getText()), textFields[8].getText(), textFields[9].getText(), Integer.parseInt(textFields[10].getText()),
                            Float.parseFloat(textFields[11].getText()), textFields[12].getText(), new Image(textFields[13].getText())));

                    altbx.displayPopUp("Information Updated", "Updated !", 3);
                    stage.close();
                }
                default -> System.out.println("There is no object with type " + objType);
            }



        } );



        mainVB.setSpacing(5);
        mainVB.setAlignment(Pos.TOP_CENTER);
        mainVB.setPadding(new Insets(10));
        mainVB.getChildren().addAll(editInfo,gp,editButton);


        sc = new Scene(mainVB,346 ,(rows * 40) + 50 );
        stage.setScene(sc);
        stage.setResizable(true);
        stage.initModality(Modality.APPLICATION_MODAL);

        stage.show();


    }



}
