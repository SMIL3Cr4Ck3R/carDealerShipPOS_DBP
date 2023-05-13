package prj.cardealershipnew.salesman;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class AboutUsController {

    @FXML
    void closeButtonAction(ActionEvent event) {

        ButtonsScene.AboutUs.getAboutStage().close();

    }

}
