/*
 * 
 */
package stockaliens;

import alieninterfaces.*;

/**
 *
 * @author guberti
 */
public class Martian implements Alien {
    int currentDir;
    
    public Martian() {
        currentDir = 1;
    }
    
    // Martians move left, right, left, right
    public MoveDir getMove(Context api) {
        currentDir *= -1;
        return new MoveDir(currentDir, 0);
    }

    
    public Action getAction(Context api) {
        return new Action(ActionCode.Gain);
    }
    
    public void processResults(Context api) {
        return;
    }
}
