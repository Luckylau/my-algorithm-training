package l.series;

import java.util.Arrays;

/**
 * 给一组数，找出其中不是成对出现的2个数，例如：
 * 1, 2, 4, 5, 1, 2, 6, 6, 5, 8, 9, 8
 * 结果为9, 4
 */
public class GetTwoUniqueNum {

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 5, 1, 2, 6, 6, 5, 8, 9, 8};
        GetTwoUniqueNum getTwoUniqueNum = new GetTwoUniqueNum();
        System.out.println(Arrays.toString(getTwoUniqueNum.getTwoUniqueNum(nums)));

    }

    public int[] getTwoUniqueNum(int[] nums) {
        int[] res = new int[]{0, 0};
        if (nums == null || nums.length == 0) {
            return res;
        }
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }
        int pos = getFirstOne(xor);
        for (int i = 0; i < nums.length; i++) {
            if (isOne(nums[i], pos)) {
                res[0] ^= nums[i];
            } else {
                res[1] ^= nums[i];
            }
        }
        return res;

    }

    private int getFirstOne(int num) {
        int tmp = num;
        int pos = 0;
        while ((tmp & 0x01) != 1) {
            tmp = tmp >> 1;
            pos++;
        }
        return pos;
    }

    private boolean isOne(int nums, int pos) {
        int tmp = nums;
        tmp = tmp >> pos;
        return (tmp & 0x01) == 1;
    }

}
