package l.series;

/**
 * 检测目标字符串的所有元素是否来自另一个字符串
 */
public class CompareStr {
    public static void main(String[] args) {
        CompareStr compareStr = new CompareStr();
        System.out.println(compareStr.compareStr2("defabc", "abc"));
    }

    /**
     * o(m*n)
     */
    public boolean compareStr(String source, String target) {
        if (source == null || target == null) {
            return false;
        }
        int j;
        for (int i = 0; i < target.length(); i++) {
            for (j = 0; j < source.length(); j++) {
                if (source.charAt(j) == target.charAt(i)) {
                    break;
                }
            }
            if (j == source.length()) {
                return false;
            }
        }
        return true;

    }

    /**
     * 0(mlogm+nlogn+(m+n))
     */
    public boolean compareStr2(String source, String target) {
        source = quickSort(source);
        char[] sour = source.toCharArray();
        target = quickSort(target);
        char[] tar = target.toCharArray();
        int i = 0, j = 0;
        while (i < sour.length && j < tar.length) {
            while (sour[i] < tar[j] && i < sour.length - 1) {
                i++;
            }
            if (sour[i] != tar[j]) {
                break;
            }
            j++;
        }
        if (j != tar.length) {
            return false;
        }
        return true;
    }

    private String quickSort(String str) {
        if (str.length() == 0) {
            return str;
        }
        char[] chars = str.toCharArray();
        helper(chars, 0, chars.length - 1);
        return String.valueOf(chars);
    }

    private void helper(char[] chars, int low, int high) {
        if (low < high) {
            int pivot = Partition(chars, low, high);
            helper(chars, 0, pivot - 1);
            helper(chars, pivot + 1, high);
        }
    }

    private int Partition(char[] chars, int low, int high) {
        char tmp = chars[low];
        while (low < high) {
            while (low < high && chars[high] > tmp) {
                high--;
            }
            chars[low] = chars[high];
            while (low < high && chars[low] < tmp) {
                low++;
            }
            chars[high] = chars[low];
        }
        chars[low] = tmp;
        return low;
    }

}
