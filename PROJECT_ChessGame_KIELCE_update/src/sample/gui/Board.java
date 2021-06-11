package sample.gui;

/**
 * @author Bedam Queda, Erasmus
 * @version 06/06/2021
 * Classe Board define como vai funcionar o interface gráfica
 */

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import sample.View;
import sample.model.BoardModel;
import sample.model.Position;
import java.util.List;
import java.util.Objects;

/**
 * Class responsible for the graphic user interface for the chess game(controller)
 */
public class Board extends VBox implements View
{
    private final BoardModel GAME_MODEL;
    private ChessButton[][] buttons;
    private GridPane board;
    private int color;
    private BackgroundFill fillColor;
    private BorderPane borderPane;
    private final Label[] numbersCoordinates;
    private final Label[] numbersCoordinates2;
    private Label[] lettersCoordinates;
    private Label[] lettersCoordinates2;


    /**
     * Constructor
     * which displays the numbers and letters around the board (graphical interface)
     * que apresenta os números e as letras em volta do tabuleiro (interface gráfica)
     */
    public Board()
    {
        this.board = new GridPane();
        this.borderPane = new BorderPane();
        this.buttons = new ChessButton[8][8];
        this.lettersCoordinates = new Label[]{new Label("a"), new Label("b"),new Label("c"),
                new Label("d"), new Label("e"), new Label("f"), new Label("g"),
                new Label("h")};
        this.numbersCoordinates = new Label[]{new Label("8"), new Label("7"),new Label("6"),
                new Label("5"), new Label("4"), new Label("3"), new Label("2"),
                new Label("1")};
        this.lettersCoordinates2 = new Label[]{new Label("a"), new Label("b"),new Label("c"),
                new Label("d"), new Label("e"), new Label("f"), new Label("g"),
                new Label("h")};
        this.numbersCoordinates2 = new Label[]{new Label("8"), new Label("7"),new Label("6"),
                new Label("5"), new Label("4"), new Label("3"), new Label("2"),
                new Label("1")};
        this.createBoard();
        this.GAME_MODEL = new BoardModel(this);
        this.color = 0;
        this.getChildren().addAll(this.board);
    }

    /**
     * 2º
     * Creates the game board with a grid of ChessButtons, Cria o tabuleiro de jogo com uma grelha de ChessButtons
     */
    private void createBoard()
    {
        ChessButtonHandler handler = new ChessButtonHandler();

        for (int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                ChessButton button = new ChessButton();
                this.buttons[i][j] = button;
                this.fillColor = this.color % 2 == 0 ? new BackgroundFill(Color.WHITE, null, null) :
                        new BackgroundFill(Color.TAN, null, null);
                button.setBackground(new Background(this.fillColor, null, null));
                button.setOnAction(handler);
                this.board.getChildren().addAll(button);
                /**
                 * 2º
                 * Define as posições dos botões //Sets the button positions
                 */
                GridPane.setRowIndex(button, i + 1);
                GridPane.setColumnIndex(button, j + 1);
                color++;
            }
            color++;
        }

