import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

class ImgGen{
    private BufferedImage img = null;
    private int width;
    private int height;

    ImgGen(int width, int height){
        this.width=(width)*2+1;
        this.height=(height)*2+1;
        img = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_RGB);
    }

    void editImg(boolean pixels[][]) {

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j ++) {
                img.setRGB(i, j, 14016231);
            }
        }

       for (int i = 0; i < pixels.length; i++) {
           for (int j = 0; j < pixels[0].length; j++) {
               if(pixels[i][j]){
                   img.setRGB(i, j, 5007237);
               }
           }
       }
    }

    void saveImg() {
        try {
            BufferedImage toSave = img;
            File outputfile = new File("maze.png");
            ImageIO.write(toSave, "png", outputfile);
        } catch (IOException e) {
            System.out.println("Saving error!");
        }
    }
}

