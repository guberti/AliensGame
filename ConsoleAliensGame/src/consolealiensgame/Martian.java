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

    @Override
    public int getFightPower(AlienAPI api) {
        // Martians should fight with half the maximum amount of fight they
        // could fight with
        return Math.min(api.energy(), api.tech()) / 2;
    }
    
    public Action getAction(AlienAPI api, View view) {
        return new Action(1);
    }
}
