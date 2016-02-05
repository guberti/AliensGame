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
    
    public SpaceGrid (int gridSize) {
        grid =  new GameSpace[gridSize][gridSize];
        Random rand = new Random();
        
        // Add in a new subclass of Alien
        while (true) {
            int x = rand.nextInt(gridSize);
            int y = rand.nextInt(gridSize);
            // If the selected space on the grid is empty
            if (grid[x][y] == null) {
                // Place an alien into it and break
                grid[x][y] = new Martian();
                break;
            }
        }
    }
    
    public void moveAliens() {
        for (int i = 0; i < grid.length; i++) {
            for (int k = 0; k < grid[i].length; k++) {
                // If there is an alien at that poin
                if (grid[i][k] != null) {
                    try {
                        
                    } catch (Exception e) { // If the alien's program crashes
                        // Kill the alien
                        grid[i][k] = null;
                    }
                }
            }
        }
    }
}
