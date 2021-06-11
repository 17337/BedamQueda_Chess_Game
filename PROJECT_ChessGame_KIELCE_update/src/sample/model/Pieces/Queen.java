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
 * Queen type Piece
 */
public class Queen extends Piece
{
    Position position;
    private String colorAndType;
    private List<Position> possibleTakes;

    public Queen(BoardModel board, PieceColor pieceColor, Position position) {
        super(board, pieceColor, position);
        this.position = position;
        this.colorAndType = pieceColor.toString() + "_QUEEN";
    }

    /**
     * Returns the current Position
     * @return Position (row an column coordinates)
     */
    @Override
    public Position getPosition() {
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
        this.possibleTakes = new ArrayList<>();
        List<Position> possibleMoves = new ArrayList<>(this.diagonalPossibleMoves());
        possibleMoves.addAll(this.verticalAndHorizontalPossibleMoves());

        return possibleMoves;
    }

    /**
     * Joins the vertical and horizontal possible moves
     * @return a List of Positions
     */
    private List<Position> verticalAndHorizontalPossibleMoves() {

        List<Position> verticalAndHorizontalPossibleMoves = new ArrayList<>(this.verticalPossibleMoves());
        verticalAndHorizontalPossibleMoves.addAll(this.horizontalPossibleMoves());

        return verticalAndHorizontalPossibleMoves;
    }

    /**
     * Calculates the horizontal possible moves
     * @return A list of Positions
     */
    private List <Position> horizontalPossibleMoves()
    {
        List<Position> horizontalPossibleMoves = new ArrayList<>();

        for (int col = this.position.getCol() - 1; col >= 0; col--)
        {
            if (this.board.inBounds(this.position.getRow(), col))
            {
                Piece piece = board.getPiece(this.position.getRow(), col);
                if (Objects.isNull(piece))
                {
                    horizontalPossibleMoves.add(new Position(this.position.getRow(), col));
                }
                else if (piece.getColor() != this.getColor() && piece.getType() != "KING")
                {
                    this.possibleTakes.add(new Position(this.position.getRow(), col));
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

        for (int col = this.position.getCol() + 1; col < this.board.SIZE; col++)
        {
            if (this.board.inBounds(this.position.getRow(), col))
            {
                Piece piece = board.getPiece(this.position.getRow(), col);
                if (Objects.isNull(piece))
                {
                    horizontalPossibleMoves.add(new Position(this.position.getRow(), col));
                }
                else if (piece.getColor() != this.getColor() && piece.getType() != "KING")
                {
                    this.possibleTakes.add(new Position(this.position.getRow(), col));
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

        return horizontalPossibleMoves;
    }

    /**
     * Calculates the vertical possible moves
     * @return A list of Positions
     */
    private List <Position> verticalPossibleMoves()
    {
        List<Position> verticalPossibleMoves = new ArrayList<>();

        for (int row = this.position.getRow() + 1; row < board.SIZE; row++)
        {
            if (this.board.inBounds(row, this.position.getCol()))
            {
                Piece piece = board.getPiece(row, this.position.getCol());
                if (Objects.isNull(piece))
                {
                    verticalPossibleMoves.add(new Position(row, this.position.getCol()));
                }
                else if (piece.getColor() != this.getColor() && piece.getType() != "KING")
                {
                    this.possibleTakes.add(new Position(row, this.position.getCol()));
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

        for (int row = this.position.getRow() - 1; row >= 0; row--)
        {
            if (this.board.inBounds(row, this.position.getCol()))
            {
                Piece piece = board.getPiece(row, this.position.getCol());
                if (Objects.isNull(piece))
                {
                    verticalPossibleMoves.add(new Position(row, this.position.getCol()));
                }
                else if (piece.getColor() != this.getColor() && piece.getType() != "KING")
                {
                    this.possibleTakes.add(new Position(row, this.position.getCol()));
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

        return verticalPossibleMoves;
    }

    /**
     * Joins the top and bottom diagonal possible moves
     * @return A list of Positions
     */
    private List<Position> diagonalPossibleMoves()
    {
        List<Position> diagonalPossibleMoves = new ArrayList<>(this.topDiagonalPossibleMoves());
        diagonalPossibleMoves.addAll(this.bottomDiagonalPossibleMoves());

        return diagonalPossibleMoves;
    }

    /**
     * Calculates the top diagonal possible moves
     * @return A list of positions
     */
    private List<Position> topDiagonalPossibleMoves()
    {
        List<Position> topdiagonalPossibleMoves = new ArrayList<>();

        for (int i = 1; i < super.board.SIZE; i++)
        {
            if (super.board.inBounds(this.position.getRow() - i, this.position.getCol() - i))
            {
                Piece piece = board.getPiece(this.position.getRow() - i, this.position.getCol() - i);
                if (Objects.isNull(piece))
                {
                    topdiagonalPossibleMoves.add(new Position(this.position.getRow() - i, this.position.getCol() - i));
                }
                else if (piece.getColor() != this.getColor() && piece.getType() != "KING")
                {
                    this.possibleTakes.add(new Position(this.position.getRow() - i, this.position.getCol() - i));
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
                Piece piece = board.getPiece(this.position.getRow() - i, this.position.getCol() + i);
                if (Objects.isNull(piece))
                {
                    topdiagonalPossibleMoves.add(new Position(this.position.getRow() - i, this.position.getCol() + i));
                }
                else if (piece.getColor() != this.getColor() && piece.getType() != "KING")
                {
                    this.possibleTakes.add(new Position(this.position.getRow() - i, this.position.getCol() + i));
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

        return topdiagonalPossibleMoves;
    }

    /**
     * Calculates the bottom diagonal possible moves
     * @return A list of positions
     */
    private List<Position> bottomDiagonalPossibleMoves()
    {
        List<Position> bottomDiagonalPossibleMoves = new ArrayList<>();

        for (int i = 1; i < super.board.SIZE; i++)
        {
            if (super.board.inBounds(this.position.getRow() + i, this.position.getCol() + i))
            {
                Piece piece = board.getPiece(this.position.getRow() + i, this.position.getCol() + i);
                if (Objects.isNull(piece))
                {
                    bottomDiagonalPossibleMoves.add(new Position(this.position.getRow() + i, this.position.getCol() + i));
                }
                else if (piece.getColor() != this.getColor() && piece.getType() != "KING")
                {
                    this.possibleTakes.add(new Position(this.position.getRow() + i, this.position.getCol() + i));
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
                Piece piece = board.getPiece(this.position.getRow() + i, this.position.getCol() - i);
                if (Objects.isNull(piece))
                {
                    bottomDiagonalPossibleMoves.add(new Position(this.position.getRow() + i, this.position.getCol() - i));
                }
                else if (piece.getColor() != this.getColor() && piece.getType() != "KING")
                {
                    this.possibleTakes.add(new Position(this.position.getRow() + i, this.position.getCol() - i));
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

        return bottomDiagonalPossibleMoves;
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
     * Changes the current position
     * @param position Position to change to
     */
    @Override
    public void setPosition(Position position)
    {
        this.position = position;
    }

    /**
     * Returns the piece type
     * @return A string containing the piece type
     */
    @Override
    public String getType()
    {
        return "QUEEN";
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
        return "D" + super.board.getColCoordinates(end.getCol()) + super.board.getRowCoordinates(end.getRow());
    }
}
