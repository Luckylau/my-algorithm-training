/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * <p>
 * Example
 * Given array A = [2,3,1,1,4]
 * The minimum number of jumps to reach the last index is 2.
 * (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 */
package n.series.DynamicProgramming;

public class JumpGameII {
    public static void main(String[] args) {
        int[] a = new int[]{3, 2, 1, 0, 4};
        int[] b = new int[]{2, 2, 0, 1, 4};
        JumpGameII jumpGameII = new JumpGameII();
        System.out.println(jumpGameII.jump(a));
        System.out.println(jumpGameII.jump(b));

    }

    //Time Limit Exceeded
    public int jumpb(int[] A) {
        // write your code here
        int[] steps = new int[A.length];
        steps[0] = 0;
        for (int i = 1; i < A.length; i++) {
            steps[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (steps[j] != Integer.MAX_VALUE && j + A[j] >= i) {
                    steps[i] = Math.min(steps[i], steps[j] + 1);
                }
            }
        }
        return steps[A.length - 1];

    }

    public int jump(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return -1;
        }
        if (!checkOnreachable(A)) {
            return -1;
        }
        int start = 0, end = 0, jumps = 0;
        while (end < A.length - 1) {
            jumps++;
            int farthest = end;
            for (int i = start; i <= end; i++) {
                if (farthest < i + A[i]) {
                    farthest = i + A[i];
                }
            }
            start = end + 1;
            end = farthest;
        }
        return jumps;
    }

    private boolean checkOnreachable(int[] A) {
        int farthest = A[0];
        for (int i = 1; i < A.length; i++) {
            if (farthest >= i && farthest < i + A[i]) {
                farthest = i + A[i];
            }
        }
        return farthest > A.length - 1;
    }

}
