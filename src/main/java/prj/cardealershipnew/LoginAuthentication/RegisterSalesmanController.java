package prj.cardealershipnew.LoginAuthentication;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import prj.cardealershipnew.MailService.SendMailUtils;
import prj.cardealershipnew.Main;
import prj.cardealershipnew.MainController;
import prj.cardealershipnew.projectUtils.AlertBox;
import prj.cardealershipnew.projectUtils.Xeger;
import prj.cardealershipnew.salesman.Salesman;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class RegisterSalesmanController implements Initializable {

    private double x = 0;
    private double y = 0;

    @FXML
    private CheckBox checkPBox;

    @FXML
    private TextField dayTF;

    @FXML
    private TextField emailTF;

    @FXML
    private TextField fullNameTF;

    @FXML
    private ChoiceBox<String> genderChoiceBOX;

    @FXML
    private TextField monthTF;

    @FXML
    private PasswordField passwordTF;

    @FXML
    private TextField usernameTF;

    @FXML
    private TextField yearTF;

    @FXML
    private TextField homeAddressTF;

    @FXML
    private TextField phoneTF;

    @FXML
    private TextField showPassTF;

    @FXML
    private Button showPassButton;


    @FXML
    private Label userExsitLB;

    AlertBox altb = new AlertBox();

    private static Stage verifyStage ;

    private static String getEmail;

    private static HashMap<String, RegisteredEmployee> registeredEmployeesHM = new HashMap<>();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        genderChoiceBOX.getItems().addAll("Male","Female");
        genderChoiceBOX.setValue("Male");


    }

    @FXML
    void clickedPP(MouseEvent event) {


        try {
            File ppFile = new File("PrivacyPolicy.txt");

           if ( ppFile.exists()){

               Process proc = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " +  ppFile.getAbsolutePath());
               proc.waitFor();

           }

       }catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void clickedTUA(MouseEvent event) {

        try {
            File ppFile = new File("TUA.txt");

            if ( ppFile.exists()){

                Process proc = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " +  ppFile.getAbsolutePath());
                proc.waitFor();

            }

        }catch (Exception e) {
            throw new RuntimeException(e);
        }



    }

    @FXML
    void registerButtonClicked(ActionEvent event) {



        if (!dayTF.getText().equals("") && !emailTF.getText().equals("") && !fullNameTF.getText().equals("") && !monthTF.getText().equals("") &&
                !passwordTF.getText().equals("") && !usernameTF.getText().equals("") && !yearTF.getText().equals("") && !genderChoiceBOX.getSelectionModel().getSelectedItem().equals("") &&
                !homeAddressTF.getText().equals("") && !phoneTF.getText().equals("") ) {

        if (fullNameTF.getText().matches("\\w+\\s\\w+") && usernameTF.getText().matches("^[a-zA-Z]{3,16}\\d{1,5}$") && passwordTF.getText().matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{7,20}$")
            && emailTF.getText().matches("^[a-zA-Z\\d._%+-]+@[a-zA-Z\\d.-]+\\.[a-z]{2,6}$") && (dayTF.getText().matches("^(0[1-9]|[12]\\d|3[01])$") && monthTF.getText().matches("^(0[1-9]|1[0-2])$")
            && yearTF.getText().matches("^\\d{4}$")) && homeAddressTF.getText().matches("\\w+") && phoneTF.getText().matches("^05[69]\\d{7}$") ) {



            if ( registeredEmployeesHM.get(usernameTF.getText()) == null ) {

                if (checkPBox.isSelected()){


                    if (verifyStage == null) {

                        try {

                            FXMLLoader fxmlLoader = new FXMLLoader(RegisterSalesmanController.class.getResource("/authResources/verifyRegisterationToken.fxml"));

                            getEmail = this.emailTF.getText();
                            VerifyRegistrationTokenController.setRegisteredEmployee(new RegisteredEmployee(usernameTF.getText().trim(),passwordTF.getText().trim(),
                                    new Salesman(generateEmpID(),fullNameTF.getText(),Integer.parseInt(phoneTF.getText()),homeAddressTF.getText(),
                                            emailTF.getText(),3200,(yearTF.getText()+"-"+monthTF.getText()+"-"+dayTF.getText()))));

                            verifyStage = new Stage();
                            Scene sc = new Scene(fxmlLoader.load(),600,424,Color.TRANSPARENT);
                            verifyStage.initStyle(StageStyle.TRANSPARENT);
                            verifyStage.initModality(Modality.APPLICATION_MODAL);
                            verifyStage.setScene(sc);
                            verifyStage.show();


                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                    }


                    MainController.getNewSalesmanStage().close();
                    MainController.setNewSalesmanStage(null);
                    Main.getPrimaryStage().show();

                }else
                    altb.displayPopUp("Please Accept our terms of service","EULA Acceptance needed !",2);


            }else{

                usernameTF.setStyle("-fx-border-color: #E54C4C");
                userExsitLB.setTextFill(Color.web("#E54C4C"));
                userExsitLB.setText("USER ALREADY EXISTS !");

            }






        }else
            altb.displayPopUp("Please Check your inputs format and try again","Format not matching",2);

        }else
            altb.displayPopUp("Please Fill All the blanks","Warning!",2);




    }

    @FXML
    void closeAction() {

        MainController.getNewSalesmanStage().close();
        MainController.setNewSalesmanStage(null);

    }

    private String generateEmpID() {

        String vinGen = "EMP[0-9]{3}";
        Xeger vinGenByRegex = new Xeger(vinGen);
        return vinGenByRegex.generate();

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
    void showPasswordBA(ActionEvent event) {

        if(showPassButton.getText().equals("Show")) {

           showPassTF.setText(passwordTF.getText());
           showPassTF.setVisible(true);
           passwordTF.setVisible(false);
           showPassButton.setText("Hide");


        }else {

            passwordTF.setText(showPassTF.getText());
            showPassTF.setVisible(false);
            passwordTF.setVisible(true);
            showPassButton.setText("Show");

        }

    }

    public static HashMap<String, RegisteredEmployee> getRegisteredEmployeesHM() {
        return registeredEmployeesHM;
    }

    public static Stage getVerifyStage() {
        return verifyStage;
    }

    public static String getGetEmail() {
        return getEmail;
    }

    public static void setVerifyStage(Stage verifyStage) {
        RegisterSalesmanController.verifyStage = verifyStage;
    }
}
