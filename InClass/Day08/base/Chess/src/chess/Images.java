/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author bricks
 */
public class Images {
    
    
    public static Image baseImage;
    public static Image kingWhite;
    public static Image queenWhite;
    public static Image rookWhite;
    public static Image bishopWhite;
    public static Image knightWhite;
    public static Image pawnWhite;
    
    public static Image kingBlack;
    public static Image queenBlack;
    public static Image rookBlack;
    public static Image bishopBlack;
    public static Image knightBlack;
    public static Image pawnBlack;
    
    public static void bootImages()
    {
        try {
            File file = new File("./src/chess/chess.png"); // I have bear.jpg in my working directory  
            FileInputStream fis;  
                fis = new FileInputStream(file);

            BufferedImage image = ImageIO.read(fis); //reading the image file  

            int rows = 2; //You should decide the values for rows and cols variables  
            int cols = 6;  
            int chunks = rows * cols;  

            int chunkWidth = 55; // determines the chunk width and height  
            int chunkHeight = 55;  
            int count = 0;  
            BufferedImage imgs[] = new BufferedImage[chunks]; //Image array to hold image chunks  
            for (int x = 0; x < rows; x++) {  
                for (int y = 0; y < cols; y++) {  
                    //Initialize the image array with image chunks  
                    imgs[count] = new BufferedImage(chunkWidth, chunkHeight, image.getType());  

                    // draws the image chunk  
                    Graphics2D gr = imgs[count++].createGraphics(); 
                    
                    
                    if(x == 0)
                        gr.drawImage(image, 0, 0, chunkWidth, chunkHeight, chunkWidth * 2 * y, chunkHeight * 2 * x, chunkWidth * 2 * y + chunkWidth, chunkHeight * 2 * x + chunkHeight, null);  
                    else
                        gr.drawImage(image, 0, 0, chunkWidth, chunkHeight, chunkWidth * 2 * y, 95, chunkWidth * 2 * y + chunkWidth, 153, null);  
                    gr.dispose();  
                }  
            }
            
            
            ///Now go through and put the images into the right variables
            
            kingBlack = imgs[0];
            queenBlack = imgs[1];
            rookBlack = imgs[2];
            bishopBlack = imgs[3];
            knightBlack = imgs[4];
            pawnBlack = imgs[5];
            
            kingWhite = imgs[6];
            queenWhite = imgs[7];
            rookWhite = imgs[8];
            bishopWhite = imgs[9];
            knightWhite = imgs[10];
            pawnWhite = imgs[11];
            
        } catch (FileNotFoundException ex) {
            ///http://stackoverflow.com/questions/3153337/get-current-working-directory-in-java
            File currentDirectory = new File(new File(".").getAbsolutePath());
            System.err.println(currentDirectory.getAbsolutePath());
            Logger.getLogger(Images.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Images.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
