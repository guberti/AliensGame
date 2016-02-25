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

    /*
    Obsolete:
    
    @Override
    public int getFightPower(AlienAPI api) {
        // Martians should fight with half the maximum amount of fight they
        // could fight with
        return Math.min(api.energy(), api.tech()) / 2;
    }*/
    
    public Action getAction(AlienAPI api) {
        return new Action(ActionCode.Gain);
    }
    
    public void processResults(AlienAPI api) {
        return;
    }

}
