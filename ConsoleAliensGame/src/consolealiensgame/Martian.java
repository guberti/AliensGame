/*
 * 
 */
package consolealiensgame;

/**
 *
 * @author guberti
 */
public class Martian extends Alien {
    int HorizontalMove;
    int VerticalMove;
    
    public Martian() {
        HorizontalMove = 0;
        VerticalMove = 0;
    }

    // Martians move left, right, left, right
    public MoveDir getMove(AlienAPI api) {
        return new MoveDir(api.energy(), 0);
    }

    public Action getAction(AlienAPI api) {
        try
        {
            if(api.view.isAlienAtPos(api.x(), api.y()))
            {
                return new Action(ActionCode.Fight, Math.max(api.energy() - 2, 2));
            }
        }catch (Exception e)
        {
            
        }
        
        if(api.energy()< 2)
        {
            return new Action(ActionCode.Gain);
        }
        else if(api.energy() < 4)
        {
            return new Action(ActionCode.Research);
        }
        else
        {
            return new Action(ActionCode.Spawn);
        }
        
    }

    @Override
    public void processResults(AlienAPI api) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
