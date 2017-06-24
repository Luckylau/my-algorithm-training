/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * Notice
 * This problem have two method which is Greedy and Dynamic Programming.
 * The time complexity of Greedy method is O(n).
 * The time complexity of Dynamic Programming method is O(n^2).
 * We manually set the small data set to allow you pass the test in both ways.
 * This is just to let you learn how to use this problem in dynamic programming ways. 
 * If you finish it in dynamic programming ways, you can try greedy method to make it accept again.
 */
package chapter5;

public class JumpGame {
	//Time Limit Exceeded
	public boolean canJumpb(int[] A) {
        // wirte your code here
        boolean [] can = new boolean[A.length];
        can[0] = true;
        for (int i = 1 ; i < A.length ; i++) {
            for (int j = 0 ; j < i ; j++) {
                 if (can[j] && j + A[j] >= i) {
                     can[i] = true;
                     break;
                 }
            }
           
        }
        return can[A.length - 1];
    }
	public boolean canJump(int[] A) {
        // wirte your code here
       if (A == null || A.length == 0) {
           return false;
       }
       int farthest = A[0];
       for (int i = 1; i < A.length; i++) {
           if (i <= farthest && i + A[i] > farthest) {
               farthest = i + A[i];
           }
       }
       return farthest >= A.length - 1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a = new int [] {2,2,0,1,4};
		JumpGame jumpGame = new JumpGame();
 		System.out.println(jumpGame.canJumpb(a));
 		System.out.println(jumpGame.canJump(a));


	}

}
