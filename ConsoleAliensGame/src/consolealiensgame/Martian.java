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
public class Martian extends Alien {
    int currentDir;
    
    public Martian() {
        currentDir = 1;
    }
    
    // Martians move left, right, left, right
    public MoveDir getMove() {
        currentDir *= -1;
        return new MoveDir(currentDir, 0);
    }
}
