package l.series;

/**
 * 查找最大回文，并输出
 */
public class FindLongparlindrome {
    public static void main(String[] args) {
        String str = "googlelgoo";
        FindLongparlindrome findLongparlindrome = new FindLongparlindrome();
        System.out.println(findLongparlindrome.findLongparlindrome(str));

    }

    public String findLongparlindrome(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        String target = "";
        for (int i = 0; i < str.length(); i++) {
            String tmp = "";
            String even = palindromeeven(str, i);
            String odd = palindromeodd(str, i);
            tmp = even.length() > odd.length() ? even : odd;
            if (target.length() < tmp.length()) {
                target = tmp;
            }
        }
        return target;
    }

    private String palindromeeven(String str, int index) {
        int left = index;
        int right = index + 1;
        while (left >= 0 && right <= str.length() - 1) {
            if (str.charAt(left) != str.charAt(right)) {
                break;
            }
            left--;
            right++;
        }
        return str.substring(left + 1, right);

    }

    private String palindromeodd(String str, int index) {
        int mid = index;
        int left = mid - 1;
        int right = mid + 1;
        while (left >= 0 && right <= str.length() - 1) {
            if (str.charAt(left) != str.charAt(right)) {
                break;
            }
            left--;
            right++;
        }
        return str.substring(left + 1, right);
    }

}
