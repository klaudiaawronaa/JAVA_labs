package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadLocalRandom;

public class Controller implements Initializable {
    private static AsyncTask mathsTask;
    private static DrawerTask drawTask;
    @FXML
    private TextField resultTextField;
    @FXML
    private TextField iterTextField;
    @FXML
    private Canvas canvas;
    @FXML
    private ProgressBar progressBar;
    @FXML
    private Button runButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        resultTextField.setEditable(false);

        /*Dozwolone wyłącznie cyfry*/
        iterTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    iterTextField.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

    }


    public void run(ActionEvent actionEvent) {
        if (iterTextField.getText() == null || iterTextField.getText().trim().isEmpty()) return;

        drawTask = new DrawerTask();

        mathsTask = new AsyncTask(Long.parseLong(iterTextField.getText()));
        mathsTask.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                resultTextField.setText(Double.toString(mathsTask.getResult()));
            }
        });
        mathsTask.setOnCancelled(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                resultTextField.setText(Double.toString(mathsTask.getResult()));
            }
        });

        progressBar.progressProperty().bind(mathsTask.progressProperty());
        Thread thread = new Thread(mathsTask);
        Thread thread2 = new Thread(drawTask);
        thread.start();
        thread2.start();

    }

    public void stop(ActionEvent actionEvent) {
        if (mathsTask != null) mathsTask.cancel();
    }


    class AsyncTask extends Task {
        Random random = new Random();

        private long n;
        private double result, x, y, xProper, yProper, sum;


        AsyncTask(long n) {
            this.n = n;
        }

        @Override
        protected Object call() throws InterruptedException {

            for (int i = 0; i < n; i++) {
                Thread.sleep(0);
                x = -8 + (8 - (-8)) * random.nextDouble();
                y = -8 + (8 - (-8)) * random.nextDouble();
                if (Equation.calc(x, y)) {
                    sum++;
                    xProper = x;
                    yProper = y;
                }
                if (isCancelled()) break;
                updateProgress(i, n);
            }

            result = 16 * 16 * sum / n;
            return result;
        }


        public double getResult() {
            return result;
        }

    }


    class DrawerTask extends Task {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        BufferedImage bi = new BufferedImage(783, 397, BufferedImage.TYPE_INT_RGB);
        Color DARK_BLUE = new Color(0, 0, 180);

        @Override
        protected Object call() throws Exception {

            while (!mathsTask.isDone() && !mathsTask.isCancelled()) {

                bi.setRGB(bi.getWidth() / 2 + (int) (mathsTask.xProper * 20), bi.getHeight() / 2 + (int) ((mathsTask.yProper) * 20), Color.YELLOW.getRGB());
                bi.setRGB(bi.getWidth() / 2 + (int) (mathsTask.x * 20), bi.getHeight() / 2 + (int) ((mathsTask.y) * 20), DARK_BLUE.getRGB());

                //1 raz na 10 razy sie odświeży
                if (ThreadLocalRandom.current().nextInt(0, 10 + 1) < 1)
                    gc.drawImage(SwingFXUtils.toFXImage(bi, null), 0, 0);


            }
            return null;
        }
    }

}
