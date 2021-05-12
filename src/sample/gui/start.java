package sample.gui;

/**
 * @author Bedam Queda, Erasmus
 * @version 04/05/2021
 * Classe Star, chamar interface que utilizador precisa ver "Classe Board"
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class start extends Application {
    /**
     * Launches the application
     * @param args the command line arguments passed to the application
     */

    public static void main(String[] args) {
        Application.launch(args);
    }


    /**
     * Shows the stage containing the Chess game
     * @param primaryStage Stage that will contain the scene which contains the game board
     */
    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("Bedam Queda: Chess Game");
        Board board = new Board();
        Scene scene = new Scene(board);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
