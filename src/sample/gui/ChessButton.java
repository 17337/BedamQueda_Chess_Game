package sample.gui;

/**
 * @author Bedam Queda
 * @version 04/05/2021
 */

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

/**
 * 2º
 * Button type for the chess game, cria botão com os respectivos imagens
 */
public class ChessButton extends Button {


    private final ImageView imageView;
    /**
     * Constructor
     */

    public ChessButton()
    {
        this.imageView = new ImageView("/sample/resources/EMPTY.png");
        this.setGraphic(imageView);
        this.setPrefSize(70, 70);
    }
}

