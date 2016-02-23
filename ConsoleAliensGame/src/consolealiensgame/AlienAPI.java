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
public class AlienAPI {
    private AlienContainer aC;
    
    AlienAPI(AlienContainer aC) {
        this.aC = aC;
    }
    
    public int energy() {
        return aC.energy;
    }
    
    public int tech() {
        return aC.tech;
    }
    
    public int x() {
        return aC.x;
    }
    
    public int y() {
        return aC.y;
    }
}
