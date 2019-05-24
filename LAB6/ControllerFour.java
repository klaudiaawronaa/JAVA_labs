import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.time.LocalTime;
import java.util.ResourceBundle;

public class ControllerFour implements Initializable {
    @FXML private RadioButton option1;
    @FXML private RadioButton option2;
    @FXML private Button moveButton;

    private Task task;


    public void initialize(URL location, ResourceBundle resources) {
        final ToggleGroup group = new ToggleGroup();
        option1.setToggleGroup(group);
        option2.setToggleGroup(group);
    }






    public void move(Task task) throws Exception{
        this.task = task;

        if (task.getOrigin() == "To do") {
            option1.setText("In progress");
            option2.setText("Done");
        }
        else if (task.getOrigin() == "In progress") {
            option1.setText("To do");
            option2.setText("Done");
        }
        else if (task.getOrigin() == "Done") {
            option1.setText("To do");
            option2.setText("In progress");
        }

    }

    public void doneMoving(ActionEvent actionEvent) throws Exception {
        if (option1.isSelected()) task.setOrigin(option1.getText());
        else if (option2.isSelected()) task.setOrigin(option2.getText());

        Stage stage = (Stage) moveButton.getScene().getWindow();
        stage.close();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene((Pane) loader.load(), 684, 489));
        stage.setTitle("Kanban");
        ControllerOne controller = loader.<ControllerOne>getController();


        controller.append(task);

        stage.show();
    }
}
