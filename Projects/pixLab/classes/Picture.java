import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from
 * SimplePicture and allows the student to add functionality to
 * the Picture class.
 *
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture {
    ///////////////////// constructors //////////////////////////////////
    /**
     * Constructor that takes no arguments
     */
    public Picture () {
        /* not needed but use it to show students the implicit call to super()
         * child constructors always call a parent constructor
         */
        super();
    }

    /**
     * Constructor that takes a file name and creates the picture
     * @param fileName the name of the file to create the picture from
     */
    public Picture(String fileName) {
        // let the parent class handle this fileName
        super(fileName);
    }

    /**
     * Constructor that takes the width and height
     * @param height the height of the desired picture
     * @param width the width of the desired picture
     */
    public Picture(int height, int width) {
        // let the parent class handle this width and height
        super(width, height);
    }

    /**
     * Constructor that takes a picture and creates a
     * copy of that picture
     * @param copyPicture the picture to copy
     */
    public Picture(Picture copyPicture) {
        // let the parent class do the copy
        super(copyPicture);
    }

    /**
     * Constructor that takes a buffered image
     * @param image the buffered image to use
     */
    public Picture(BufferedImage image) {
        super(image);
    }

    ////////////////////// methods ///////////////////////////////////////

    /**
     * Method to return a string with information about this picture.
     * @return a string with information about the picture such as fileName,
     * height and width.
     */
    public String toString() {
        String output = "Picture, filename " + getFileName() +
                        " height " + getHeight()
                        + " width " + getWidth();
        return output;

    }

    /** Method to set the blue to 0 */
    public void zeroBlue() {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                pixelObj.setBlue(0);
            }
        }
    }

    public void keepOnlyBlue() {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                pixelObj.setRed(0);
                pixelObj.setGreen(0);
            }
        }
    }

    /** copy from the passed fromPic to the
     * specified startRow and startCol in the
     * current picture
     * @param fromPic the picture to copy from
     * @param startRow the start row to copy to
     * @param startCol the start col to copy to
     */
    public void copy(Picture fromPic,
                     int startRow, int startCol) {
        Pixel fromPixel = null;
        Pixel toPixel = null;
        Pixel[][] toPixels = this.getPixels2D();
        Pixel[][] fromPixels = fromPic.getPixels2D();
        for (int fromRow = 0, toRow = startRow; fromRow < fromPixels.length && toRow < toPixels.length; fromRow++, toRow++) {
            for (int fromCol = 0, toCol = startCol; fromCol < fromPixels[0].length && toCol < toPixels[0].length; fromCol++, toCol++) {
                fromPixel = fromPixels[fromRow][fromCol];
                toPixel = toPixels[toRow][toCol];
                toPixel.setColor(fromPixel.getColor());
            }
        }
    }

    public void negate() {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                pixelObj.setRed(255 - pixelObj.getRed());
                pixelObj.setGreen(255 - pixelObj.getGreen());
                pixelObj.setBlue(255 - pixelObj.getBlue());
            }
        }
    }

    public void grayscale() {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels) {
            for (Pixel PixelObj : rowArray) {
                int average = (PixelObj.getRed() + PixelObj.getBlue() + PixelObj.getGreen()) / 3;
                PixelObj.setRed(average);
                PixelObj.setGreen(average);
                PixelObj.setBlue(average);
            }
        }
    }

    public void fixUnderwater() {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels) {
            for (Pixel PixelObj : rowArray) {
                PixelObj.setRed(PixelObj.getRed() * 5);
            }
        }
    }

    public void mirrorDiagonal() {
        Pixel[][] pixels = this.getPixels2D();
        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0; col < pixels.length; col++) {
                if (col > row) {
                    pixels[col][row].setColor(pixels[row][col].getColor());
                }
            }
        }
    }

    public void mirrorDiagonal2() {
        Pixel[][] pixels = this.getPixels2D();
        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0; col < pixels.length; col++) {
                if (col > row) {
                    pixels[row][col].setColor(pixels[col][row].getColor());
                }
            }
        }
    }

    public void mirrorDiagonal3() {
        //Same as mirrorDiagonal, but flipped.
        Pixel[][] pixels = this.getPixels2D();
        Pixel bottomLeftPixel = null;
        Pixel topRightPixel = null;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0; col < row; col++) {
                bottomLeftPixel = pixels[row][col];
                topRightPixel = pixels[pixels.length - 1 - row][pixels.length - 1 - col];
                topRightPixel.setColor(bottomLeftPixel.getColor());
            }
        }
    }

    /** Method that mirrors the picture around a
     * vertical mirror in the center of the picture
     * from left to right */
    public void mirrorVertical() {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0; col < width / 2; col++) {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][width - 1 - col];
                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }

    public void mirrorVerticalRightToLeft() {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length; row++) {
            for (int col = width / 2; col > 0 / 2; col--) {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][width - 1 - col];
                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }

    public void mirrorHorizontal() {
        Pixel[][] pixels = this.getPixels2D();
        Pixel topPixel = null;
        Pixel bottomPixel = null;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length / 2; row++) {
            for (int col = 0; col < width; col++) {
                topPixel = pixels[row][col];
                bottomPixel = pixels[pixels.length - 1 - row][col];
                bottomPixel.setColor(topPixel.getColor());
            }
        }
    }

    public void mirrorHorizontalBotToTop() {
        Pixel[][] pixels = this.getPixels2D();
        Pixel topPixel = null;
        Pixel bottomPixel = null;
        int width = pixels[0].length;
        for (int row = pixels.length - 1; row > 0; row--) {
            for (int col = 0; col < width; col++) {
                bottomPixel = pixels[row][col];
                topPixel = pixels[pixels.length - 1 - row][col];
                topPixel.setColor(bottomPixel.getColor());
            }
        }
    }

    /** Mirror just part of a picture of a temple */
    public void mirrorTemple() {
        int mirrorPoint = 276;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int count = 0;
        Pixel[][] pixels = this.getPixels2D();

        // loop through the rows
        for (int row = 27; row < 97; row++) {
            // loop from 13 to just before the mirror point
            for (int col = 13; col < mirrorPoint; col++) {
                count++;
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
                rightPixel.setColor(leftPixel.getColor());
            }
            System.out.println(count);
        }
    }

    public void mirrorArms() {
        Pixel[][] pixels = this.getPixels2D();
        int mirrorPoint = 193;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        // loop through the rows
        for (int row = 163; row < 225; row++) {
            // loop from some number to just before the mirror point
            for (int col = 90; col < 300; col++) {
                leftPixel = pixels[row][col];
                rightPixel = pixels[mirrorPoint - row + mirrorPoint][col];
                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }

    public void mirrorGull() {
        Pixel[][] pixels = this.getPixels2D();
        int mirrorPoint = 350;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        // loop through the rows
        for (int row = 230; row < 330; row++) {
            // loop from some number to just before the mirror point
            for (int col = 220; col < mirrorPoint; col++) {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][col + 130];
                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }

    /** Method to create a collage of several pictures */
    public void createCollage() {
        Picture flower1 = new Picture("flower1.jpg");
        Picture flower2 = new Picture("flower2.jpg");
        this.copy(flower1, 0, 0);
        this.copy(flower2, 100, 0);
        this.copy(flower1, 200, 0);
        Picture flowerNoBlue = new Picture(flower2);
        flowerNoBlue.zeroBlue();
        this.copy(flowerNoBlue, 300, 0);
        this.copy(flower1, 400, 0);
        this.copy(flower2, 500, 0);
        this.mirrorVertical();
        this.write("/Users/mcheng5/Desktop/APCompSci/Projects/pixLab/classes/collage.jpg");
    }

    public void copy(Picture fromPic, int origStartRow, int origStartCol, int finalStartRow, int finalStartCol, int origEndRow, int origEndCol, int finalEndRow, int finalEndCol) {
        Pixel fromPixel = null;
        Pixel toPixel = null;
        Pixel[][] toPixels = this.getPixels2D();
        Pixel[][] fromPixels = fromPic.getPixels2D();
        for (int fromRow = origStartRow, toRow = finalStartRow; fromRow < origEndRow && toRow < origEndRow; fromRow++, toRow++) {
            for (int fromCol = origStartCol, toCol = finalStartCol; fromCol < origEndCol && toCol < finalEndCol; fromCol++, toCol++) {
                fromPixel = fromPixels[fromRow][fromCol];
                toPixel = toPixels[toRow][toCol];
                toPixel.setColor(fromPixel.getColor());
            }
        }
    }

    public void createCollage2() {
        Picture flower1 = new Picture("flower1.jpg");
        Picture flower2 = new Picture("flower2.jpg");
        this.copy(flower1, 0, 28, 0, 28, 35, 70, 100, 100);
        this.copy(flower2, 20, 20, 0, 100, 60, 60, 160, 160);
        this.copy(flower1, 200, 0);
        Picture flowerNoBlue = new Picture(flower2);
        flowerNoBlue.zeroBlue();
        this.copy(flowerNoBlue, 300, 0);
        this.copy(flower1, 400, 0);
        this.copy(flower2, 500, 0);
        this.mirrorVertical();
        this.write("/Users/mcheng5/Desktop/APCompSci/Projects/pixLab/classes/collage.jpg");
    }

    /** Method to show large changes in color
     * @param edgeDist the distance for finding edges
     */
    public void edgeDetection(int edgeDist) {
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        Pixel bottomPixel = null;
        Pixel topPixel = null;
        Pixel[][] pixels = this.getPixels2D();
        Color rightColor = null;
        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0; col < pixels[0].length - 1; col++) {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][col + 1];
                rightColor = rightPixel.getColor();
                if (leftPixel.colorDistance(rightColor) > edgeDist)
                    leftPixel.setColor(Color.BLACK);
                else
                    leftPixel.setColor(Color.WHITE);
            }
        }
        for (int row = 0; row < pixels.length - 1; row++) {
            for (int col = 0; col < pixels[0].length - 1; col++) {
                topPixel = pixels[row][col];
                bottomPixel = pixels[row + 1][col ];
                rightColor = rightPixel.getColor();
                if (leftPixel.colorDistance(rightColor) > edgeDist)
                    leftPixel.setColor(Color.BLACK);
                else
                    leftPixel.setColor(Color.WHITE);
            }
        }
    }

    /* Main method for testing - each class in Java can have a main
     * method
     */
    public static void main(String[] args) {
        Picture swan = new Picture("swan.jpg");
        //swan.explore();
        swan.edgeDetection(10);
        swan.explore();
    } // this } is the end of class Picture, put all new methods before this
}
