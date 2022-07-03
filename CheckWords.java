import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CheckWords {
    static String[] fileName = new String[11];
    static String[] addresses = new String[11];
    static boolean[] fortinyteEilaBabeji = new boolean[11];

    public static void checkWhichFile(ArrayList <Label> labels){
        for (int i = 0; i < labels.size() ; i++) {
            fileName[i] = labels.get(i).getText();
            System.out.println(fileName[i]);
        }
    }

    public static void urlMaker(){
        for (int i = 0; i < GameBoard.labels.size(); i++) {
            switch (fileName[i]) {
                case "اسم":
                    addresses[i] = "C:\\Users\\ACER\\Desktop\\P2\\words\\words\\اسم.txt";
                    break;
                case "فامیل":
                    addresses[i] = "C:\\Users\\ACER\\Desktop\\P2\\words\\words\\فامیل.txt";
                    break;
                case "حیوان":
                    addresses[i] = "C:\\Users\\ACER\\Desktop\\P2\\words\\words\\حیوان.txt";
                    break;
                case "میوه":
                    addresses[i] = "C:\\Users\\ACER\\Desktop\\P2\\words\\words\\میوه.txt";
                    break;
                case "شهر":
                    addresses[i] = "C:\\Users\\ACER\\Desktop\\P2\\words\\words\\شهر.txt";
                    break;
                case "کشور":
                    addresses[i] = "C:\\Users\\ACER\\Desktop\\P2\\words\\words\\کشور.txt";
                    break;
                case "پوشاک":
                    addresses[i] = "C:\\Users\\ACER\\Desktop\\P2\\words\\words\\پوشاک.txt";
                    break;
                case "اشیا":
                    addresses[i] = "C:\\Users\\ACER\\Desktop\\P2\\words\\words\\اشیا.txt";
                    break;
                case "ماشین":
                    addresses[i] = "C:\\Users\\ACER\\Desktop\\P2\\words\\words\\ماشین.txt";
                    break;
                case "گل":
                    addresses[i] = "C:\\Users\\ACER\\Desktop\\P2\\words\\words\\گل.txt";
                    break;
                case "غذا":
                    addresses[i] = "C:\\Users\\ACER\\Desktop\\P2\\words\\words\\غذا.txt";
                    break;
            }
            System.out.println(addresses[i]);
        }
    }

    public static void checkIfExist(ArrayList <TextField> textFields) throws FileNotFoundException {
        for (int i = 0; i < textFields.size(); i++) {
            String answer = textFields.get(i).getText();
            System.out.println(answer);
            File input = new File(addresses[i]);
            System.out.println(input.toURI());
            Scanner reader = new Scanner(input);
            while (reader.hasNextLine()) {
                String word = reader.nextLine();
                if (word.equals(answer) && answer.charAt(0) == GamePage.WordToPlay) {
                    fortinyteEilaBabeji[i] = true;
                    System.out.print(word + ":::");
                    break;
                }
                else if (answer.charAt(0) != GamePage.WordToPlay){
                    Alert alert = new Alert(Alert.AlertType.WARNING,fileName[i] + " با حرف نامناسب شروع شده است!");
                    alert.show();
                    break;
                }
                System.out.println(word + "+++");
            }
            System.out.println(fortinyteEilaBabeji[i]);
        }
    }

    public static void main(String[] args) {
        String st = "سلام";
        System.out.println(st.charAt(0));
        char c = 'a';
    }
}
