/*
 * 
 */
package consolealiensgame;

/**
 *
 * @author guberti
 */
public class Martian extends Alien {
    int currentDir;
    
    public Martian() {
        currentDir = 1;
    }
    
    // Martians move left, right, left, right
    public MoveDir getMove() {
        currentDir *= -1;
        return new MoveDir(currentDir, 0);
    }
}
