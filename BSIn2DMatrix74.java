import java.lang.reflect.Array;
import java.util.Arrays;

public class BSIn2DMatrix74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int s = 0;
        int e = matrix.length - 1;
        int col = matrix[0].length - 1;

        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (matrix[mid][0] <= target && target <= matrix[mid][col]) {
                return BS(matrix[mid], target);
                // return Arrays.binarySearch(matrix[mid], target) >= 0;
            } else if (target < matrix[mid][0]) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return false;
    }

    private boolean BS(int[] row, int target) {
        int s = 0;
        int e = row.length - 1;

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (row[mid] == target) {
                return true;
            } else if (target < row[mid]) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return false;
    }
}
