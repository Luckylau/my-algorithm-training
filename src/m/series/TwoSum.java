package m.series;

import java.util.HashMap;
import java.util.Map;

/**
 * 1.两数之和
 *
 * @Author luckylau
 * @Date 2021/4/15
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int[] res = new int[]{-1, -1};
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!hash.containsKey(target - nums[i])) {
                hash.put(nums[i], i);
            } else {
                res[0] = i;
                res[1] = hash.get(target - nums[i]);
            }
        }
        return res;
    }
}
