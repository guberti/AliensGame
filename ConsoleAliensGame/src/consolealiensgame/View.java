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
    
    public View (AlienContainer[] aCs) {
        this.aCs = aCs;
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