package org.netbeans.modules.image;

/**
 *
 *
 * @author breining
 */
public class ImageManip {

    private int[][] original;
    private int[][] blurred;
    private int row;
    private int col;

    public ImageManip(int[][] original) {
        this.original = original;
        row = original.length;
        col = original[0].length;
        blurred = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                blurred[i][j] = original[i][j];
            }
        }
        //System.arraycopy(original, 0, blurred, 0, original.length);

    }

    private double averageNeighbors(int rowIndex, int colIndex) {
        double average = 0.0;
        int sum = 0;
        
        for (int i = 1; i < row - 1; i++) {
            for (int j = 1; j < col - 1; j++) {
                sum = sum + original[rowIndex + i][colIndex + j];
                
            }
        }
         average = sum / 9;
        return average;
    }

    private void blurImage() {
        for (int i = 1; i < row - 1; i++) {
            for (int j = 1; j < col - 1; j++) {
                averageNeighbors(i, j);
            }
        }
    }

    private String originalImage() {
        StringBuilder display = new StringBuilder("");
        for (int i = 0; i < original.length; i++) {
            for (int j = 0; j < original[i].length; j++) {
                
                display.append(original[i].toString());
                display.append("\t");
            }
            System.out.println();
        }
        return display.toString();
    }

    private String blurredImage() {
        StringBuilder display = new StringBuilder("");
        for (int i = 0; i < blurred.length; i++) {
            for (int j = 0; j < blurred[i].length; j++) {
                System.out.println();
                display.append(blurred[i].toString());
                display.append("\t");
            }
        }
        return display.toString();
    }

    public static void main(String[] args) {
        int[][] data = {{78, 89, 122, 133, 145, 189},
        {84, 91, 125, 135, 158, 200},
        {95, 98, 140, 145, 178, 210,},
        {111, 121, 148, 160, 189, 225},
        {134, 146, 156, 187, 199, 230}};

        ImageManip image = new ImageManip(data);

        System.out.println("The original image is \n" + image.originalImage());
        image.blurImage();
        System.out.println("The blurred image is \n" + image.blurredImage());

    }
}
