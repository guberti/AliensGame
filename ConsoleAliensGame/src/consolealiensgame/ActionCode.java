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
 * "None" --------- Perform no action
 * "Gain" --------- Gain energy
 * "Research" ----- Research technology
 * "Spawn" -------- Spawn offspring
 * "Trade" -------- offer to Trade with other aliens on same spot
 * "Fight" -------- fight other Aliens on same spot
*/
public enum ActionCode {
    None, Gain, Research, Spawn, Trade, Fight
}


