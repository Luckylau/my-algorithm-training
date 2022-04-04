package n.series.dynamicprogramming;

/**
 * @Author luckylau
 * @Date 2022/3/31
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * extend:
 * if you can climb 1 or 2 , ... , n steps,how many distinct ways can you climb to the top?
 * if you can climb 1, or 2 , 3 ,how many distinct ways can you climb to the top?
 */
public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 4;
        ClimbingStairs climbingStairs = new ClimbingStairs();
        System.out.println(climbingStairs.climbStairs(n));
        System.out.println(climbingStairs.climbStairs2(n));
        System.out.println(climbingStairs.climbStairs3(n));

    }

    /**
     * question1
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        // write your code here
        if (n == 0 || n == 1) {
            return 1;
        }
        int last = 1, lastlast = 1;
        int now = 0;
        for (int i = 2; i <= n; i++) {
            now = last + lastlast;
            lastlast = last;
            last = now;
        }
        return now;
    }

    /**
     * 见：/Users/yrd/Documents/github/my-algorithm-training/src/o/series/JumpFloorII.java
     * question2
     *
     * @param n
     * @return
     */
    @Deprecated
    public int climbStairs2(int n) {
        int m = 0;
        if (n == 0) return m = 1;
        if (n == 1) return m = 1;
        if (n >= 2) {
            for (int i = n - 1; i >= 0; i--) {
                m += climbStairs2(i);
            }
        }
        return m;
    }

    /**
     * question3
     *
     * @param n
     * @return
     */
    public int climbStairs3(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;
        int last = 2, lastlast = 1, lastlastlast = 1;
        int now = 0;
        for (int i = 3; i <= n; i++) {
            now = last + lastlast + lastlastlast;
            lastlastlast = lastlast;
            lastlast = last;
            last = now;
        }
        return now;
    }

}
