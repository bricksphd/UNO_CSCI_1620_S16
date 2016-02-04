/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

/**
 *
 * @author bricks
 */
class Square {
    
    public int x;
    public int y;
    public Piece piece = null;
    
    public Square(int x, int y)
    {
        this.x = x;
        this.y = y;
    }    
}
