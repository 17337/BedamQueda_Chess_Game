package sample.gui;

/**
 * @author Bedam Queda
 * @version 04/05/2021
 */



import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
public class ChessButton extends Button {


    private final ImageView imageView;

    public ChessButton()
    {
        this.imageView = new ImageView("/resources/EMPTY.png");
        this.setPrefSize(70, 70);
    }
}

