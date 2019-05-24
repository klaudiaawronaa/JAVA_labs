import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerTwo extends ControllerOne implements Initializable {

    @FXML
    private Button add;
    @FXML
    private ChoiceBox priority;
    @FXML
    private TextArea description;
    @FXML
    private TextField title;
    @FXML
    private DatePicker expDate;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<String> choiceBoxList = new ArrayList<>();
        choiceBoxList.add("High");
        choiceBoxList.add("Medium");
        choiceBoxList.add("Low");
        ObservableList choiceBoxListProper = FXCollections.observableList(choiceBoxList);
        priority.getItems().clear();
        priority.setItems(choiceBoxListProper);

    }

    public void add(ActionEvent actionEvent) throws Exception {

        Stage stage = (Stage) add.getScene().getWindow();
        stage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene((Pane) loader.load(), 684, 489));
        stage.setTitle("Kanban");
        ControllerOne controller = loader.<ControllerOne>getController();


        controller.append(new Task(title.getText(), description.getText(),
                priority.getSelectionModel().getSelectedItem().toString(), expDate.getValue(), "To do"));

        stage.show();

    }
}
