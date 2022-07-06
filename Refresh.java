import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Refresh extends Application {

    public Refresh() throws Exception {
        start(new Stage());
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane borderPane1 = new BorderPane();
        Pane pane1 = new Pane();
        VBox vBox = new VBox();
        Label label = new Label("حرف مورد نظر برای دور بعد را وارد کنید");
        TextField textField = new TextField();
        vBox.getChildren().addAll(label, textField);

        Button nextR = new Button("Next Round");
        pane1.getChildren().add(nextR);
        nextR.setAlignment(Pos.BOTTOM_CENTER);
        borderPane1.setCenter(nextR);
        pane1.getChildren().add(vBox);
        borderPane1.setTop(vBox);

        Scene scene = new Scene(borderPane1,600,600);
        primaryStage.setScene(scene);
        primaryStage.show();
        nextR.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (textField.getCharacters().length()!=1) {
                    Alert alert = new Alert(Alert.AlertType.WARNING, "لطفا یک کاراکتر فارسی معتبر وارد کنید");
                    alert.show();
                }
                char newW = textField.getCharacters().charAt(0);
                int sw = 0;
                for (int i = 0; i < Main.roundsPlayed + 1; i++) {
                    if (newW == Main.wordsUsed[i]) {
                        sw = 1;
                        break;
                    }
                }
                if (sw == 1) {
                    Alert alert = new Alert(Alert.AlertType.ERROR,"لطفا حرف غیر تکراری وارد کنید");
                    alert.show();
                }
                else {
                    GamePage.WordToPlay = newW;
                    Main.wordsUsed[Main.roundsPlayed] = GamePage.WordToPlay;
                    Main.roundsPlayed++;
                    for (int i = 0; i < CheckWords.answers.size();) {
                        CheckWords.answers.remove(i);
                    }
                    primaryStage.close();
                }
                System.out.println("Resting Time");
            }
        });

    }
}
