package sample.model;

/**
 * @author Bedam Queda
 * @version 06/06/2021
 */
import java.util.Objects;

/**4º
 *  Pair of coordinates
 */
public class Position {
    private int col;
    private int row;

    /**
     * Constructor
     * @param row Row coordinate
     * @param col Column coordinate
     */
    public Position(int row, int col) {
        this.col = col;
        this.row = row;
    }

    /**
     * Compares this object to another object
     * @param o Object to compare to
     * @return True if the objects are the same type
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return col == position.col &&
                row == position.row;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(col, row);
    }

    /**
     * Returns a String containing the coordinates
     * @return the coordinates as a String
     */
    @Override
    public String toString()
    {
        return "(" + row + ", " + col + ')';
    }

    /**
     * Returns the column coordinate
     * @return column coordinate value
     */
    public int getCol() {
        return col;
    }

    /**
     * Returns the column coordinate
     * @return column coordinate value
     */
    public int getRow() {
        return row;
    }
}
