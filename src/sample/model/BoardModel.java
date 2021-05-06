package sample.model;

import javax.swing.text.View;
import java.io.File;

public class BoardModel {
    private final View VIEW;
    public final int SIZE;
    private int lineCounter;
    private int turnCounter;
    private int lineCouter;
    private String[] rowCoordinates; //save line coordinate
    private String[] colCoordinates; //save column coordinate
    private File chessFile;


    /**
     * Constructor
     * @param view The board View (observer)
     */
    public BoardModel(View view) {
        this.VIEW = view;
        this.SIZE = 8;

        this.turnCounter = 0;
        this.lineCouter = lineCouter;
        this.colCoordinates = new String[]{"a", "b", "c", "d", "e", "f", "g", "h"};
        this.rowCoordinates = new String[]{"8", "7", "6", "5", "4", "3", "2", "1"};
        this.lineCounter = 1;

    }
}
