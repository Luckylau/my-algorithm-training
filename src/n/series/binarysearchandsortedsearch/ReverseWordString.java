package n.series.binarysearchandsortedsearch;

/**
 * @Author luckylau
 * @Date 2022/3/30
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
public class ReverseWordString {

    public static void main(String[] args) {
        String s = "a good man is me";
        System.out.println(s);
        ReverseWordString reverseWordString = new ReverseWordString();
        System.out.println(reverseWordString.reverseWords(s));
    }

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
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
