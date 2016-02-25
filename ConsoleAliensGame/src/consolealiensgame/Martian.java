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
    public MoveDir getMove(AlienAPI api) {
        currentDir *= -1;
        return new MoveDir(currentDir, 0);
    }

    
    public Action getAction(AlienAPI api) {
        return new Action(ActionCode.Gain);
    }
    
    public void processResults(AlienAPI api) {
        return;
    }
}
