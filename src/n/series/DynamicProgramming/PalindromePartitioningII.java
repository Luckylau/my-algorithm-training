/**
 * Given a string s, cut s into some substrings such that every substring is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * 
 */
package n.series.DynamicProgramming;

public class PalindromePartitioningII {
	
	public int minCut(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }
        boolean[][] isPalindrome =getPalindrome(s);
        int[] f = new int[s.length() + 1];
        f[0] = 0;
        for (int i = 1 ; i <= s.length(); i++) {
            f[i] = Integer.MAX_VALUE;
            for (int j = 0 ; j < i ; j++) {
                if (isPalindrome[j][i - 1]) {
                    f[i] = Math.min(f[i], f[j] + 1);
                }
            }
        }
        return f[s.length()] - 1;
    }
    
    private boolean[][] getPalindrome(String s) {
        boolean[][] res = new boolean[s.length()][s.length()];
        for (int i = 0 ; i < s.length(); i++) {
            res[i][i] = true;
        }
        for (int i = 0 ; i < s.length() - 1; i++) {
            res[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
        }
        for (int length = 2; length < s.length(); length++) {
            for (int i = 0 ; i + length < s.length(); i++) {
                res[i][i + length] = res[i + 1][i + length - 1]&&s.charAt(i) == s.charAt(i + length);
            }
        }
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ababbbabbaba";
		PalindromePartitioningII PalindromePartitioningII = new PalindromePartitioningII();
		System.out.println(PalindromePartitioningII.minCut(s));

	}

}
