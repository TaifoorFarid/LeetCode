package LeetCodeProblem;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1 ,2 ,3 ,4},
                {5 ,6 ,7 ,8},
                {9,10,11,12},
                {13,14,15,16}
        };

        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int i = 0;
        int j = 0;

        ArrayList<Integer> ans = new ArrayList<>();

        while (true) {
            ans.add(matrix[i][j]);
            matrix[i][j] = 101;

            if (forward(matrix, i, j) && !(up(matrix, i, j))) {
                j++;
            } else if (down(matrix, i, j)) {
                i++;
            } else if (back(matrix, i, j)) {
                j--;
            } else if (up(matrix, i, j)) {
                i--;
            } else {
                break;
            }
        }

        return ans;
    }

    private static boolean up(int[][] matrix, int i, int j) {
        return (i > 0 && matrix[i - 1][j] != 101);
    }

    private static boolean back(int[][] matrix, int i, int j) {
        return (j > 0 && matrix[i][j - 1] != 101);
    }

    private static boolean down(int[][] matrix, int i, int j) {
        return (i < matrix.length - 1 && matrix[i + 1][j] != 101);
    }

    private static boolean forward(int[][] matrix, int i, int j) {
        return (j < matrix[i].length - 1 && matrix[i][j + 1] != 101);
    }
}
