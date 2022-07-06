import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class Main extends Application {

    static String HostName;
    static int roundsPlayed = 0;
    static char[] wordsUsed = new char[100];
    static String ClientName;
    static boolean whoseTurn = true;                   //  true means host    false means client


    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane borderPane = new BorderPane();
        Pane pane = new Pane();
        HBox hBox = new HBox();
        Client client = new Client(new Socket("localhost",9999),"amin");

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
        TextField name = new TextField("Enter your name");
        hBox.getChildren().add(name);
        name.setAlignment(Pos.TOP_CENTER);

        b1.setMinSize(300,100);
        b2.setMinSize(300,100);

        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hosting game...");
                try {
                    HostName = name.getText();
                    Client client = new Client(new Socket("localhost",9999),name.getText());
                    Server.clients.add(client);
                } catch (IOException e) {
                    e.printStackTrace();
                }
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
                try {
                    ClientName = name.getText();
                    Client client = new Client(new Socket("localhost",9999),name.getText());
                    Server.clients.add(client);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    new ClientGameBoard();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        hBox.getChildren().add(b1);
        hBox.getChildren().add(b2);
    }

    public static void main(String[] args) {
        launch();
    }
}
