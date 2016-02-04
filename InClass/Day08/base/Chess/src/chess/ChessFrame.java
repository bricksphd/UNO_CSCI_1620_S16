/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author bricks
 */
class ChessFrame extends JFrame {

    
    JPanel drawPanel;
    ChessModel chessModel;
    
    
    public ChessFrame(ChessModel chessModel) {
        super("Chess Game");
        
        this.chessModel = chessModel;
        this.drawPanel = new ChessPanel(chessModel);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.add(drawPanel);
        
        this.pack();
        
        this.setVisible(true);
    }
    
    
    public void Update()
    {
       drawPanel.repaint();
    }
    
}
