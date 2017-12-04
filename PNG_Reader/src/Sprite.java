import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Sprite {
  private ArrayList<Integer> colorValues = new ArrayList<Integer>();
  private BufferedImage image;
  private String name;

  Sprite(BufferedImage image, String name) {
    this.image = image;
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void getColorValues() {
    int[] placeHolder;
    int counter = 0;
    
    /*
     * Get color value of each pixel in image
     * Skips every other line
     */
    
    for (int i = 0; i < image.getHeight(); i += 2) {
      for (int j = 0; j < image.getWidth(); j += 1) {
        placeHolder = image.getRaster().getPixel(j, i, new int[4]);
        colorValues.add(counter, placeHolder[0]);
        counter++;
      }
    }
  }

  public int getSumOfColorValues() {
    int sum = 0;

    for (int i = 0; i < colorValues.size(); i++) {
      sum += colorValues.get(i);
    }

    return sum;
  }
  
  public double getAverageColorValue() {
    double sum = 0.0;

    for (int i = 0; i < colorValues.size(); i++) {
      sum += colorValues.get(i);
    }

    return sum / colorValues.size();
  }
  
  
  public void generateImage() {
    
    BufferedImage outputImage = new BufferedImage(image.getWidth(), image.getHeight()/2, BufferedImage.TYPE_INT_RGB);
    
    int [] rgb = new int[3];
    
    for (int i = 0; i < image.getHeight()/2; i++) {
      for (int j = 0; j < image.getWidth(); j++) {
        
        rgb[0] = colorValues.get(j + (image.getWidth() * i));
        rgb[1] = colorValues.get(j + (image.getWidth() * i));
        rgb[2] = colorValues.get(j + (image.getWidth() * i));
        
        outputImage.getRaster().setPixel(j, i, rgb);
      }
    }
    
    try {
      File outputFile = new File("C:\\Users\\gregl\\OneDrive\\Pictures\\testFolder2\\output\\outputImage.png");
      ImageIO.write(outputImage, "png", outputFile);
    }
    catch (Exception e) {
      System.out.println("Failed to output image.");
    }
  }
  
}
