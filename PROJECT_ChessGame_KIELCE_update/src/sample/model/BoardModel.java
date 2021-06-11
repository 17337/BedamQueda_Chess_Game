package sample.model;


import sample.View;
import sample.model.Pieces.*;

import java.io.*;
import java.util.List;
import java.util.Objects;

/**
 * @author Bedam Queda, Erasmus
 * @version 06/06/2021
 */
public class BoardModel
{
    private final View VIEW;
    public final int SIZE;
    private Piece[][] boardData;
    private int turnCounter;
    private int lineCounter;
    private boolean isMovable;
    private Position pieceToMovePosition;
    private String[] rowCoordinates;
    private String[] colCoordinates;
    private File chessFile;

    /**
     * Constructor
     * @param view The board View (observer)
     */
    public BoardModel(View view)
    {
        this.VIEW = view;
        this.SIZE = 8;
        this.boardData = new Piece[this.SIZE][this.SIZE];
        this.setUpBoard();
        this.isMovable = false;
        this.turnCounter = 0;
        this.colCoordinates = new String[]{"a", "b", "c", "d", "e", "f", "g", "h"};
        this.rowCoordinates = new String[]{"8", "7", "6", "5", "4", "3", "2", "1"};
        this.chessFile = new File("src/sample/resources/chess.txt");
        this.lineCounter = 1;
        try
        {
            this.cleanFile();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Creates the game board by populating each position with the respective piece
     */
    private void setUpBoard()
    {
        setWhitePieces();
        setBlackPieces();
    }


    /**
     * Checks the type of play given the piece selected
     * @param row Row coordinate
     * @param col Column coordinate
     */
    public void pieceSelected(int row, int col)
    {
        if (Objects.nonNull(this.boardData[row][col]))
        {
            if (this.boardData[row][col].getColor() == PieceColor.WHITE && this.turnCounter % 2 == 0)
            {
                this.isMovable = false;
                this.play(row, col);

            }
            else if (this.boardData[row][col].getColor() == PieceColor.BLACK && this.turnCounter % 2 != 0)
            {
                this.isMovable = false;
                this.play(row, col);
            }
            else if (this.isMovable)
            {
                this.play(row, col);
            }
        }
        else if (this.isMovable)
        {
            this.play(row, col);
        }
    }

    /** ----------------------
     * Plays on the specific board coordinates
     * @param row
     * @param col
     */
    public void play(int row, int col)
    {
        if (!this.isMovable)
        {
            this.VIEW.hidePossibleMovesOrTakes();
            this.pieceToMovePosition = this.getPiece(row, col).getPosition();
            List<Position> possibleMoves = this.getPiece(row, col).possibleMoves();
            List<Position> possibleTakes = this.getPiece(row, col).possibleTakes();
            this.VIEW.showPossibleMovesAndTakes(possibleMoves, possibleTakes);
            this.isMovable = true;
        }
        else if (this.isMovable)
        {
            Position positionToMoveTo = new Position(row, col);
            if (this.getPiece(this.pieceToMovePosition.getRow(),
                    this.pieceToMovePosition.getCol()).possibleMoves().contains(positionToMoveTo))
            {
                this.move(this.pieceToMovePosition, positionToMoveTo);
            }
            else if (this.getPiece(this.pieceToMovePosition.getRow(),
                    this.pieceToMovePosition.getCol()).possibleTakes().contains(positionToMoveTo))
            {
                this.move(this.pieceToMovePosition, positionToMoveTo);
            }

        }
    }

    /**
     * Moves the piece in the beginning Position to the end position
     * @param beginning Beginning position
     * @param end Ending position
     */
    private void move(Position beginning, Position end)
    {
        this.VIEW.hidePossibleMovesOrTakes();
        this.boardData[end.getRow()][end.getCol()] = this.boardData[beginning.getRow()][beginning.getCol()];
        this.boardData[end.getRow()][end.getCol()].setPosition(new Position(end.getRow(), end.getCol()));
        this.boardData[beginning.getRow()][beginning.getCol()] = null;
        this.VIEW.setButtonImage(end.getRow(), end.getCol(), this.boardData[end.getRow()][end.getCol()].getColorAndType());
        this.VIEW.setButtonImage(beginning.getRow(), beginning.getCol(), "");
        this.isMovable = false;

        try
        {
            this.writeMove(this.boardData[end.getRow()][end.getCol()].movementText(beginning, end));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        this.turnCounter++;
    }

    /**
     * Clears the file content
     * @throws IOException If the file is not found or valid
     */
    private void cleanFile() throws IOException
    {
        new PrintWriter(this.chessFile).close();
    }

    /**
     * Writes the Piece move to a file
     * @param movementText String to write
     * @throws IOException If the file is not found or valid
     */
    private void writeMove(String movementText) throws IOException
    {
        BufferedWriter writer = new BufferedWriter(new FileWriter(this.chessFile, true));
        // writer.write();
//        if ()
//        writer.append(this.lineCounter + ". ");

        if (this.turnCounter % 2 == 0)
        {
            writer.append("\n" + this.lineCounter + ". ");
            this.lineCounter++;
        }

        writer.append(movementText + " ");
        writer.close();

    }

    /**
     * Sets the white pieces int the board data
     */
    private void setWhitePieces()
    {
        this.boardData[7][0] = new Rook(this, PieceColor.WHITE, new Position(7, 0));
        this.VIEW.setButtonImage(7, 0, this.boardData[7][0].getColorAndType());
        this.boardData[7][1] = new Knight(this, PieceColor.WHITE, new Position(7, 1));
        this.VIEW.setButtonImage(7, 1, this.boardData[7][1].getColorAndType());
        this.boardData[7][2] = new Bishop(this, PieceColor.WHITE, new Position(7, 2));
        this.VIEW.setButtonImage(7, 2, this.boardData[7][2].getColorAndType());
        this.boardData[7][4] = new King(this, PieceColor.WHITE, new Position(7, 4));
        this.VIEW.setButtonImage(7, 4, this.boardData[7][4].getColorAndType());
        this.boardData[7][3] = new Queen(this, PieceColor.WHITE, new Position(7, 3));
        this.VIEW.setButtonImage(7, 3, this.boardData[7][3].getColorAndType());
        this.boardData[7][5] = new Bishop(this, PieceColor.WHITE, new Position(7, 5));
        this.VIEW.setButtonImage(7, 5, this.boardData[7][5].getColorAndType());
        this.boardData[7][6] = new Knight(this, PieceColor.WHITE, new Position(7, 6));
        this.VIEW.setButtonImage(7, 6, this.boardData[7][6].getColorAndType());
        this.boardData[7][7] = new Rook(this, PieceColor.WHITE, new Position(7, 7));
        this.VIEW.setButtonImage(7, 7, this.boardData[7][7].getColorAndType());

        for (int col = 0; col < this.SIZE; col++)
        {
            this.boardData[6][col] = new Pawn(this, PieceColor.WHITE, new Position(6, col));
            this.VIEW.setButtonImage(6, col, this.boardData[6][col].getColorAndType());
        }
    }

    /**
     * Sets the black pieces int the board data
     */
    private void setBlackPieces()
    {
        this.boardData[0][0] = new Rook(this, PieceColor.BLACK, new Position(0, 0));
        this.VIEW.setButtonImage(0, 0, this.boardData[0][0].getColorAndType());
        this.boardData[0][1] = new Knight(this, PieceColor.BLACK, new Position(0, 1));
        this.VIEW.setButtonImage(0, 1, this.boardData[0][1].getColorAndType());
        this.boardData[0][2] = new Bishop(this, PieceColor.BLACK, new Position(0, 2));
        this.VIEW.setButtonImage(0, 2, this.boardData[0][2].getColorAndType());
        this.boardData[0][4] = new King(this, PieceColor.BLACK, new Position(0, 4));
        this.VIEW.setButtonImage(0, 4, this.boardData[0][4].getColorAndType());
        this.boardData[0][3] = new Queen(this, PieceColor.BLACK, new Position(0, 3));
        this.VIEW.setButtonImage(0, 3, this.boardData[0][3].getColorAndType());
        this.boardData[0][5] = new Bishop(this, PieceColor.BLACK, new Position(0, 5));
        this.VIEW.setButtonImage(0, 5, this.boardData[0][5].getColorAndType());
        this.boardData[0][6] = new Knight(this, PieceColor.BLACK, new Position(0, 6));
        this.VIEW.setButtonImage(0, 6, this.boardData[0][6].getColorAndType());
        this.boardData[0][7] = new Rook(this, PieceColor.BLACK, new Position(0, 7));
        this.VIEW.setButtonImage(0, 7, this.boardData[0][7].getColorAndType());

        for (int col = 0; col < this.SIZE; col++)
        {
            this.boardData[1][col] = new Pawn(this, PieceColor.BLACK, new Position(1, col));
            this.VIEW.setButtonImage(1, col, this.boardData[1][col].getColorAndType());
        }
    }

    /**
     * Checks if the position is inside the game board
     * @param row Row coordinate
     * @param col Column coordinate
     * @return
     */
    public boolean inBounds(int row, int col)
    {
        if (row < 0 || row >= this.SIZE || col < 0 || col >= this.SIZE)
        {
            return false;
        }
        return true;
    }

    /**
     * Returns a piece given the row and columns coordinates
     * @param row Row coordinate
     * @param col Column coordinate
     * @return Piece
     */
    public Piece getPiece(int row, int col)
    {
        return this.boardData[row][col];
    }

    /**
     * Sets the board data(for tests purposes only)
     * @param boardData Bi-dimensional array of Pieces
     */
    public void setBoarData(Piece[][] boardData)
    {
        this.boardData = boardData;
    }

    /**
     * Returns the correspondent string for the row coordinates
     * @param index Index of the coordinate
     * @return A string containing the coordinate
     */
    public String getRowCoordinates(int index)
    {
        return rowCoordinates[index];
    }
    /**
     * Returns the correspondent string for the column coordinates
     * @param index Index of the coordinate
     * @return A string containing the coordinate
     */
    public String getColCoordinates(int index)
    {
        return colCoordinates[index];
    }
}