        this.setCoordinatesLabels();
    }

    /**4º
     * Sets the button image given the piece's coordinates, color and type
     * @param row Row coordinate
     * @param col Column coordinate
     * @param colorAndType Color and type of the of the piece
     */
    /**
     * Pions
     */
    @Override
    public void setButtonImage(int row, int col, String colorAndType)
    {
        switch (colorAndType)
        {
            case "BLACK_BISHOP":
                this.buttons[row][col].setBlackBishop();
                break;
            case "BLACK_KING":
                this.buttons[row][col].setBlackKing();
                break;
            case "BLACK_KNIGHT":
                this.buttons[row][col].setBlackKnight();
                break;
            case "BLACK_PAWN":
                this.buttons[row][col].setBlackPawn();
                break;
            case "BLACK_QUEEN":
                this.buttons[row][col].setBlackQueen();
                break;
            case "BLACK_ROOK":
                this.buttons[row][col].setBlackRook();
                break;
            case "WHITE_BISHOP":
                this.buttons[row][col].setWhiteBishop();
                break;
            case "WHITE_KING":
                this.buttons[row][col].setWhiteKing();
                break;
            case "WHITE_KNIGHT":
                this.buttons[row][col].setWhiteKnight();
                break;
            case "WHITE_PAWN":
                this.buttons[row][col].setWhitePawn();
                break;
            case "WHITE_QUEEN":
                this.buttons[row][col].setWhiteQueen();
                break;
            case "WHITE_ROOK":
                this.buttons[row][col].setWhiteRook();
                break;
            default:
                this.buttons[row][col].setEmpty();
        }
    }

    /**4º
     * Shows the possible moves and takes for a certain piece
     * @param possibleMoves List of valid moves for a certain piece
     * @param possibleTakes List of valid takes for a certain piece
     */
    @Override
    public void showPossibleMovesAndTakes(List<Position> possibleMoves, List<Position> possibleTakes)
    {
        if (Objects.nonNull(possibleMoves))
        {
            for (Position pos : possibleMoves)
            {
                this.buttons[pos.getRow()][pos.getCol()].setStyle("-fx-border-color: green; -fx-border-width: 5");
            }
        }

        if (Objects.nonNull(possibleTakes))
        {
            for (Position pos : possibleTakes)
            {
                this.buttons[pos.getRow()][pos.getCol()].setStyle("-fx-border-color: yellow; -fx-border-width: 5");
            }
        }
    }

    /**4º
     * Hides the possible moves
     */
    @Override
    public void hidePossibleMovesOrTakes()
    {
        for (ChessButton[] buttons : this.buttons)
        {
            for (ChessButton button : buttons)
            {
                button.setStyle(null);
            }
        }
    }

    /**
     * unchange
     * Sets the coordinates labels around the game board // Define os rótulos de coordenadas à volta do tabuleiro de jogo
     */
    private void setCoordinatesLabels()
    {
        for (int i = 0; i < this.lettersCoordinates.length; i++)
        {
            this.lettersCoordinates[i].setPrefSize(70, 10);
            this.lettersCoordinates[i].setStyle("-fx-font-size: 15");
            this.lettersCoordinates[i].setAlignment(Pos.TOP_CENTER);
            this.lettersCoordinates2[i].setPrefSize(70, 10);
            this.lettersCoordinates2[i].setStyle("-fx-font-size: 15");
            this.lettersCoordinates2[i].setAlignment(Pos.BOTTOM_CENTER);
            this.numbersCoordinates2[i].setPrefSize(10, 70);
            this.numbersCoordinates2[i].setStyle("-fx-font-size: 15");
            this.numbersCoordinates2[i].setAlignment(Pos.CENTER_LEFT);
            this.numbersCoordinates[i].setPrefSize(10, 70);
            this.numbersCoordinates[i].setStyle("-fx-font-size: 15");
            this.numbersCoordinates[i].setAlignment(Pos.CENTER_RIGHT);

        }

        for (int i = 0; i < 8; i++)
        {
            this.board.add(this.lettersCoordinates[i], i + 1, 0);
            this.board.add(this.lettersCoordinates2[i], i + 1, 9);
            this.board.add(this.numbersCoordinates[i], 0, i + 1);
            this.board.add(this.numbersCoordinates2[i], 9, i + 1);
        }
    }

    /**4º
     * Click handler for the ChessButtons
     */
    private class ChessButtonHandler implements EventHandler<ActionEvent>
    {

        @Override
        public void handle(ActionEvent event) {
            ChessButton button = (ChessButton) event.getSource();
            int row = GridPane.getRowIndex(button);
            int col = GridPane.getColumnIndex(button);
            GAME_MODEL.pieceSelected(row - 1, col - 1);
        }
    }
}
