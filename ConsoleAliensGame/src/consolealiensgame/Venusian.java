/*
 * 
 */
package consolealiensgame;

/**
 *
 * @author guberti
 */
public class Venusian extends Alien {
    int currentDirX;
    int currentDirY;
    public Venusian() {
        currentDirX = 0;
        currentDirY = 0;
        
    }
    
    // Move Function
    public MoveDir getMove(AlienAPI api) {
        
        return new MoveDir(currentDirX, currentDirY);
    }
    
    public Action getAction(AlienAPI api) {
        return new Action(ActionCode.Gain);
    }
    public void processResults(AlienAPI api) {
        return;
    }
}
