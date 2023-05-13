package prj.cardealershipnew;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import prj.cardealershipnew.databaseConnection.DBConnection;
import prj.cardealershipnew.projectUtils.AlertBox;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class Main extends Application  {



    AlertBox altbx = new AlertBox();
    private static final String dbUsername = "root";     // database username
    private static final String dbPassword = "toor@DB2021"; // database password
    private static final String URL = "127.0.0.1"; // server location
    private static final String port = "3306"; // port that mysql uses
    private static final String dbName = "finalcardealershipdb"; // database on mysql to connect to

    private static Connection connect;

    private static Stage primaryStage = new Stage();


    @Override
    public void start(Stage stage) throws IOException {

        try {
            DBConnection dbConnect = new DBConnection(URL, port, dbName, dbUsername, dbPassword);
            connect = dbConnect.connectDB();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            altbx.displayPopUp("Please Check database Connection","No Connection",2);
            System.exit(3);
        }



        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/authResources/loginPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 648, 496);


        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();



    }


    public static void main(String[] args) {
        launch();

    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void setPrimaryStage(Stage primaryStage) {
        Main.primaryStage = primaryStage;
    }

    public static Connection getConnect() {
        return connect;
    }

    public static void setConnect(Connection connect) {
        Main.connect = connect;
    }
}