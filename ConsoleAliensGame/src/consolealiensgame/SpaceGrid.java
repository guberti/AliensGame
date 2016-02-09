/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consolealiensgame;

import java.util.Random;

/**
 *
 * @author guberti
 */
public class SpaceGrid {
    GameSpace[][] grid;
    AlienContainer[] aliens;
    
    public SpaceGrid (int gridSize, int alienCount) {
        grid = new GameSpace[gridSize][gridSize];
        aliens = new AlienContainer[alienCount];      
    }
    
    public void moveAliens() {
        for (AlienContainer alien: aliens) {
            try {
                alien.move();
            } catch (Exception e) {
                System.out.println("An alien threw a " + e + ", it died.");
                alien = null;
            }
        }
        // Once the aliens have moved, have them fight each other if they are in
        // the same game space
        
        for (int i = 0; i < aliens.length; i++) {
            for (int k = i + 1; i < aliens.length; i++) {
                if (
                        aliens[i].x == aliens[k].y &&
                        aliens[i].x == aliens[k].y) {
                    aliens[i] = null;
                    aliens[k] = null;
                }
            }
        }
    }

    void addAlien(int index, int x, int y, Alien alien) {
        AlienContainer aC = new AlienContainer(2, 2, alien);
        aliens[index] = aC;
    }
}
class MovedIntoAlienException extends Exception {}