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
/* ActionCode Correspondence Table (will grow as actions are added)
 *
 * 0 --- "" ------------- Perform no action
 * 1 --- "Gain" --------- Gain energy
 * 2 --- "Research" ----- Research technology
 * 3 --- "Spawn" -------- Spawn offspring
 * 4 --- "Trade" -------- offer to Trade with other aliens on same spot
 * 5 --- "Fight" -------- fight other Aliens on same spot
*/


public enum ActionCode
{
   None, Gain, Research, Spawn, Trade, Fight 
}

