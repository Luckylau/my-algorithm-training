package m.series.str;

/**
 * x 的平方根
 *
 * @Author luckylau
 * @Date 2021/4/15
 */
public class MySqrt {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int start = 1;
        int end = x;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int ans = x / mid;
            if (ans == mid) {
                return ans;
            }
            if (ans > mid) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end;
    }
}
