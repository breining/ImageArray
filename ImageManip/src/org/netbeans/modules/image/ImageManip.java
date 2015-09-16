package org.netbeans.modules.image;

/**
 *
 *
 * @author breining
 */
public class ImageManip {

    private int[][] original;
    private int[][] blurred;

    public ImageManip(int[][] data) {
        this.blurred = blurred;
        this.original = original;

        blurred = new int[original.length][original.length];
        for (int i = 0; i < original.length; i++) {
            for (int j = 0; j < original.length; j++) {
                blurred[i][j] = original[i][j];
            }
        }
        //System.arraycopy(original, 0, blurred, 0, original.length);

    }

    private double averageNeighbors() {
        double average = 0;
        double sum = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                sum = sum + original[i][j];
                average = sum / original[i].length;
            }
        }
        return average;
    }

    private void blurImage() {
        for (int i = 1; i < original.length - 1; i++) {
            for (int j = 1; j < original[i].length - 1; j++) {
                averageNeighbors();
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
        }
        return display.toString();
    }

    private String blurredImage() {
        StringBuilder display = new StringBuilder("");
        for (int i = 0; i < blurred.length; i++) {
            for (int j = 0; j < blurred[i].length; j++) {
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
