/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consolealiensgame;

/**
 *
 * @author gmein
 */
public class Dalek extends Alien
{
    public Dalek()
    {
    }

    // Martians move left, right, left, right
    public MoveDir getMove(AlienAPI api)
    {
        return new MoveDir(1, 0);
    }

    public Action getAction(AlienAPI api)
    {
        View view = api.view();

        try
        {
            if (view.isAlienAtPos(api.x(), api.y()))
            {
                if (api.energy() < 2)
                {
                    return new Action (ActionCode.Gain);
                }
                return new Action (ActionCode.Fight, Math.max(api.energy() - 2, 2));
            }
        } catch (Exception e)
        {
            // do something here to deal with errors
        }

        
        //
        // if we have spare energy, research tech
        //
        
        if (api.energy() > (api.tech() + 2))
        {
            return new Action(ActionCode.Research);
        }
        return new Action(ActionCode.Gain);
    }

    public void processResults(AlienAPI api)
    {
        return;
    }

}
