package sample.model;

/**
 * @author Bedam Queda
 * @version 06/06/2021
 */

import java.util.List;

/**4º
 * Generic Piece
 */
public abstract class Piece
{
    protected BoardModel board;
    protected PieceColor pieceColor;
    private Position position;

    /**
     * Constructor
     * @param board Game model
     * @param pieceColor Piece color
     * @param position Position in the game model board
     */
    public Piece(BoardModel board, PieceColor pieceColor, Position position)
    {
        this.board = board;
        this.pieceColor = pieceColor;
        this.position = position;
    }

    /**
     * Returns the current Position
     * @return Position (row an column coordinates)
     */
    public abstract Position getPosition();

    /**
     * Returns the color and type of the piece
     * @return A string containing the color and type of the piece
     */
    public abstract String getColorAndType();

    /**
     * Returns all the possible moves considering the current Position
     * @return A list of Positions
     */
    public abstract List<Position> possibleMoves();

    /**
     * Returns all the possible takes considering the current Position
     * @return A list of Positions
     */
    public abstract List<Position> possibleTakes();

    /**
     * Returns the Piece Color
     * @return Piece color
     */
    public abstract PieceColor getColor();

    /**
     * Returns the piece type
     * @return A string containing the piece type
     */
    public abstract String getType();

    /**
     * Changes the current position
     * @param position Position to change to
     */
    public abstract void setPosition(Position position);

    /**
     * Returns the move done by the piece considering the game board coordinates
     * @param begin Position before moving
     * @param end Position after moving
     * @return A string containing the ending position translated to the board coordinates
     */

    public abstract String movementText(Position begin, Position end);
}
