import java.util.HashMap;

public class MajorityElements169 {
    public int majorityElement(int[] nums) {
        int most = nums[0];
        int count = 1;
        int set;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            if ((set = map.getOrDefault(i, 0) + 1) > count) {
                most = i;
                count = set;
            }
            map.put(i, set);
        }

        return most;
    }
}
