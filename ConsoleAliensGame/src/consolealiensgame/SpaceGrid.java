/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consolealiensgame;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.reflect.Constructor;
import alieninterfaces.*;

/**
 *
 * @author guberti
 */
public class SpaceGrid {
    GameSpace[][] grid;
    List<AlienContainer> aliens; // Aliens are born and die, so
    // our list needs to be able to grow and shrink
    
    public SpaceGrid () {
        aliens = new ArrayList<>(); // AlienContainer type is inferred    
    }
    
    public void moveAliens() {
        for (int i = 0; i < aliens.size(); i++) {
            ViewImplementation view = getAlienView(i);
            try {
                aliens.get(i).move(view);
            } catch (Exception ex) {
                Logger.getLogger(SpaceGrid.class.getName()).log(Level.SEVERE, null, ex);
                aliens.remove(i);
            }
        }
        // Once the aliens have moved, have them fight each other if they are in
        // the same game space
        
        // Note: We can't use an enhanced for loop here, because we need the
        // AC's index in case it crashes and needs to be destroyed
        
        for (int i = 0; i < aliens.size(); i++) {            
            // If there has not already been a fight on the alien's space
            if (!aliens.get(i).action) {
                
                // We need alienIndices in order to destroy an alien if it 
                // crashes
                List<Integer> alienIndices = new ArrayList<>();
                
                // For each alien that it could fight with
                for (int k = i + 1; k < aliens.size(); k++) {
                    if ( // If two aliens are on the same space 
                        aliens.get(i).x == aliens.get(k).x &&
                        aliens.get(i).y == aliens.get(k).y) {
                        
                        // They need to fight, so add them to fightingAliens
                        alienIndices.add(k);
                    }
                }
                
                if (alienIndices.size() > 0) { // If a battle will happen
                    // Add the initial alien to the fight
                    alienIndices.add(i);
                    
                    // For each alien, ask it how much it wants to fight
                    int[] fightPowers = new int[alienIndices.size()];
                    
                    for (int k = 0; k < alienIndices.size(); k++) {
                        try {
                            fightPowers[k] = aliens.get(alienIndices.get(k)).fight();
                        } catch (Exception ex) {
                            fightPowers[k] = 0;
                            aliens.get(alienIndices.get(k)).kill();
                            Logger.getLogger(SpaceGrid.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    
                    int winningEnergy = maxValue(fightPowers);
                    
                    for (int power: fightPowers) {
                        if (power < winningEnergy) { // If the alien lost the fight
                            
                        } else if (power == winningEnergy) { // If the alien tied 
                            
                        } else { // If the alien won
                            
                        }
                    }
                }
            }
        }
    }
    
    public void removeDeadAliens() {
        for (int i = 0; i < aliens.size(); i++) {
            if (aliens.get(i).energy <= 0) {
                System.out.println("An alien ran out of energy and died");
                aliens.remove(i);
            }
        }
    }
    
    public void resetMoves() {
        aliens.stream().forEach((alien) -> {
            alien.action = false;
        });
    }
    
    public void performAlienActions() {
        
        // Obtain all actions before enacting any of them
        Action[] actions = new Action[aliens.size()];
        
        for (int i = 0; i < aliens.size(); i++) {
            ViewImplementation view = getAlienView(i);
            
            try {
                // Note: getAction() checks validity
                actions[i] = aliens.get(i).getAction(view);
                
            } catch (Exception ex) {
                actions[i] = new Action(ActionCode.None);
                aliens.get(i).kill();
                Logger.getLogger(SpaceGrid.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        for (int i = 0; i < actions.length; i++) {
            switch (actions[i].code) {
                case Gain: 
                    aliens.get(i).energy += Math.floor(aliens.get(i).tech/10) + 1;
                    continue;
                case Research: 
                    aliens.get(i).energy -= aliens.get(i).tech;
                    aliens.get(i).tech++;
                    continue;
                case Spawn: 
                    aliens.get(i).energy -= 3 + actions[i].power;
                    
                    // Add in the alien to the end of the list so actions
                    // are not executed on it this turn
                    // TODO add code to spawn species relevant offspring here
                    // e.g. Alien alien = new Martian();
                    
                    aliens.add(new AlienContainer(
                        aliens.get(i).x, 
                        aliens.get(i).y,
                        aliens.get(i).alienPackageName,
                        aliens.get(i).alienClassName,
                        aliens.get(i).alienConstructor,
                        actions[i].power, 1));
            }
        }
    }
    
    private ViewImplementation getAlienView(int index) {
        // Create the alien's view
        int size = aliens.get(index).tech;
        int cornerX = aliens.get(index).x - size;
        int cornerY = aliens.get(index).y - size;
        // Bottom left corner
        List<AlienContainer> view = new ArrayList<>();
        
        for (int k = 0; k < aliens.size(); k++) {
            if (k != index) { // The alien does not show itself on the map
                AlienContainer alien = aliens.get(k);
                if ( // If the alien can be seen
                        alien.x >= cornerX &&
                        alien.x <= cornerX + size * 2 &&
                        alien.y >= cornerY &&
                        alien.y <= cornerY + size * 2) {
                    view.add(alien);
                }
            }
        }

        return new ViewImplementation(view, cornerX, cornerY, size);
    }
            
    private int maxValue(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int item : array) {
            if (item > max) {
                max = item;
            }
        }
        return max;
    }
    
    void addAlien(int x, int y, String alienPackageName, String alienClassName, Constructor<?> cns) {
        AlienContainer aC = new AlienContainer(x, y, alienPackageName, alienClassName, cns, 1, 1);
        aliens.add(aC);
    }
    
}