package LeetCodeProblem;

import java.util.Arrays;

public class RotatedImage {
    public static void main(String[] args) {
        int[][] arr = {
                { 2,29,20,26,16,28},
                {12,27, 9,25,13,21},
                {32,33,32, 2,28,14},
                {13,14,32,27,22,26},
                {33, 1,20, 7,21, 7},
                { 4,24, 1, 6,32,34}
        };
        rotate(arr);

        for (int[] i : arr) {
            System.out.println(Arrays.toString(i));
        }
    }
    public static void rotate(int[][] matrix) {
        int s = 0;
        int e = matrix.length - 1;

        for (int i = 0; i < matrix.length - 1; i++) {
            rotateRing(matrix, s, e);
            s++;
            e--;
        }
    }

    private static void rotateRing(int[][] matrix, int s, int e) {
        int[] topL = {s, s};
        int[] topR = {s, e};
        int[] bottomL = {e, s};
        int[] bottomR =  {e, e};

        for (int i = 0; i < e - s; i++) {
            int temp = matrix[topL[0]][topL[1]];
            swap(matrix, topL, bottomL);
            swap(matrix, bottomL, bottomR);
            swap(matrix, bottomR, topR);
            matrix[topR[0]][topR[1]] = temp;

            // now modifying values to move on next block to swap
            topL[1]++;
            topR[0]++;
            bottomL[0]--;
            bottomR[1]--;
        }
    }

    private static void swap(int[][] matrix, int[] topL, int[] bottomL) {
        int temp = matrix[topL[0]][topL[1]];
        matrix[topL[0]][topL[1]] = matrix[bottomL[0]][bottomL[1]];
        matrix[bottomL[0]][bottomL[1]] = temp;
    }
}
