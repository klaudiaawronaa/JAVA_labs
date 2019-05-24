import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.time.LocalDate;
import java.time.LocalTime;


public class ControllerThree extends ControllerTwo {

    private String origin;
    @FXML
    private Button done;
    @FXML
    private ChoiceBox priority;
    @FXML
    private TextArea description;
    @FXML
    private TextField title;
    @FXML
    private DatePicker expDate;


    public void Done(ActionEvent actionEvent) throws Exception {
        Stage stage = (Stage) done.getScene().getWindow();
        stage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene((Pane) loader.load(), 684, 489));
        ControllerOne controller = loader.<ControllerOne>getController();


        controller.append(new Task(title.getText(), description.getText(),
                priority.getSelectionModel().getSelectedItem().toString(), expDate.getValue(), origin));

        stage.show();

    }

    public void passOldData(String title, String priority, LocalDate expDate, String description, String origin) {

        this.origin = origin;
        this.title.setText(title);

        if (priority == "High") this.priority.getSelectionModel().select(0);
        else if (priority == "Medium") this.priority.getSelectionModel().select(1);
        else this.priority.getSelectionModel().select(2);

        this.expDate.setValue(expDate);
        this.description.setText(description);



    }

}
