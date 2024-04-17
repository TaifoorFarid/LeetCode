// https://leetcode.com/problems/set-matrix-zeroes/
// 2 ms Solution
class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
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

    private void fillCol(int[][] matrix, int col) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }
}
