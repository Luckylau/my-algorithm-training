/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * 
 * 
 */
package chapter5;

public class ClimbingStairs {
	
	public int climbStairs(int n) {
        // write your code here
        if (n == 0 || n == 1) {
            return 1;
        }
        int last = 1 , lastlast = 1;
        int now = 0;
        for (int i = 2; i <= n; i++) {
            now = last + lastlast;
            lastlast = last;
            last = now;
        }
        return now;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 7;
		ClimbingStairs climbingStairs = new ClimbingStairs();
		System.out.println(climbingStairs.climbStairs(7));

	}

}
