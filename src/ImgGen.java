import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class ImgGen{
    int cellSize =2;
    BufferedImage img = null;
    File file = null;
    int width;
    int height;

    public ImgGen(int width, int height){
        this.width=(width)*cellSize+1;
        this.height=(height)*cellSize+1;
       // img = new BufferedImage(500, 500, BufferedImage.TYPE_INT_ARGB);
        img = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_ARGB);
    }

//black: -16777216
//1745721352 zielony
    //249870371 beżowy

    void editImg(boolean pixels[][]) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j ++) {
                img.setRGB(i, j, 249856371);
            }
        }

     //  for (int i = 0; i < width; i=i+cellSize) {
     //      for (int j = 0; j < height; j ++) {
     //          img.setRGB(i, j, -16777216);
     //      }
     //  }

     //  for (int i = 0; i < width; i++) {
     //      for (int j = 0; j < height; j=j+cellSize) {
     //          img.setRGB(i, j, -16777216);
     //      }
     //  }

        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[0].length; j++) {
                if(pixels[i][j]){
                    img.setRGB(i, j, 1745721352);
                }
            }
        }


        System.out.println("Edytowano obrazek");
    }


    void editImg() {

        int a = (int)(Math.random()*256); //alpha
        int r = (int)(Math.random()*256); //red
        int g = (int)(Math.random()*256); //green
        int b = (int)(Math.random()*256); //blue
        int p = (a<<24) | (r<<16) | (g<<8) | b; //pixel

        System.out.println(p);

        for (int i = 0; i < 500; i ++) {
            for (int j = 0; j < 500; j ++) {
                img.setRGB(i, j, p);
                //img.setRGB(i, j, pixels[i][j]);
            }
        }
        System.out.println("Edytowano obrazek");
    }

    void saveImg() {
        try {
            BufferedImage toSave = img;
            File outputfile = new File("maze.png");
            ImageIO.write(toSave, "png", outputfile);
            System.out.println("Zapisano pomyślnie");
        } catch (IOException e) {
            System.out.println("Błąd zapisu!");
        }
    }





}



//    //image dimension
//    int width = 640;
//    int height = 320;
//    //create buffered image object img
//    BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
//    //file object
//    File f = null;