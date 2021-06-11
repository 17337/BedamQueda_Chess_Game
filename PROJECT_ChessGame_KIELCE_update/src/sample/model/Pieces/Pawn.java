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
 * Pawn type Piece
 */
public class Pawn extends Piece
{
    private Position position;
    private String colorAndType;

    /**
     * Constructor
     * @param board Game model
     * @param pieceColor Piece color
     * @param position Position in the game model board
     */
    public Pawn(BoardModel board, PieceColor pieceColor, Position position)
    {
        super(board, pieceColor, position);
        this.position = position;
        this.colorAndType = pieceColor.toString() + "_PAWN";
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

        if (this.pieceColor == PieceColor.BLACK)
        {
            if (this.board.inBounds(this.position.getRow() + 1, this.position.getCol()))
            {
                Position nextPosition = new Position(this.position.getRow() + 1, this.position.getCol());

                if (Objects.isNull(board.getPiece(nextPosition.getRow(), nextPosition.getCol())))
                {
                    possibleMoves.add(nextPosition);

                    if (this.position.getRow() == 1)
                    {
                        Position secondNextPosition = new Position(this.position.getRow() + 2,
                                this.position.getCol());

                        if (Objects.isNull(board.getPiece(secondNextPosition.getRow(),
                                secondNextPosition.getCol())))
                        {
                            possibleMoves.add(secondNextPosition);
                        }
                    }
                }
            }
        }
        else
        {
            if (this.board.inBounds(this.position.getRow() - 1, this.position.getCol()))
            {
                Position nextPosition = new Position(this.position.getRow() - 1, this.position.getCol());

                if (Objects.isNull(board.getPiece(nextPosition.getRow(), nextPosition.getCol())))
                {
                    possibleMoves.add(nextPosition);

                    if (this.position.getRow() == 6)
                    {
                        Position secondNextPosition = new Position(this.position.getRow() - 2,
                                this.position.getCol());

                        if (Objects.isNull(board.getPiece(secondNextPosition.getRow(),
                                secondNextPosition.getCol())))
                        {
                            possibleMoves.add(secondNextPosition);
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
        List<Position> possibleTakes = new ArrayList<>();

        if (this.pieceColor == PieceColor.BLACK)
        {
            if (this.board.inBounds(this.position.getRow() + 1, this.position.getCol() - 1))
            {
                Piece piece = this.board.getPiece(this.position.getRow() + 1, this.position.getCol() - 1);
                if (Objects.nonNull(piece))
                {
                    if (piece.getColor() != this.getColor() && piece.getType() != "KING")
                    {
                        possibleTakes.add(new Position(this.position.getRow() + 1, this.position.getCol() - 1));
                    }
                }
            }

            if (this.board.inBounds(this.position.getRow() + 1, this.position.getCol() + 1))
            {
                Piece piece = this.board.getPiece(this.position.getRow() + 1, this.position.getCol() + 1);
                if (Objects.nonNull(piece))
                {
                    if (piece.getColor() != this.getColor() && piece.getType() != "KING")
                    {
                        possibleTakes.add(new Position(this.position.getRow() + 1, this.position.getCol() + 1));
                    }
                }
            }
        }
        else
        {
            if (this.board.inBounds(this.position.getRow() - 1, this.position.getCol() - 1))
            {
                Piece piece = this.board.getPiece(this.position.getRow() - 1, this.position.getCol() - 1);
                if (Objects.nonNull(piece))
                {
                    if (piece.getColor() != this.getColor() && piece.getType() != "KING")
                    {
                        possibleTakes.add(new Position(this.position.getRow() - 1, this.position.getCol() - 1));
                    }
                }
            }

            if (this.board.inBounds(this.position.getRow() - 1, this.position.getCol() + 1))
            {
                Piece piece = this.board.getPiece(this.position.getRow() - 1, this.position.getCol() + 1);
                if (Objects.nonNull(piece))
                {
                    if (piece.getColor() != this.getColor() && piece.getType() != "KING")
                    {
                        possibleTakes.add(new Position(this.position.getRow() - 1, this.position.getCol() + 1));
                    }
                }
            }
        }

        return possibleTakes;
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
        return "PAWN";
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
        return super.board.getColCoordinates(end.getCol()) + super.board.getRowCoordinates(end.getRow());
    }
}
