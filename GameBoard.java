import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;

public class GameBoard extends Application {

    static ArrayList <Label> labels = new ArrayList<>();
    static ArrayList <TextField> textFields = new ArrayList<>();

    public GameBoard() throws Exception {
        start(new Stage());
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane borderPane = new BorderPane();
        Pane pane = new Pane();
        VBox hBox = new VBox();

        for (int i = 0; i < GamePage.numberOfItems; i++) {
            TextField textField = new TextField();
            Label label = new Label();
            switch (GamePage.chosenOne[i]) {
                case 0:
                    label.setText("اسم");
                    break;
                case 1:
                    label.setText("فامیل");
                    break;
                case 2:
                    label.setText("میوه");
                    break;
                case 3:
                    label.setText("حیوان");
                    break;
                case 4:
                    label.setText("شهر");
                    break;
                case 5:
                    label.setText("کشور");
                    break;
                case 6:
                    label.setText("ماشین");
                    break;
                case 7:
                    label.setText("غذا");
                    break;
                case 8:
                    label.setText("پوشاک");
                    break;
                case 9:
                    label.setText("گل");
                    break;
                case 10:
                    label.setText("اشیا");
                    break;
            }
            labels.add(label);
            textFields.add(textField);
            textField.setEditable(true);
            label.setAlignment(Pos.CENTER_RIGHT);
            hBox.getChildren().addAll(label,textField);
        }
        pane.getChildren().add(hBox);
        borderPane.setCenter(hBox);
        Scene scene = new Scene(borderPane,800,800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}