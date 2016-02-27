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
    Context ctx;
    
    public void init(Context ctx) {
        currentDir = 1;
        this.ctx = ctx;
    }
    
    // Martians move left, right, left, right
    public MoveDir getMove() {
        currentDir *= -1;
        return new MoveDir(currentDir, 0);
    }

    
    public Action getAction() {
        return new Action(ActionCode.Gain);
    }
    
    public void processResults() {
        return;
    }
}
