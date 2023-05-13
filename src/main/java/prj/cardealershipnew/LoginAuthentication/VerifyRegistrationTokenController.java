
package prj.cardealershipnew.LoginAuthentication;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import prj.cardealershipnew.MailService.SendMailUtils;
import prj.cardealershipnew.MainController;
import prj.cardealershipnew.projectUtils.AlertBox;
import prj.cardealershipnew.salesman.Salesman;

import java.net.URL;
import java.util.ResourceBundle;

public class VerifyRegistrationTokenController implements Initializable {


    @FXML
    private Label emailTF = new Label();

    @FXML
    private TextField frthDigitTF = new TextField();

    @FXML
    private TextField fstDigitTF = new TextField();

    @FXML
    private Label isNotValidLB = new Label();

    @FXML
    private TextField scdDigitTF= new TextField();

    @FXML
    private TextField thrdDigitTF = new TextField();

    private SendMailUtils emailSender ;

    private AlertBox altBox = new AlertBox();

    private static RegisteredEmployee registeredEmployee;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.emailTF.setText(RegisterSalesmanController.getGetEmail());

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                emailSender = new SendMailUtils();
                emailSender.Email(emailTF.getText());
            }
        });

        thread.start();



    }


    @FXML
    void closeAction(ActionEvent event) {

        RegisterSalesmanController.getVerifyStage().close();
        RegisterSalesmanController.setVerifyStage(null);

    }

    @FXML
    void verifyButtonClicked(ActionEvent event) {

        if (!fstDigitTF.getText().trim().equals("") && !scdDigitTF.getText().trim().equals("") && !thrdDigitTF.getText().trim().equals("") &&
                !frthDigitTF.getText().trim().equals("")) {

            if (("" + fstDigitTF.getText().trim() + scdDigitTF.getText().trim() + thrdDigitTF.getText().trim() +
                    frthDigitTF.getText().trim()).equals(SendMailUtils.getVerificationToken())  ) {

                RegisterSalesmanController.getRegisteredEmployeesHM().put(registeredEmployee.getUsername(),registeredEmployee);

                altBox.displayPopUp("Employee Added Successfully!","New Customer",3);
                RegisterSalesmanController.getVerifyStage().close();
                isNotValidLB.setText("");

            }else {

                fstDigitTF.setStyle("    -fx-background-color : #FFFFFF;" +
                        "    -fx-border-color : #ff0000;" +
                        "    -fx-border-radius: 15px;" +
                        "    -fx-background-radius: 15px;" +
                        "    -fx-border-width: 2px;");

                fstDigitTF.styleProperty().bind(scdDigitTF.styleProperty());

               isNotValidLB.setText("Verification code is not valid !");
            }

        }

    }


    public static void setRegisteredEmployee(RegisteredEmployee registeredEmployee) {
        VerifyRegistrationTokenController.registeredEmployee = registeredEmployee;
    }

}

