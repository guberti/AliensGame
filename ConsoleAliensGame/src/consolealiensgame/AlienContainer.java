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
public class AlienContainer {
    private final Alien alien;
    
    private int moveDist;
    
    public int x;
    public int y;
    
    // Declare stats here
    
    public AlienContainer(int x, int y, Alien alien) {
        this.alien = alien;
    }
    
    public void move() throws TooLargeMoveException {
        // Whether the move goes off the board will be determined by the grid
        
        MoveDir direction = alien.getMove();
        checkMove(direction); // Throws an exception if illegal
        x += direction.x();
        y += direction.y();
    }
    
    public void encounter() {
        return alien.getEncounter();
    }
    
    private void checkMove(MoveDir direction) throws TooLargeMoveException {
        // If the move is too far
        if (Math.pow(direction.x(), 2) + Math.pow(direction.y(), 2)
                > Math.pow(moveDist, 2)) {
            throw new TooLargeMoveException();
        }
    }
}

class TooLargeMoveException extends Exception {}