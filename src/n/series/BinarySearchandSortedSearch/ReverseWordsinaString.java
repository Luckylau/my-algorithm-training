package n.series.BinarySearchandSortedSearch;

/**
 * Given an input string, reverse the string word by word.
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 * Clarification
 * What constitutes a word?
 * A sequence of non-space characters constitutes a word.
 * Could the input string contain leading or trailing spaces?
 * Yes. However, your reversed string should not contain leading or trailing spaces.
 * How about multiple spaces between two words?
 * Reduce them to a single space in the reversed string.
 */
public class ReverseWordsinaString {

    public static void main(String[] args) {
        String s = "a good man is me";
        System.out.println(s);
        ReverseWordsinaString reverseWordsinaString = new ReverseWordsinaString();
        System.out.println(reverseWordsinaString.reverseWords(s));
    }

    public String reverseWords(String s) {
        if (s == null || s.length() == 0 || s.indexOf(" ") == -1) {
            return s;
        }

        String[] strs = s.split(" ");
        if (strs.length == 0) {
            return s;
        }

        StringBuffer sb = new StringBuffer();
        for (int i = strs.length - 1; i >= 0; i--) {
            sb.append(strs[i] + " ");
        }

        return sb.substring(0, sb.length() - 1).toString();
    }

}
