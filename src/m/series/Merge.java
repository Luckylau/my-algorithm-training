package m.series;

/**
 * 88. 合并两个有序数组
 *
 * @Author luckylau
 * @Date 2022/4/30
 */
public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int merge = m + n - 1;
        int index1 = m - 1;
        int index2 = n - 1;
        while (index1 >= 0 && index2 >= 0) {
            if (nums1[index1] > nums2[index2]) {
                nums1[merge--] = nums1[index1--];
            } else {
                nums1[merge--] = nums2[index2--];
            }
        }
        if (index1 >= 0) {
            while (index1 >= 0) {
                nums1[merge--] = nums1[index1--];
            }
        }
        if (index2 >= 0) {
            while (index2 >= 0) {
                nums1[merge--] = nums2[index2--];
            }
        }
    }
}
