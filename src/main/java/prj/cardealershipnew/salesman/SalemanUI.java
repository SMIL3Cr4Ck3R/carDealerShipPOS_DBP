package prj.cardealershipnew.salesman;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class SalemanUI {

    private static Stage salemanStage = new Stage();

    public  void buildUI() throws IOException {

        FXMLLoader loader = new FXMLLoader(SalemanUI.class.getResource("/salesmanUIResources/fxmls/salemanUI.fxml"));
        Scene salemanScene = new Scene(loader.load(), 985, 604, Color.TRANSPARENT);
         salemanStage.setScene(salemanScene);
         salemanStage.setResizable(true);
         salemanStage.initStyle(StageStyle.TRANSPARENT);
         salemanStage.setTitle("SalemanUI");
         salemanStage.show();



    }

    public static Stage getSalemanStage() {
        return salemanStage;
    }

}
