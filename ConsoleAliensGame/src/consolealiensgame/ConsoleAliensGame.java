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
public class ConsoleAliensGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SpaceGrid grid = new SpaceGrid();
        grid.addAlien(2, 2, new Martian());
        grid.addAlien(2, 4, new Martian());
        int turns = 100;
        
        for (int i = 0; i < turns; i++) {
            grid.moveAliens();
            grid.performAlienActions();
            grid.removeDeadAliens();
            grid.resetMoves();
        }
        
        //grid.printAlienAttributes();
    }
    
}
