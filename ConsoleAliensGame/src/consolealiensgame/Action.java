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

/* Each turn, Aliens that did not get into a fight will have the choice to
 * perform an action. Because there is such a large variety of things Aliens
 * may be able to do in the future, an Alien will return an object of class
 * Action that contains the information about the action that they wish to
 * perform. An alien may only choose one action per turn to perform.
 * Which action is being performed will be controlled by a actionCode
 * that corresponds to the appropriate action. Below is a table of action
 * codes to the English names of the actions.
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


public class Action {
    public ActionCode code;
    public int power;
    
    public Action (ActionCode code, int power) {
        this.code = code;
        this.power = power;
    }
    
    public Action (ActionCode code) {
        this.code = code;
    }
    // TODO add in code for a constructor where the name of the action and the
    // power are passed in, instead of a code and a power
}
