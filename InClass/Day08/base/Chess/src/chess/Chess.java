/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import javax.swing.JFrame;

/**
 *
 * @author bricks
 */
public class Chess {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Images.bootImages();
        
        ChessModel chessModel = new ChessModel();
        ChessFrame mainFrame = new ChessFrame(chessModel);
        chessModel.setViewFrame(mainFrame);
        
    }
    
}
