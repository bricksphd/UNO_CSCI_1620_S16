/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bricks
 */
class Piece 
{
    protected Image blackImage;
    
    protected Image whiteImage;
    
    protected Side side;
    
    public Piece(Image blackImage, Image whiteImage, Side side)
    {
        this.blackImage = blackImage;
        this.whiteImage = whiteImage;
        this.side = side;
    }
    
    public Image getImage()
    {
        if(this.side == Side.Black)
            return this.blackImage;
        return this.whiteImage;
    }    

    List<Square> getPossibleMoves(Square clickSquare, Square[][] squares) {
        List<Square> toReturn = new ArrayList<Square>();
        
        addIfValid(toReturn, 1, 1, clickSquare, squares);
        addIfValid(toReturn, 1, -1, clickSquare, squares);
        addIfValid(toReturn, -1, -1, clickSquare, squares);
        addIfValid(toReturn, -1, 1, clickSquare, squares);
        
        return toReturn;
        
    }

    private void addIfValid(List<Square> returningList, int offsetX, int offsetY, Square clickSquare, Square[][] squares) {

        int proposedX = clickSquare.x + offsetX;
        int proposedY = clickSquare.y + offsetY;
        
        if(proposedX < 0 || proposedY < 0 || proposedX >= ChessModel.BOARD_SIZE || proposedY >= ChessModel.BOARD_SIZE)
            return;
        else
            returningList.add(squares[proposedX][proposedY]);

    }
}
