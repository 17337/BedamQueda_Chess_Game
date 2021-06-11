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


public class King extends Piece
{
    Position position;
    private String colorAndType;
    private List<Position> possibleTakes;

    /**4º
     * Constructor
     * @param board Game model
     * @param pieceColor Piece color
     * @param position Position in the game model board
     */
    public King(BoardModel board, PieceColor pieceColor, Position position)
    {
        super(board, pieceColor, position);
        this.position = position;
        this.colorAndType = pieceColor.toString() + "_KING";
    }

    /**
     * Returns the current Position
     * @return Position (row an column coordinates)
     */
    @Override
    public Position getPosition()
    {
        return this.position;
    }

    /**
     * Returns the color and type of the piece
     * @return A string containing the color and type of the piece
     */
    @Override
    public String getColorAndType()
    {
        return this.colorAndType;
    }

    /**
     * Returns all the possible moves considering the current Position
     * @return A list of Positions
     */
    @Override
    public List<Position> possibleMoves()
    {
        List<Position> possibleMoves = new ArrayList<>();
        this.possibleTakes = new ArrayList<>();

        for (int i = -1; i < 2; i++)
        {
            for (int j = -1; j < 2; j++)
            {
                if (i == 0 && j == 0)
                {
                    continue;
                }
                else
                {
                    if (super.board.inBounds(this.position.getRow() + i, this.position.getCol() + j))
                    {
                        Piece piece = this.board.getPiece(this.position.getRow() + i, this.position.getCol() + j);
                        if (Objects.isNull(piece))
                        {
                            possibleMoves.add(new Position(this.position.getRow() + i, this.position.getCol() + j));
                        }
                        else if (piece.getColor() != this.getColor() && piece.getType() != "KING")
                        {
                            this.possibleTakes.add(new Position(this.position.getRow() + i, this.position.getCol() + j));
                        }
                    }
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
        return "KING";
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
        return "R" + super.board.getColCoordinates(end.getCol()) + super.board.getRowCoordinates(end.getRow());
    }
}
