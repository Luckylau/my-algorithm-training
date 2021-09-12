package m.series;

/**
 * 接雨水
 *
 * @Author luckylau
 * @Date 2021/4/15
 */
public class Trap {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int maxLeft = 0;
        int maxRight = 0;
        int res = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (maxLeft < height[left]) {
                    maxLeft = height[left];
                } else {
                    res += maxLeft - height[left];
                }
                left++;
            } else {
                if (maxRight < height[right]) {
                    maxRight = height[right];
                } else {
                    res += maxRight - height[right];
                }
                right--;
            }
        }
        return res;

    }
}
