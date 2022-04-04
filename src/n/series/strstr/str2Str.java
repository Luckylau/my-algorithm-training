package n.series.strstr;

/**
 * @Author luckylau
 * @Date 2022/3/31
 * For a given source string and a target string, you should output the first index(from 0) of target string in source string.
 * If target does not exist in source, just return -1.
 * Clarification
 * Do I need to implement KMP Algorithm in a real interview?
 * Not necessary. When you meet this problem in a real interview, the interviewer may just want to test your basic implementation ability.
 * But make sure your confirm with the interviewer first
 */
public class str2Str {

    public static void main(String[] args) {
        String s = "luckylau is good man";
        String t = "lau";
        str2Str str2Str = new str2Str();
        System.out.println(str2Str.strStr(s, t));

    }

    public int strStr(String source, String target) {
        //write your code here
        if (source == null || target == null) {
            return -1;
        }
        int len1 = source.length();
        int len2 = target.length();
        int i = 0;
        int j = 0;
        while (i < len1 && j < len2) {
            if (source.charAt(i) == target.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        if (j >= len2) {
            return i - len2;
        } else {
            return -1;
        }
    }

}
