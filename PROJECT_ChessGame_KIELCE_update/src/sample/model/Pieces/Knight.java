package sample.model.Pieces;

/**
 * @author Bedam Queda, Erasmus
 * @version 06/06/2021
 */

import sample.model.BoardModel;
import sample.model.Piece;
import sample.model.PieceColor;
import sample.model.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**4º
 * Knight type Piece
 */
public class Knight extends Piece
{
    private Position position;
    private String colorAndType;
    private List<Position> possibleTakes;

    /**
     * Constructor
     * @param board Game model
     * @param pieceColor Piece color
     * @param position Position in the game model board
     */
    public Knight(BoardModel board, PieceColor pieceColor, Position position) {
        super(board, pieceColor, position);
        this.position = position;
        this.colorAndType = pieceColor.toString() + "_KNIGHT";
    }

    /**
     * Returns all the possible moves considering the current Position.
     * Taken from: https://www.techiedelight.com/print-possible-knights-tours-chessboard/
     * @return A list of Positions
     */
    @Override
    public List<Position> possibleMoves()
    {
        List<Position> possibleMoves = new ArrayList<>();
        this.possibleTakes = new ArrayList<>();
        int row[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int col[] = {1, 2, 2, 1, -1, -2, -2, -1};

        for (int i = 0; i < row.length; i++)
        {
            if (super.board.inBounds(this.position.getRow() + row[i], this.position.getCol() + col[i]))
            {
                Piece piece = super.board.getPiece(this.position.getRow() + row[i], this.position.getCol() + col[i]);
                if (Objects.isNull(piece))
                {
                    possibleMoves.add(new Position(this.position.getRow() + row[i], this.position.getCol() + col[i]));
                }
                else if (piece.getColor() != this.getColor() && piece.getType() != "KING")
                {
                    this.possibleTakes.add(piece.getPosition());
                }
            }
        }

        return possibleMoves;
    }

    /**
     * Returns all the possible takes considering the current Position
     * @return A list of Positions
     */
    @Override
    public List<Position> possibleTakes()
    {
        return this.possibleTakes;
    }

    /**
     * Returns the Piece Color
     * @return Piece color
     */
    @Override
    public PieceColor getColor()
    {
        return this.pieceColor;
    }

    /**
     * Returns the piece type
     * @return A string containing the piece type
     */
    @Override
    public String getType()
    {
        return "KNIGHT";
    }

    /**
     * Changes the current position
     * @param position Position to change to
     */
    @Override
    public void setPosition(Position position)
    {
        this.position = position;
    }

    /**
     * Returns the move done by the piece considering the game board coordinates
     * @param begin Position before moving
     * @param end Position after moving
     * @return A string containing the ending position translated to the board coordinates
     */
    @Override
    public String movementText(Position begin, Position end)
    {
        return "C" + super.board.getColCoordinates(end.getCol()) + super.board.getRowCoordinates(end.getRow());
    }

    /**
     * Returns the current Position
     * @return Position (row an column coordinates)
     */
    public Position getPosition()
    {
        return position;
    }

    /**
     * Returns the color and type of the piece
     * @return A string containing the color and type of the piece
     */
    public String getColorAndType()
    {
        return colorAndType;
    }
}
