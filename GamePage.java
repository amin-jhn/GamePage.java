import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.ArrayList;

public class GamePage extends Application {

    public static int numberOfItems;
    static ArrayList<ToggleButton> buttons = new ArrayList<ToggleButton>();
    static int[] chosenOne = new int[11];
    static char WordToPlay;
    static int round;
    static int roundsPassed;
    
    public GamePage() throws Exception {
        start(new Stage());
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        roundsPassed=0;
        BorderPane bPane = new BorderPane();
        Pane pane = new Pane();
        VBox hBox = new VBox();
        Label label = new Label("حرف مورد نظر را برای شروع بازی وارد کنید");
        Label label2 = new Label("تعداد دور های مد نظر را برای شروع بازی وارد کنید");
        TextField textField = new TextField();
        TextField rounds = new TextField();
        hBox.getChildren().addAll(label, textField);
        hBox.getChildren().addAll(label2, rounds);
        pane.getChildren().add(hBox);
        bPane.setTop(hBox);
        TilePane tilePane = new TilePane();
        buttonInit(tilePane);
        Button start = new Button("START");

        start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                checkItems();
                if (textField.getCharacters().length()!=1) {
                    Alert alert = new Alert(Alert.AlertType.WARNING, "لطفا یک کاراکتر فارسی معتبر وارد کنید");
                    alert.show();
                }
                else if (numberOfItems < 5) {
                    Alert alert = new Alert(Alert.AlertType.WARNING,"حداقل 5 مورد را انتخاب کنید");
                    alert.show();
                }
                else if (rounds.getCharacters().length() != 1
                        || rounds.getCharacters().charAt(0) > 57
                            || rounds.getCharacters().charAt(0) < 49){
                                Alert alert = new Alert(Alert.AlertType.WARNING, "لطفا عددی مناسب وارد کنید");
                                alert.show();
                }
                else {
                    try {
                        round = Integer.parseInt(String.valueOf(rounds.getCharacters().charAt(0)));
                        WordToPlay = textField.getCharacters().charAt(0);
                        Main.wordsUsed[Main.roundsPlayed] = WordToPlay;
                        Main.roundsPlayed++;
                        new GameBoard();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        pane.getChildren().add(start);
        pane.getChildren().add(tilePane);
        tilePane.setHgap(30);
        tilePane.setAlignment(Pos.CENTER);
        bPane.setCenter(tilePane);
        bPane.setBottom(start);

        start.setMinSize(800,100);

        Scene scene = new Scene(bPane,800,800);
        primaryStage.setOnCloseRequest(event -> System.out.println("Closing..."));
        primaryStage.setScene(scene);
        primaryStage.setTitle("سلام");
        primaryStage.show();
    }

    public void buttonInit(TilePane stackPane){
        ToggleButton t1 = new ToggleButton("اسم");
        ToggleButton t2 = new ToggleButton("فامیل");
        ToggleButton t3 = new ToggleButton("میوه");
        ToggleButton t4 = new ToggleButton("حیوان");
        ToggleButton t5 = new ToggleButton("شهر");
        ToggleButton t6 = new ToggleButton("کشور");
        ToggleButton t7 = new ToggleButton("ماشین");
        ToggleButton t8 = new ToggleButton("غذا");
        ToggleButton t9 = new ToggleButton("پوشاک");
        ToggleButton t10 = new ToggleButton("گل");
        ToggleButton t11 = new ToggleButton("اشیا");

        t1.setMinSize(100,100);
        t2.setMinSize(100,100);
        t3.setMinSize(100,100);
        t4.setMinSize(100,100);
        t5.setMinSize(100,100);
        t6.setMinSize(100,100);
        t7.setMinSize(100,100);
        t8.setMinSize(100,100);
        t9.setMinSize(100,100);
        t10.setMinSize(100,100);
        t11.setMinSize(100,100);

        stackPane.getChildren().add(t1);
        stackPane.getChildren().add(t2);
        stackPane.getChildren().add(t3);
        stackPane.getChildren().add(t4);
        stackPane.getChildren().add(t5);
        stackPane.getChildren().add(t6);
        stackPane.getChildren().add(t7);
        stackPane.getChildren().add(t8);
        stackPane.getChildren().add(t9);
        stackPane.getChildren().add(t10);
        stackPane.getChildren().add(t11);

        buttons.add(t1);
        buttons.add(t2);
        buttons.add(t3);
        buttons.add(t4);
        buttons.add(t5);
        buttons.add(t6);
        buttons.add(t7);
        buttons.add(t8);
        buttons.add(t9);
        buttons.add(t10);
        buttons.add(t11);
    }

    public void checkItems() {
        numberOfItems = 0;
        int count = 0;
        for (int i = 0; i < buttons.size(); i++) {
            if (buttons.get(i).isSelected()) {
                numberOfItems++;
                chosenOne[count] = i;
                count++;
            }
        }
    }
}
