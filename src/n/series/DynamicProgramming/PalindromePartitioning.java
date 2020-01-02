/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * Example
 * Given s = "aab", return:
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 */
package n.series.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public static void main(String[] args) {
        String s = "aabcb";
        PalindromePartitioning PalindromePartitioning = new PalindromePartitioning();
        System.out.println(PalindromePartitioning.partition(s).toString());

    }

    public List<List<String>> partition(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return null;
        }
        List<List<String>> results = new ArrayList<List<String>>();
        List<String> partitions = new ArrayList<String>();
        helper(s, 0, partitions, results);
        return results;
    }

    private void helper(String s, int startIndex, List<String> partitions, List<List<String>> results) {
        if (startIndex == s.length()) {
            results.add(new ArrayList<String>(partitions));
        }
        for (int i = startIndex; i < s.length(); i++) {
            String sub = s.substring(startIndex, i + 1);
            if (!checkIspalindrome(sub)) {
                continue;
            }
            partitions.add(sub);
            helper(s, i + 1, partitions, results);
            partitions.remove(partitions.size() - 1);
        }
    }

    private boolean checkIspalindrome(String sub) {
        for (int i = 0, j = sub.length() - 1; i < j; i++, j--) {
            if (sub.charAt(i) != sub.charAt(j)) {
                return false;
            }
        }
        return true;
    }

}
