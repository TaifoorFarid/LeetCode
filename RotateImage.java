// https://leetcode.com/problems/rotate-image/
// 0 ms Solution
class RotateImage {
    public void rotate(int[][] matrix) {
        int s = 0;
        int e = matrix.length - 1;

        for (int i = 0; i < matrix.length / 2; i++) {
            rotateRing(matrix, s, e);
            s++;
            e--;
        }
    }

    private void rotateRing(int[][] matrix, int s, int e) {
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

    private void swap(int[][] matrix, int[] topL, int[] bottomL) {
        int temp = matrix[topL[0]][topL[1]];
        matrix[topL[0]][topL[1]] = matrix[bottomL[0]][bottomL[1]];
        matrix[bottomL[0]][bottomL[1]] = temp;
    }
}
