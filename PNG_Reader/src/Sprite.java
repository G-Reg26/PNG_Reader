import java.awt.image.BufferedImage;
import java.util.ArrayList;

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

}
