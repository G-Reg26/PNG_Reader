import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Application {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    Scanner scan = new Scanner(System.in);

    ArrayList<Sprite> sprites = new ArrayList<Sprite>();

    File directory = null;

    String fileLocal = "";
    boolean exit = false;

    System.out.println("Enter location of folder:");
    fileLocal = scan.nextLine();

    System.out.println();
    
    while (!exit) {
      try {
        directory = new File(fileLocal);
        
        /**
        * For each file in folder:
        *   If file is of type .png:
        *     Add file to sprites list
        *   If failed to get image:
        *     Print "Failed to get Image"
        * Once all .png files are in sprites list:
        *   Exit while loop
        */
        
        for (File file : directory.listFiles()) {
          try {
            String extension = file.getName().substring(
                file.getName().length() - 3, file.getName().length());

            if (extension.equals("png")) {
              sprites.add(new Sprite(ImageIO.read(file), file.getName()));
            }
          } catch (IOException e) {
            System.out.println("Failed to get Image");
          }
        }

        exit = true;
        
      } catch (NullPointerException e) {
        
        /**
         * If failed to find folder:
         *  Print "Folder not found..."
         *  Enter new location
         *  If user enters "exit":
         *    Exit loop
         *    End program
         *  Else:
         *    Keep loop going
         */
        
        System.out.println("Folder not found/Invalid location\n"
            + "Enter new location (Or type 'exit' to leave program):\n"
            + "Example: C:\\Users\\gregl\\OneDrive\\Pictures\\Camera Roll");

        fileLocal = scan.nextLine();

        System.out.println();
        if (fileLocal.toUpperCase().equals("EXIT")) {
          System.out.println("Goodbye");
          exit = true;
        } else {
          exit = false;
        }
      }
    }
    
    /**
     * For each sprite in sprites list:
     *  Get sprite's color values
     *  Print sprites name along with sum of color values
     */
    for (Sprite sprite : sprites) {
      sprite.getColorValues();
      System.out.println("Sum of " + sprite.getName() + "'s color values: "
          + sprite.getSumOfColorValues());
    }
    
    System.out.println("Goodbye");

    scan.close();
  }
}
