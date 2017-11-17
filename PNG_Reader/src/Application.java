import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Application {
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    
    BufferedImage img = null;
    
    try {
      img = ImageIO.read(new File("cropedtestimage.png"));
    } catch (IOException e) {
      System.out.println("Failed to get Image");
    }
    
    int area = img.getHeight() * img.getWidth();

    int[] pixel = new int[area];
    int[] placeHolder;
    
    int counter = 0;
    
    for (int i = 0; i < img.getHeight(); i += 2) {
      for (int j = 0; j < img.getWidth(); j += 1) {
        placeHolder = img.getRaster().getPixel(j, i, new int[4]);
        pixel[counter] = placeHolder[0];
        
        counter++ ;
      }
    }
    double averageTotal = 0;
    for (int q = 0; q < pixel.length; q++) {
      averageTotal += (double)pixel[q];
    }
    double averagelight=averageTotal/(area/2);
    System.out.println("This is the average light value " + averagelight);
  }

}
