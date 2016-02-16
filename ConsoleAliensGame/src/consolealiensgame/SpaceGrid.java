/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consolealiensgame;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guberti
 */
public class SpaceGrid {
    GameSpace[][] grid;
    List<AlienContainer> aliens; // Aliens are born and die, so
    // our list needs to be able to grow and shrink
    
    public SpaceGrid (int gridSize, int alienCount) {
        grid = new GameSpace[gridSize][gridSize];
        aliens = new ArrayList<>(); // AlienContainer type is inferred    
    }
    
    public void moveAliens() {
        for (int i = 0; i < aliens.size(); i++) {
            try {
                aliens.get(i).move();
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
    
    private int maxValue(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int item : array) {
            if (item > max) {
                max = item;
            }
        }
        return max;
    }
    
    public void addAlien(int x, int y, Alien alien) {
        AlienContainer aC = new AlienContainer(x, y, alien);
        aliens.add(aC);
    }
    
}