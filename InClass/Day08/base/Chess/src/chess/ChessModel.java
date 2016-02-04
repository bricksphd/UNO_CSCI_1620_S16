/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bricks
 */
class ChessModel {
    
    static public int BOARD_SIZE = 8;
    
    
    ChessFrame viewFrame;
    
    Square[][] squares;
    
    Piece currentlySelectedPiece = null;
    
    List<Square> possibleMoveSquares = new ArrayList<Square>();
    
    public void setViewFrame(ChessFrame inViewFrame)
    {
        this.viewFrame = inViewFrame;
        squares = new Square[BOARD_SIZE][BOARD_SIZE];
        for(int y = 0; y  < BOARD_SIZE; y++)
        {
            for(int x = 0; x < BOARD_SIZE; x++)
            {
                squares[x][y] = new Square(x, y);
            }
        }
        
        squares[0][0].piece = new Rook(Side.Black);
        squares[1][0].piece = new Knight(Side.Black);
        squares[2][0].piece = new Bishop(Side.Black);
        squares[3][0].piece = new King(Side.Black);
        squares[4][0].piece = new Queen(Side.Black);
        squares[5][0].piece = new Bishop(Side.Black);
        squares[6][0].piece = new Knight(Side.Black);
        squares[7][0].piece = new Rook(Side.Black);
        
        for(int x = 0; x < BOARD_SIZE; x++)
        {
            squares[x][1].piece = new Pawn(Side.Black);
        }
        
        squares[0][7].piece = new Rook(Side.White);
        squares[1][7].piece = new Knight(Side.White);
        squares[2][7].piece = new Bishop(Side.White);
        squares[3][7].piece = new King(Side.White);
        squares[4][7].piece = new Queen(Side.White);
        squares[5][7].piece = new Bishop(Side.White);
        squares[6][7].piece = new Knight(Side.White);
        squares[7][7].piece = new Rook(Side.White);
        
        for(int x = 0; x < BOARD_SIZE; x++)
        {
            squares[x][6].piece = new Pawn(Side.White);
        }
        
        viewFrame.Update();
        
        
        
    }
    
    public void respondToClick(int squareX, int squareY)
    {
        final Square clickSquare = squares[squareX][squareY];
        final Piece clickPiece = clickSquare.piece;
        
        ///If you didn't click on any piece and nothing is selected, then do nothing
        if(clickPiece == null && currentlySelectedPiece == null) return;
        
        if(currentlySelectedPiece != null)
        {
            if(possibleMoveSquares.contains(clickSquare))
            {
                clickSquare.piece = currentlySelectedPiece;
                currentlySelectedPiece = null;
                possibleMoveSquares.clear();
                for(int x = 0; x < BOARD_SIZE; x++)
                {
                    for(int y = 0; y < BOARD_SIZE; y++)
                    {
                        if(squares[x][y].piece == clickSquare.piece && squares[x][y] != clickSquare)
                        {
                            squares[x][y].piece = null;
                            break;
                        }
                    }
                }
            } 
            else
            {
                if(clickPiece != null)
                {
                    currentlySelectedPiece = clickPiece;
                    possibleMoveSquares = clickPiece.getPossibleMoves(clickSquare, squares);

                }
                else
                {
                    currentlySelectedPiece = null;
                    possibleMoveSquares.clear();
                }
            }
        }
        
        else if(clickPiece != null && currentlySelectedPiece == null)
        {
            currentlySelectedPiece = clickPiece;
            possibleMoveSquares = clickPiece.getPossibleMoves(clickSquare, squares);
        }
        
         
        
        viewFrame.Update();
    }
    
}
