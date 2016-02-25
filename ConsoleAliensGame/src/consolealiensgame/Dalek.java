/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consolealiensgame;

import java.util.Random;

/**
 *
 * @author gmein
 */
public class Dalek extends Alien
{
    Random rand;
    
    public Dalek()
    {
        rand = new Random();
    }

    // Martians move left, right, left, right
    public MoveDir getMove(AlienAPI api)
    {
        int move_energy;
        
        // don't move more than you have tech
        move_energy = Math.min(api.energy(), api.tech());
        // don't move more than 5, leave energy for other stuff
        move_energy = Math.min(move_energy, 5);
        
        // spend a random amount of that moving into x direction
        int x = rand.nextInt() % move_energy;
        move_energy -= x;
        
        // and y takes the rest
        int y = move_energy;
        
        // don't move off the board
        x = Math.min(api.x(), x);
        y = Math.min(api.y(), y);
                
        return new MoveDir(x, y);
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
