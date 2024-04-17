// https://leetcode.com/problems/spiral-matrix/
// 0 ms Solution
class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
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

    private boolean up(int[][] matrix, int i, int j) {
        return (i > 0 && matrix[i - 1][j] != 101);
    }

    private boolean back(int[][] matrix, int i, int j) {
        return (j > 0 && matrix[i][j - 1] != 101);
    }

    private boolean down(int[][] matrix, int i, int j) {
        return (i < matrix.length - 1 && matrix[i + 1][j] != 101);
    }

    private boolean forward(int[][] matrix, int i, int j) {
        return (j < matrix[i].length - 1 && matrix[i][j + 1] != 101);
    }
}
