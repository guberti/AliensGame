/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consolealiensgame;

/**
 *
 * @author guberti
 */
public abstract class Alien {
    // Constructor
    public Alien(){}
     
    public abstract MoveDir getMove(AlienAPI api);

    public abstract int getFightPower(AlienAPI api);

    public abstract Action getAction(AlienAPI api);
}
