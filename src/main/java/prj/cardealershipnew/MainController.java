package prj.cardealershipnew;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import prj.cardealershipnew.LoginAuthentication.RegisterSalesmanController;
import prj.cardealershipnew.LoginAuthentication.RegisteredEmployee;
import prj.cardealershipnew.salesman.SalemanUI;
import prj.cardealershipnew.salesman.SalemanUIController;
import prj.cardealershipnew.salesman.Salesman;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainController implements Initializable {


    @FXML
    private PasswordField passwordTF;

    @FXML
    private TextField userNameTF;

    @FXML
    private Label errorLabel;

    private double x = 0;
    private double y = 0;

    private  static Stage newSalesmanStage ;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Salesman defaultSM = new Salesman("EMP001",
                "Mohammed Tahayna",592130148,"Al-Ersal Ramallah", "mohammed.tahayna@gmail.com",
                5000.5,"2001-04-20");

        // default  employee
        SalemanUIController.getSalesmanMap().put(defaultSM.getSalesmanID(),defaultSM);

        // default registered employee
        RegisterSalesmanController.getRegisteredEmployeesHM().put("moh1",new RegisteredEmployee("moh1","Asd123@", defaultSM));


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
    void closeAction(ActionEvent event) {
        Main.getPrimaryStage().close();
    }

    @FXML
    void onKeyPressed(KeyEvent event) {

        if ( event.getCode() == KeyCode.ENTER ){

            try {
                loginButtonClicked();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }


    @FXML
    void loginButtonClicked() throws IOException {



        if (!Objects.equals(userNameTF.getText(), "") && !Objects.equals(passwordTF.getText(), "")) {


            try (PreparedStatement ps = Main.getConnect().prepareStatement("Select RE.employeeID, RE.username , RE.password from registeredEmployees RE " +
                    "where RE.username = ? AND RE.password = ?")) {

                ps.setString(1,userNameTF.getText());
                ps.setString(2,passwordTF.getText());

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {

                    String username = rs.getString("username");
                    String password = rs.getString("password");


                    if (!passwordTF.getText().matches(password) && !userNameTF.getText().matches(username) ){
                        errorLabel.setText("username / password incorrect !");
                        errorLabel.setStyle("-fx-text-fill: #d74141");
                        userNameTF.setStyle("-fx-border-color: #d74747");
                        passwordTF.setStyle("-fx-border-color: #d74747");

                    }else {

                        String empID = rs.getString("employeeID");

                        SalemanUIController.setCurrentLoggedInSM(empID);

                        userNameTF.setStyle("-fx-border-color: #FFFFFF");
                        passwordTF.setStyle("-fx-border-color: #FFFFFF");
                        errorLabel.setText("");

                        SalemanUI test = new SalemanUI();
                        test.buildUI();

                        Main.getPrimaryStage().close();

                    }


                }else {
                    errorLabel.setText("username / password incorrect !");
                    errorLabel.setStyle("-fx-text-fill: #d74141");
                    userNameTF.setStyle("-fx-border-color: #d74747");
                    passwordTF.setStyle("-fx-border-color: #d74747");

                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


        }else {
            errorLabel.setText("please specify username / password !");
            errorLabel.setStyle("-fx-text-fill: #d74141");

        }
    }

    @FXML
    void createNewSalemanAccount(ActionEvent event) {


        userNameTF.setStyle("-fx-border-color: #FFFFFF");
        userNameTF.clear();
        passwordTF.setStyle("-fx-border-color: #FFFFFF");
        passwordTF.clear();

        errorLabel.setText("");
        //Main.getPrimaryStage().close();

        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("/authResources/SignUpPage.fxml"));

        try {

            if ( newSalesmanStage == null ) {
                 newSalesmanStage = new Stage();
                Scene sc = new Scene(fxmlLoader.load(), 574, 543, Color.TRANSPARENT);
                newSalesmanStage.setScene(sc);
                newSalesmanStage.setTitle("Register Employee");
                newSalesmanStage.initModality(Modality.APPLICATION_MODAL);
                newSalesmanStage.initStyle(StageStyle.TRANSPARENT);
                newSalesmanStage.show();
            }
            else
                newSalesmanStage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static Stage getNewSalesmanStage() {
        return newSalesmanStage;
    }

    public static void setNewSalesmanStage(Stage newSalesmanStage) {
        MainController.newSalesmanStage = newSalesmanStage;
    }


}
