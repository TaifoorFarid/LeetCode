package LeetCodeProblem;

import java.util.ArrayList;
import java.util.Arrays;

public class SetMatrixZeroes {

    public static void main(String[] args) {
        int[][] matrix = {
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}
        };
        setZeroes(matrix);

        for (int[] i : matrix) {
            System.out.println(Arrays.toString(i));
        }
    }
    public static void setZeroes(int[][] matrix) {
        ArrayList<ArrayList<Integer>> zero = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    ArrayList<Integer> index = new ArrayList<>();
                    index.add(i);
                    index.add(j);
                    zero.add(index);
                }
            }
        }

        for (ArrayList<Integer> index : zero) {
            //filling row with zero
            Arrays.fill(matrix[index.get(0)], 0);
            //filling col with zeroes
            fillCol(matrix, index.get(1));
        }
    }

    private static void fillCol(int[][] matrix, int col) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }
}
