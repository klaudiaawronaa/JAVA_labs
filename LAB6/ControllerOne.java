import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ControllerOne {

    public static ObservableList<Task> toDo = FXCollections.observableArrayList();
    public static ObservableList<Task> inProgress = FXCollections.observableArrayList();
    public static ObservableList<Task> done = FXCollections.observableArrayList();

    public static Scene scene;

    @FXML
    public Button button2;
    @FXML
    protected TableView toDoTable;
    @FXML
    protected TableView inProgressTable;
    @FXML
    protected TableView doneTable;
    @FXML
    private TableColumn toDoColumn;
    @FXML
    private TableColumn inProgressColumn;
    @FXML
    private TableColumn doneColumn;

    public void addNewTask(ActionEvent actionEvent) throws Exception {

        Stage stage = (Stage) button2.getScene().getWindow();
        stage.close();
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "sample2.fxml"
                )
        );
        stage = new Stage();
        stage.setScene(new Scene((Pane) loader.load(), 684, 489));
        stage.setTitle("Add Task");
        stage.show();

    }

    public void append(Task task) {

        toDoColumn.setCellValueFactory(new PropertyValueFactory<Task, String>("title"));
        inProgressColumn.setCellValueFactory(new PropertyValueFactory<Task, String>("title"));
        doneColumn.setCellValueFactory(new PropertyValueFactory<Task, String>("title"));


        toDoColumn.setCellFactory
                (
                        column ->
                        {
                            return new TableCell<Task, String>() {
                                @Override
                                protected void updateItem(String item, boolean empty) {
                                    if (item != null) {
                                        super.updateItem(item, empty);
                                        setText(item);
                                        setTooltip(new Tooltip("Title: " + getTableRow().getItem().getTitle() +
                                                "\nPriority: " + getTableRow().getItem().getPriority() +
                                                "\nExpiration Date: " + getTableRow().getItem().getExpDate() +
                                                "\nDescription: " + getTableRow().getItem().getDescription()));

                                        ContextMenu cm = new ContextMenu();
                                        MenuItem edit = new MenuItem("Edit");
                                        edit.setOnAction(new EventHandler<ActionEvent>() {
                                            @Override
                                            public void handle(ActionEvent t) {
                                                try {
                                                    edit(task);
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                }
                                            }
                                        });
                                        cm.getItems().add(edit);

                                        MenuItem delete = new MenuItem("Delete");
                                        delete.setOnAction(new EventHandler<ActionEvent>() {
                                            @Override
                                            public void handle(ActionEvent t) {

                                                try {
                                                    remove(task);
                                                } catch (Exception e) {
                                                }

                                            }
                                        });
                                        cm.getItems().add(delete);


                                        MenuItem move = new MenuItem("Move");
                                        move.setOnAction(new EventHandler<ActionEvent>() {
                                            @Override
                                            public void handle(ActionEvent t) {

                                                try {
                                                    moveTask(task);
                                                } catch (Exception e) {
                                                }

                                            }
                                        });
                                        cm.getItems().add(move);

                                        addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                                            @Override
                                            public void handle(MouseEvent t) {
                                                if (t.getButton() == MouseButton.SECONDARY) {
                                                    cm.show(toDoTable, t.getScreenX(), t.getScreenY());
                                                }
                                            }
                                        });

                                    }
                                }
                            };
                        });

        inProgressColumn.setCellFactory
                (
                        column ->
                        {
                            return new TableCell<Task, String>() {
                                @Override
                                protected void updateItem(String item, boolean empty) {
                                    if (item != null) {
                                        super.updateItem(item, empty);
                                        setText(item);
                                        setTooltip(new Tooltip("Title: " + getTableRow().getItem().getTitle() +
                                                "\nPriority: " + getTableRow().getItem().getPriority() +
                                                "\nExpiration Date: " + getTableRow().getItem().getExpDate() +
                                                "\nDescription: " + getTableRow().getItem().getDescription()));

                                        ContextMenu cm = new ContextMenu();
                                        MenuItem edit = new MenuItem("Edit");
                                        edit.setOnAction(new EventHandler<ActionEvent>() {
                                            @Override
                                            public void handle(ActionEvent t) {
                                                try {
                                                    edit(task);
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                }
                                            }
                                        });
                                        cm.getItems().add(edit);

                                        MenuItem delete = new MenuItem("Delete");
                                        delete.setOnAction(new EventHandler<ActionEvent>() {
                                            @Override
                                            public void handle(ActionEvent t) {

                                                try {
                                                    remove(task);
                                                } catch (Exception e) {
                                                }

                                            }
                                        });
                                        cm.getItems().add(delete);

                                        MenuItem move = new MenuItem("Move");
                                        move.setOnAction(new EventHandler<ActionEvent>() {
                                            @Override
                                            public void handle(ActionEvent t) {

                                                try {
                                                    moveTask(task);
                                                } catch (Exception e) {
                                                }

                                            }
                                        });
                                        cm.getItems().add(move);


                                        addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                                            @Override
                                            public void handle(MouseEvent t) {
                                                if (t.getButton() == MouseButton.SECONDARY) {
                                                    cm.show(toDoTable, t.getScreenX(), t.getScreenY());
                                                }
                                            }
                                        });

                                    }
                                }
                            };
                        });

        doneColumn.setCellFactory
                (
                        column ->
                        {
                            return new TableCell<Task, String>() {

                                @Override
                                protected void updateItem(String item, boolean empty) {
                                    if (item != null) {
                                        super.updateItem(item, empty);
                                        setText(item);
                                        setTooltip(new Tooltip("Title: " + getTableRow().getItem().getTitle() +
                                                "\nPriority: " + getTableRow().getItem().getPriority() +
                                                "\nExpiration Date: " + getTableRow().getItem().getExpDate() +
                                                "\nDescription: " + getTableRow().getItem().getDescription()));

                                        ContextMenu cm = new ContextMenu();
                                        MenuItem edit = new MenuItem("Edit");
                                        edit.setOnAction(new EventHandler<ActionEvent>() {
                                            @Override
                                            public void handle(ActionEvent t) {
                                                try {
                                                    edit(task);
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                }
                                            }
                                        });
                                        cm.getItems().add(edit);

                                        MenuItem delete = new MenuItem("Delete");
                                        delete.setOnAction(new EventHandler<ActionEvent>() {
                                            @Override
                                            public void handle(ActionEvent t) {

                                                try {
                                                    remove(task);
                                                } catch (Exception e) {
                                                }

                                            }
                                        });
                                        cm.getItems().add(delete);

                                        MenuItem move = new MenuItem("Move");
                                        move.setOnAction(new EventHandler<ActionEvent>() {
                                            @Override
                                            public void handle(ActionEvent t) {

                                                try {
                                                    moveTask(task);
                                                } catch (Exception e) {
                                                }

                                            }
                                        });
                                        cm.getItems().add(move);


                                        addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                                            @Override
                                            public void handle(MouseEvent t) {
                                                if (t.getButton() == MouseButton.SECONDARY) {
                                                    cm.show(toDoTable, t.getScreenX(), t.getScreenY());
                                                }
                                            }
                                        });



                                    }
                                }
                            };
                        });


        if (task.getOrigin() == "To do") toDo.add(task);
        else if (task.getOrigin() == "In progress") inProgress.add(task);
        else if (task.getOrigin() == "Done") done.add(task);

        toDoTable.setItems(toDo);
        inProgressTable.setItems(inProgress);
        doneTable.setItems(done);

    }

    public void remove(Task task) throws Exception {


        /*Stage stage = (Stage) toDoTable.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        stage.setScene(new Scene((Pane) loader.load(), 684, 489));
        stage.setTitle("Kanban");*/

        if (task.getOrigin() == "To do") toDo.remove(task);
        else if (task.getOrigin() == "In progress") inProgress.remove(task);
        else if (task.getOrigin() == "Done") done.remove(task);
        toDoTable.setItems(toDo);

        Stage stage = (Stage) toDoTable.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        stage.setScene(new Scene((Pane) loader.load(), 684, 489));
        stage.setTitle("Kanban");

        stage.show();
    }


    public void edit(Task task) throws Exception {

        if (task.getOrigin() == "To do") toDo.remove(task);
        else if (task.getOrigin() == "In progress") inProgress.remove(task);
        else if (task.getOrigin() == "Done") done.remove(task);

        Stage stage = (Stage) toDoTable.getScene().getWindow();
        stage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample3.fxml"));
        stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene((Pane) loader.load(), 684, 489));
        stage.setTitle("Edit Task");
        ControllerThree controller = loader.<ControllerThree>getController();
        controller.passOldData(task.getTitle(), task.getPriority(), task.getExpDate(), task.getDescription(), task.getOrigin());

        stage.show();
    }

    public void moveTask(Task task) throws Exception{

        if(task.getOrigin() == "To do") toDo.remove(task);
        else if (task.getOrigin() == "In progress") inProgress.remove(task);
        else if (task.getOrigin() == "Done") done.remove(task);


        Stage stage = (Stage) toDoTable.getScene().getWindow();
        stage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample4.fxml"));
        stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene((Pane) loader.load(), 250, 100));
        stage.setTitle("Move Task");
        ControllerFour controller = loader.<ControllerFour>getController();
        controller.move(task);
        stage.show();





    }
}