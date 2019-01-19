/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package image;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Théophane
 */
public class ImageContainer extends JPanel{
    private Image image;
    private final int x;
    protected final int y;
    private int width;
    private int height;
    
    public ImageContainer(String path,int x, int y, int width, int height){
        super();
        this.setOpaque(false);
        this.height = height;
        this.width =width;
        this.y = y;
        this.x = x;
        
         try {
            // Transformation du fichier contenant l'image en image
            this.image =  ImageIO.read(new File(System.getProperty("user.dir")+"/src/images/" + path));
//             this.image =  ImageIO.read(new File(path));
        } catch (IOException ex) {
            System.err.println("Erreur en lecture de l'image " + path);
        }
    }

    /**
     * @return the image
     */
    public Image getImage() {
        return image;
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, x, y, width, height, null, this);
    }
   
}
