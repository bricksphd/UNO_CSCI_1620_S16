/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

/**
 *
 * @author bricks
 */
class ChessPanel extends JPanel implements MouseListener{

    
    int squareWidth = 100;
    int pieceBuffer = 2;
    
    ChessModel chessModel;
    
    
    public ChessPanel(ChessModel inModel) {
        super();
        this.chessModel = inModel;
        
        this.setPreferredSize(new Dimension(squareWidth * ChessModel.BOARD_SIZE, squareWidth * ChessModel.BOARD_SIZE));
        
        this.addMouseListener(this);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        int width = this.getWidth();
        int height = this.getHeight();
        
        g.setColor(Color.WHITE);
        
        g.fillRect(0, 0, width, height);
        
        for(int y = 0; y < ChessModel.BOARD_SIZE; y++)
        {
            for(int x = 0; x < ChessModel.BOARD_SIZE; x++)
            {
                Color squareColor = Color.DARK_GRAY;
                if((x + ( y % 2)) % 2 == 0)
                    squareColor = Color.LIGHT_GRAY;
                
                g.setColor(squareColor);
                g.fillRect(x * squareWidth, y * squareWidth, squareWidth, squareWidth);
                
                if(chessModel.currentlySelectedPiece != null && chessModel.squares[x][y].piece == chessModel.currentlySelectedPiece)
                {
                    g.setColor(Color.GREEN);
                    g.fillOval(x * squareWidth, y * squareWidth, squareWidth, squareWidth);
                }
                
                if(chessModel.possibleMoveSquares.contains(chessModel.squares[x][y]))
                {
                    g.setColor(Color.BLUE);
                    g.fillOval(x * squareWidth, y * squareWidth, squareWidth, squareWidth);
                }
                
                
                Square currentSquare = chessModel.squares[x][y];
                
                if(currentSquare.piece == null) continue;
                
                ///else if their is a piece
                Piece currentPiece = currentSquare.piece;
                
                g.drawImage(currentPiece.getImage(), x * squareWidth + pieceBuffer, y * squareWidth + pieceBuffer, squareWidth - pieceBuffer * 2, squareWidth - pieceBuffer * 2, this);
            }
        }
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        ///Get the x and y location in terms of squares
        int squareX = e.getX() / squareWidth;
        int squareY = e.getY() / squareWidth;
        
        chessModel.respondToClick(squareX, squareY);
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
    
    
    
}
