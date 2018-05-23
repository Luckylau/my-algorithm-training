package c.series;

/**
 * 从字符串中找出第一个不重复的字符，并返回
 */
public class Str2str {

    public static void main(String[] args) {
        String str = "ab#acbcdeff";
        Str2str str2str = new Str2str();
        System.out.println(str2str.firstNotRepeat(str));
        System.out.println(str2str.firstNotRepeat2(str));

    }

    public int firstNotRepeat(String str) {
        char[] chars = str.toCharArray();
        int i, j;
        for (i = 0; i < chars.length; i++) {
            for (j = 0; j < chars.length; j++) {
                if (i != j && chars[i] == chars[j]) {
                    break;
                }
            }
            if (j == chars.length) {
                return i;
            }
        }
        return -1;
    }

    public int firstNotRepeat2(String str) {
        if(str == null || str.length() == 0){
            return -1;
        }

        char[] chars = str.toCharArray();
        int[] hash = new int[256];
        for (int i = 0; i < hash.length; i++) {
            hash[i] = 0;
        }
        for (int j = 0; j < chars.length; j++) {
            hash[chars[j]]++;
        }
        for (int k = 0; k < chars.length; k++) {
            if (hash[chars[k]] == 1) {
                return k;
            }
        }
        return -1;
    }

}
