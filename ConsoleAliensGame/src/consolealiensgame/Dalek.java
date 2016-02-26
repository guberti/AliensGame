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
        move_energy = Math.min(api.getEnergy(), api.getTech());
        // don't move more than 5, leave energy for other stuff
        move_energy = Math.min(move_energy, 5);
        
        // spend a random amount of that moving into x direction
        int x = rand.nextInt() % move_energy;
        move_energy -= x;
        
        // and y takes the rest
        int y = move_energy;
        
        // don't move off the board
        x = Math.min(api.getX(), x);
        y = Math.min(api.getX(), y);
                
        return new MoveDir(x, y);
    }

    public Action getAction(AlienAPI api)
    {
        View view = api.getView();

        // catch and shenanigans
        try
        {
            // is there another alien on our position?
            if (view.isAlienAtPos(api.getX(), api.getX()))
            {
                // if so, do we have any energy?
                if (api.getEnergy() < 3)
                {
                    // no, lie still and start praying
                    return new Action (ActionCode.Gain);
                }
                
                // or, spend our energy on fighting
                return new Action (ActionCode.Fight, api.getEnergy() - 2);
            }
        } catch (Exception e)
        {
            // do something here to deal with errors
        }

        
        //
        // if we have spare energy, research tech
        //
        
        if (api.getEnergy() > (api.getTech() + 2))
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
