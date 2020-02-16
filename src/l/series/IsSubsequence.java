package l.series;

/**
 * @Author luckylau
 * @Date 2020/1/10
 */
public class IsSubsequence {
    public static void main(String[] args) {
        IsSubsequence isSubsequence = new IsSubsequence();
        System.out.println(isSubsequence.isSubsequence("adc", "abacdcssv"));
    }

    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        int sPoint = 0;
        int tPoint = 0;
        while (sPoint < s.length() && tPoint < t.length()) {
            if (s.charAt(sPoint) == t.charAt(tPoint)) {
                sPoint++;
                tPoint++;
            } else {
                tPoint++;
            }
        }
        return sPoint == s.length();
    }
}
