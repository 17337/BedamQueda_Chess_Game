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
 * Bishop type Piece
 */
public class Bishop extends Piece
{
    private Position position;
    private String colorAndType;
    private PieceColor color;

    /**
     * Constructor
     * @param board Game model
     * @param pieceColor Piece color
     * @param position Position in the game model board
     */
    public Bishop(BoardModel board, PieceColor pieceColor, Position position) {
        super(board, pieceColor, position);
        this.position = position;
        this.color = pieceColor;
        this.colorAndType = pieceColor.toString() + "_BISHOP";
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
     * Returns all the possible moves considering the current Position
     * @return A list of Positions
     */
    @Override
    public List<Position> possibleMoves()
    {
        List<Position> possibleMoves = new ArrayList<>(topPossibleMoves());
        possibleMoves.addAll(bottomPossibleMoves());

        return possibleMoves;
    }

    /**
     * Calculates the top possible moves
     * @return A list of Positions
     */
    private List<Position> topPossibleMoves()
    {
        List<Position> topPossibleMoves = new ArrayList<>();

        for (int i = 1; i < super.board.SIZE; i++)
        {
            if (super.board.inBounds(this.position.getRow() - i, this.position.getCol() - i))
            {
                if (Objects.isNull(super.board.getPiece(this.position.getRow() - i, this.position.getCol() - i)))
                {
                    topPossibleMoves.add(new Position(this.position.getRow() - i, this.position.getCol() - i));
                }
                else
                {
                    break;
                }
            }
            else
            {
                break;
            }
        }

        for (int i = 1; i < super.board.SIZE; i++)
        {
            if (super.board.inBounds(this.position.getRow() - i, this.position.getCol() + i))
            {
                if (Objects.isNull(super.board.getPiece(this.position.getRow() - i, this.position.getCol() + i)))
                {
                    topPossibleMoves.add(new Position(this.position.getRow() - i, this.position.getCol() + i));
                }
                else
                {
                    break;
                }
            }
            else
            {
                break;
            }
        }

        return topPossibleMoves;
    }

    /**
     * Calculates the bottom possible moves
     * @return A list of Positions
     */
    private List<Position> bottomPossibleMoves()
    {
        List<Position> bottomPossibleMoves = new ArrayList<>();

        for (int i = 1; i < super.board.SIZE; i++)
        {
            if (super.board.inBounds(this.position.getRow() + i, this.position.getCol() + i))
            {
                if (Objects.isNull(super.board.getPiece(this.position.getRow() + i, this.position.getCol() + i)))
                {
                    bottomPossibleMoves.add(new Position(this.position.getRow() + i, this.position.getCol() + i));
                }
                else
                {
                    break;
                }
            }
            else
            {
                break;
            }
        }

        for (int i = 1; i < super.board.SIZE; i++)
        {
            if (super.board.inBounds(this.position.getRow() + i, this.position.getCol() - i))
            {
                if (Objects.isNull(super.board.getPiece(this.position.getRow() + i, this.position.getCol() - i)))
                {
                    bottomPossibleMoves.add(new Position(this.position.getRow() + i, this.position.getCol() - i));
                }
                else
                {
                    break;
                }
            }
            else
            {
                break;
            }
        }

        return bottomPossibleMoves;
    }

    /**
     * Returns all the possible takes considering the current Position
     * @return A list of Positions
     */
    @Override
    public List<Position> possibleTakes()
    {
        List<Position> possibleTakes = new ArrayList<>(this.topPossibleTakes());
        possibleTakes.addAll(this.bottomPossibleTakes());

        return possibleTakes;
    }

    /**
     * Calculates the top possible takes
     * @return A list of Positions
     */
    private List<Position> topPossibleTakes()
    {
        List<Position> topPossibleTakes = new ArrayList<>();

        for (int i = 1; i < super.board.SIZE; i++)
        {
            if (super.board.inBounds(this.position.getRow() - i, this.position.getCol() - i))
            {
                Piece piece = super.board.getPiece(this.position.getRow() - i, this.position.getCol() - i);
                if (Objects.isNull(piece))
                {
                    continue;
                }
                else if (piece.getColor() != this.getColor() && piece.getType() != "KING")
                {
                    topPossibleTakes.add(piece.getPosition());
                    break;
                }
                else
                {
                    break;
                }
            }
            else
            {
                break;
            }
        }

        for (int i = 1; i < super.board.SIZE; i++)
        {
            if (super.board.inBounds(this.position.getRow() - i, this.position.getCol() + i))
            {
                Piece piece = super.board.getPiece(this.position.getRow() - i, this.position.getCol() + i);
                if (Objects.isNull(piece))
                {
                    continue;
                }
                else if (piece.getColor() != this.getColor() && piece.getType() != "KING")
                {
                    topPossibleTakes.add(piece.getPosition());
                    break;
                }
                else
                {
                    break;
                }
            }
            else
            {
                break;
            }
        }

        return topPossibleTakes;
    }

    /**
     * Calculates the bottom possible takes
     * @return A list of Positions
     */
    private List<Position> bottomPossibleTakes()
    {
        List<Position> bottomPpossibleTakes = new ArrayList<>();

        for (int i = 1; i < super.board.SIZE; i++)
        {
            if (super.board.inBounds(this.position.getRow() + i, this.position.getCol() + i))
            {
                Piece piece = super.board.getPiece(this.position.getRow() + i, this.position.getCol() + i);
                if (Objects.isNull(piece))
                {
                    continue;
                }
                else if (piece.getColor() != this.getColor() && piece.getType() != "KING")
                {
                    bottomPpossibleTakes.add(piece.getPosition());
                    break;
                }
                else
                {
                    break;
                }
            }
            else
            {
                break;
            }
        }

        for (int i = 1; i < super.board.SIZE; i++)
        {
            if (super.board.inBounds(this.position.getRow() + i, this.position.getCol() - i))
            {
                Piece piece = super.board.getPiece(this.position.getRow() + i, this.position.getCol() - i);
                if (Objects.isNull(piece))
                {
                    continue;
                }
                else if (piece.getColor() != this.getColor() && piece.getType() != "KING")
                {
                    bottomPpossibleTakes.add(piece.getPosition());
                    break;
                }
                else
                {
                    break;
                }
            }
            else
            {
                break;
            }
        }

        return bottomPpossibleTakes;
    }

    /**
     * Returns the Piece Color
     * @return Piece color
     */
    @Override
    public PieceColor getColor()
    {
        return this.color;
    }

    /**
     * Returns the piece type
     * @return A string containing the piece type
     */
    @Override
    public String getType()
    {
        return "BISHOP";
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
     * Returns the color and type of the piece
     * @return A string containing the color and type of the piece
     */
    @Override
    public String getColorAndType()
    {
        return this.colorAndType;
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
        return "B" + super.board.getColCoordinates(end.getCol()) + super.board.getRowCoordinates(end.getRow());
    }
}
