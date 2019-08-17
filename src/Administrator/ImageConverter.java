/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administrator;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javax.imageio.ImageIO;

/**
 *
 * @author Dominic
 */
public class ImageConverter {
    
    //convert from javafx image to byte array
    
    public static byte[] convertToByteArrauy(Image img){
        
        return convertToByteArrauy(img, "png");
    }

public static byte[] convertToByteArrauy(Image img, String imageFormat){
        
        BufferedImage bImg = SwingFXUtils.fromFXImage(img, null);
        ByteArrayOutputStream baOS = new ByteArrayOutputStream();
        try{
        ImageIO.write(bImg, imageFormat, baOS);
        byte[] imageInBytes = baOS.toByteArray();
        baOS.close();
        return imageInBytes;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
}
