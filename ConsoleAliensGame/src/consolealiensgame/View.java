/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consolealiensgame;

/**
 *
 * @author guberti
 */
public class View {
    // Views are "windows" into the game board
    // Views are always square, for the time being
    // Views store game tiles as an array of integers
    // -1 means empty
    // Any number that is >= 0 is the power of an alien on that tile
    
    private int[][] board;
    
    // Corner refers to top left of board
    
    private int topX;
    private int topY;
    
    public View (int topX, int topY, int[][] board) {
        this.board = board;
        this.topX = topX;
        this.topY = topY;
    }
    
    public int getEnergyAtPos(int x, int y) throws CantSeeSquareException {
        if (topX + board.length > x ||
                topX < x ||
                topY + board.length > y ||
                topY < y) {
            throw new CantSeeSquareException();
        }
        return board[topX - x][topY - y];
    }
    
    public boolean isAlienAtPos(int x, int y) throws CantSeeSquareException {
        return getEnergyAtPos(x, y) > -1;
    }
}

class CantSeeSquareException extends Exception {}