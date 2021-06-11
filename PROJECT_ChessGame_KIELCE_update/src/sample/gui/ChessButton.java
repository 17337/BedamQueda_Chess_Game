package sample.gui;

/**
 * @author Bedam Queda
 * @version 04/05/2021
 */

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**2º_4º
 * Button type for the chess game, cria botão com os respectivos imagens
 */
public class ChessButton extends Button
{
    private static final Image BLACK_PAWN = new Image("/sample/resources/BLACK_PAWN.png");
    private static final Image BLACK_KING = new Image("/sample/resources/BLACK_QUEEN.png");
    private static final Image BLACK_QUEEN = new Image("/sample/resources/BLACK_KING.png");
    private static final Image BLACK_BISHOP = new Image("/sample/resources/BLACK_BISHOP.png");
    private static final Image BLACK_KNIGHT = new Image("/sample/resources/BLACK_KNIGHT.png");
    private static final Image BLACK_ROOK = new Image("/sample/resources/BLACK_ROOK.png");
    private static final Image WHITE_PAWN = new Image("/sample/resources/WHITE_PAWN.png");
    private static final Image WHITE_KING = new Image("/sample/resources/WHITE_QUEEN.png");
    private static final Image WHITE_QUEEN = new Image("/sample/resources/WHITE_KING.png");
    private static final Image WHITE_BISHOP = new Image("/sample/resources/WHITE_BISHOP.png");
    private static final Image WHITE_KNIGHT = new Image("/sample/resources/WHITE_KNIGHT.png");
    private static final Image WHITE_ROOK = new Image("/sample/resources/WHITE_ROOK.png");
    private static final Image EMPTY = new Image("/sample/resources/EMPTY.png");
    private final ImageView imageView;

    /**
     * Constructor
     */
    public ChessButton()
    {
        this.imageView = new ImageView(EMPTY);
        this.setGraphic(imageView);
        this.setPadding(Insets.EMPTY);
        this.setPrefSize(70,   70);
    }

    /**
     * Sets the button image to 'BLACK_PAWN'
     */
    public void setBlackPawn()
    {
        this.imageView.setImage(BLACK_PAWN);
    }

    /**
     * Sets the button image to 'BLACK_KING'
     */
    public void setBlackKing()
    {
        this.imageView.setImage(BLACK_KING);
    }

    /**
     * Sets the button image to 'BLACK_QUEEN'
     */
    public void setBlackQueen()
    {
        this.imageView.setImage(BLACK_QUEEN);
    }

    /**
     * Sets the button image to 'BLACK_KNIGHT'
     */
    public void setBlackKnight()
    {
        this.imageView.setImage(BLACK_KNIGHT);
    }

    /**
     * Sets the button image to 'BLACK_BISHOP'
     */
    public void setBlackBishop()
    {
        this.imageView.setImage(BLACK_BISHOP);
    }

    /**
     * Sets the button image to 'BLACK_ROOK'
     */
    public void setBlackRook()
    {
        this.imageView.setImage(BLACK_ROOK);
    }

    /**
     * Sets the button image to 'WHITE_PAWN'
     */
    public void setWhitePawn()
    {
        this.imageView.setImage(WHITE_PAWN);
    }

    /**
     * Sets the button image to 'WHITE_KING'
     */
    public void setWhiteKing()
    {
        this.imageView.setImage(WHITE_KING);
    }

    /**
     * Sets the button image to 'WHITE_QUEEN'
     */
    public void setWhiteQueen()
    {
        this.imageView.setImage(WHITE_QUEEN);
    }

    /**
     * Sets the button image to 'WHITE_KNIGHT'
     */
    public void setWhiteKnight()
    {
        this.imageView.setImage(WHITE_KNIGHT);
    }

    /**
     * Sets the button image to 'WHITE_BISHOP'
     */
    public void setWhiteBishop()
    {
        this.imageView.setImage(WHITE_BISHOP);
    }

    /**
     * Sets the button image to 'WHITE_ROOK'
     */
    public void setWhiteRook()
    {
        this.imageView.setImage(WHITE_ROOK);
    }

    /**
     * Sets the button image to 'EMPTY'
     */
    public void setEmpty()
    {
        this.imageView.setImage(EMPTY);
    }

}
