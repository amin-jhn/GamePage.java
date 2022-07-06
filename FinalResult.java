import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FinalResult extends Application {

    public FinalResult() throws Exception {
        start(new Stage());
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane borderPane = new BorderPane();
        VBox vBox = new VBox();
        Pane pane = new Pane();

        String first;
        String sec;
        if (GameBoard.total >= ClientGameBoard.total) {
            first = "Winner is " + Main.HostName + " with score: " + GameBoard.total;
            sec = Main.ClientName + " score: " + ClientGameBoard.total;
        }
        else {
            first = Main.ClientName + " score: " + ClientGameBoard.total;
            sec = Main.HostName + " score: " + GameBoard.total;
        }
        Label label = new Label(first);
        Label label2 = new Label(sec);

        vBox.getChildren().addAll(label,label2);
        pane.getChildren().add(label);
        pane.getChildren().add(label2);
        pane.getChildren().add(vBox);
        borderPane.setCenter(vBox);
        Scene scene = new Scene(borderPane,800,800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
