import java.util.Arrays;

public class FirstAndLastOccurance34 {

    public static void main(String[] args) {
        FirstAndLastOccurance34 f = new FirstAndLastOccurance34();
        System.out.println(Arrays.toString(f.searchRange(null, 0)));
    }

    public int[] searchRange(int[] nums, int target) {
        return new int[] { findFirstOcc(nums, target), findLastOcc(nums, target) };
    }

    private int findFirstOcc(int[] arr, int t) {
        int s = 0;
        int e = arr.length - 1;

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (arr[mid] == t) {
                if ((mid - 1) == -1 || arr[mid - 1] != t)
                    return mid;
                else
                    e = mid - 1;
            } else if (arr[mid] > t) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return -1;
    }

    private int findLastOcc(int[] arr, int t) {
        int s = 0;
        int e = arr.length - 1;

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (arr[mid] == t) {
                if ((mid + 1) == arr.length || arr[mid + 1] != t)
                    return mid;
                else
                    s = mid + 1;
            } else if (arr[mid] > t) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return -1;
    }
}
