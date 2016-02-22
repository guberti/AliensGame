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
public class AlienContainer {
    private final Alien alien;
    private final AlienAPI api;
    
    int tech;
    int energy;
    
    public int x;
    public int y;
    public boolean action; // Whether the alien has performed an action this turn
    
    // Declare stats here
    
    public AlienContainer(int x, int y, Alien alien, int energy, int tech) {
        this.alien = alien;
        this.energy = energy;
        this.tech = tech;
        this.api = new AlienAPI(this);
        
    }
    
    public void move() throws NotEnoughTechException {
        // Whether the move goes off the board will be determined by the grid
        
        MoveDir direction = alien.getMove(api);
        checkMove(direction); // Throws an exception if illegal
        x += direction.x();
        y += direction.y();
    }
    
    public void kill() {
        energy = 0;
    }
    
    public Action getAction() throws NotEnoughEnergyException, UnknownActionException {
        Action action = alien.getAction(api);
        switch (action.code) {
            case 0: // Anything where no power is required
            case 1:
                return new Action (action.code);
            case 2: // Research technology
                if (tech > energy) { // If the tech can't be researched due to lack of energy
                    throw new NotEnoughEnergyException();
                }
                // Otherwise
                return new Action (2, tech);
            case 3: // Spawn
                if (action.power + 3 > energy) {
                    throw new NotEnoughEnergyException();
                }
                return action;
            default:
                throw new UnknownActionException();
        }
    }
    
    public int fight() throws NotEnoughEnergyException, NotEnoughTechException {
        int fightPower = alien.getFightPower(api);
        
        // If the alien cannot fight with the amount of energy it wants
        // Throw the appropriate exception
        if (fightPower > energy) {
            throw new NotEnoughEnergyException();
        }
        if (fightPower > tech) {
            throw new NotEnoughTechException();
        }
        
        
        // If the move is valid, subtract the energy expended
        energy -= fightPower;
        
        // Return how much power the alien will fight with
        return fightPower;
    }
    
    private void checkMove(MoveDir direction) throws NotEnoughTechException {
        // If the move is farther than the alien has the tech to move
        if (Math.pow(direction.x(), 2) + Math.pow(direction.y(), 2)
                > Math.pow(tech, 2)) {
            throw new NotEnoughTechException();
        }
    }
}

class NotEnoughEnergyException extends Exception {}
class NotEnoughTechException extends Exception {}
class UnknownActionException extends Exception {}