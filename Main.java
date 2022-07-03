import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane borderPane = new BorderPane();
        Pane pane = new Pane();
        HBox hBox = new HBox();

        initBottomPanel(hBox);

        hBox.setSpacing(20);
        pane.getChildren().add(hBox);
        hBox.setAlignment(Pos.BOTTOM_CENTER);
        borderPane.setCenter(hBox);

        Scene scene = new Scene(borderPane,800,800);
        primaryStage.setOnCloseRequest(event -> System.out.println("Closing..."));
        primaryStage.setScene(scene);
        primaryStage.setTitle("سلام");
        primaryStage.show();
    }

    public void initBottomPanel(HBox hBox) {
        Button b1 = new Button("HOST");
        Button b2 = new Button("CLIENT");

        b1.setMinSize(300,100);
        b2.setMinSize(300,100);

        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hosting game...");
                try {
                    new GamePage();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        b2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Joining game...");
            }
        });

        hBox.getChildren().add(b1);
        hBox.getChildren().add(b2);
    }
}
