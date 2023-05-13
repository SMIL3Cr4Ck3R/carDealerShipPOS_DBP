package prj.cardealershipnew.salesman;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import prj.cardealershipnew.Main;
import prj.cardealershipnew.projectUtils.InputDialog;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EmployeeDetailsController implements Initializable {


    private double x = 0;
    private double y = 0;

    @FXML
    private Label addressLb;

    @FXML
    private Label custDOB;

    @FXML
    private Label custName;

    @FXML
    private Label customNumber;

    @FXML
    private Label emailLB;

    @FXML
    private Label phoneNumber;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        try (PreparedStatement ps = Main.getConnect().prepareStatement("Select * from employee EMP where EMP.employeeID = ?")) {

            ps.setString(1,SalemanUIController.getCurrentLoggedInSM());
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                setNewTexts(rs.getString("employeeAddress"),String.valueOf(rs.getDate("DOB")),
                        rs.getString("employeeName"),rs.getString("employeeID"),rs.getString("emailAddr")
                        ,String.valueOf(rs.getInt("employeePhone")));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    public  void setNewTexts (String empAddress,String getDOB,String getEmpName,String getSalesmanID,String emailAddress,String getEmpPhone) {

        custName.setText(getEmpName);
        phoneNumber.setText(String.valueOf(getEmpPhone));
        addressLb.setText(empAddress);
        custDOB.setText(getDOB);
        customNumber.setText(getSalesmanID);
        emailLB.setText(emailAddress);

    }

    @FXML
    void editCustomerInfo(ActionEvent event) {


        try  ( PreparedStatement ps = Main.getConnect().prepareStatement("Select * from Employee where employeeID = ?");
               PreparedStatement psUpdated = Main.getConnect().prepareStatement("Select * from Employee where employeeID = ?")){

            ps.setString(1,SalemanUIController.getCurrentLoggedInSM());

            ResultSet rs = ps.executeQuery();

            if ( rs.next() ) {

                new InputDialog(5, new String[]{"Employee Name :","Phone Number:","Address :","Email :","Date Of Birth:"},

                        new String[]{rs.getString("employeeName"),String.valueOf(rs.getInt("employeePhone")),
                                rs.getString("employeeAddress"),rs.getString("emailAddr"), String.valueOf(rs.getDate("DOB"))},
                        'E',rs.getString("employeeID"));


                psUpdated.setString(1,SalemanUIController.getCurrentLoggedInSM());
                ResultSet rsUpdated = psUpdated.executeQuery();

                if(rsUpdated.next()) {
                    setNewTexts(rsUpdated.getString("employeeAddress"), String.valueOf(rsUpdated.getDate("DOB")),
                            rsUpdated.getString("employeeName"), rsUpdated.getString("employeeID"),
                            rsUpdated.getString("emailAddr"), String.valueOf(rsUpdated.getInt("employeePhone")));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }

    @FXML
    void exitButtonClicked(ActionEvent event) {

        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();

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
