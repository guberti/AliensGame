/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consolealiensgame;
//comment
/**
 *
 * @author guberti
 */
public class ConsoleAliensGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SpaceGrid grid = new SpaceGrid(5, 1);
        grid.addAlien(0, 2, 2, new Martian());
    }
    
}
