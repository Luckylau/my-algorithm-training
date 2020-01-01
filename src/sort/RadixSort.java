package sort;

import java.util.Arrays;

public class RadixSort {

    public static void main(String[] args) {
        int[] nums = {200, 1, 3, 42, 9, 64, 7, 81, 5, 10, 52, 61};
        System.out.println(Arrays.toString(nums));
        RadixSort RadixSort = new RadixSort();
        RadixSort.radixSort(nums, 10, 3);
        System.out.println(Arrays.toString(nums));

    }

    public void radixSort(int[] nums, int radix, int digit) {
        if (nums.length == 0) {
            return;
        }
        int[] tmp = new int[nums.length];
        int[] buckets = new int[radix];
        for (int i = 0, rate = 1; i <= digit; i++) {
            Arrays.fill(buckets, 0);
            System.arraycopy(nums, 0, tmp, 0, nums.length);

            for (int j = 0; j < nums.length; j++) {
                int subKey = (nums[j] / rate) % radix;
                buckets[subKey]++;
            }
            for (int j = 1; j < radix; j++) {
                buckets[j] = buckets[j] + buckets[j - 1];
            }

            for (int k = nums.length - 1; k >= 0; k--) {
                int subKey = (tmp[k] / rate) % radix;
                nums[--buckets[subKey]] = tmp[k];
            }
            rate *= radix;
        }
    }

}
