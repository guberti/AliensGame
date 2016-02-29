/*
 * 
 */
package consolealiensgame;
import java.util.Random;
/**
 *
 * @author guberti
 */
public class Martian extends Alien {
    int HorizontalMove;
    int VerticalMove;
    int Remainder;
    private static Random rnd = new Random();
    public static boolean getRandomBoolean() {
        return rnd.nextBoolean();
    }

    public Martian(AlienAPI api) {
        
        Remainder = api.tech() % 2;
        HorizontalMove = (api.tech()-Remainder)/2;
        VerticalMove = api.tech()- HorizontalMove;
        if(getRandomBoolean() == true)
        {
            HorizontalMove *= -1;
        }
        if(getRandomBoolean() == true)
        {
            VerticalMove *= -1;
        }
    }

    Martian() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public MoveDir getMove(AlienAPI api) {
        return new MoveDir(HorizontalMove, VerticalMove);
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
        return new Action(ActionCode.Fight, api.energy());
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
