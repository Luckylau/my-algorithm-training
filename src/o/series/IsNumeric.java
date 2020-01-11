package o.series;

/**
 * @Author luckylau
 * @Date 2019/12/24
 */
public class IsNumeric {

    public static void main(String[] args) {
        char[] chars = {'1', '2', 'E'};
        IsNumeric isNumeric = new IsNumeric();
        System.out.println(isNumeric.isNumeric(chars));
    }

    public boolean isNumeric(char[] str) {
        if (str == null || str.length == 0) {
            return false;
        }
        int posE = postionE(str);
        if (posE == -1) {
            if (isDecimal(str, 0, str.length - 1) || isDigit(str, 0, str.length - 1)) {
                return true;
            }
        } else {
            if (posE == str.length - 1) {
                return false;
            }
            if (isDigit(str, posE + 1, str.length - 1)) {
                return true;
            }
        }

        return false;
    }

    private int postionE(char[] str) {
        int pos = -1;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == 'E' || str[i] == 'e') {
                pos = i;
                break;
            }
        }
        return pos;
    }

    private boolean isDecimal(char[] str, int start, int end) {
        if (end > str.length) {
            end = str.length - 1;
        }
        int pos = -1;
        if (str[start] == '+' || str[start] == '-') {
            start++;
        }
        for (int i = start; i <= end; i++) {
            if (str[i] == '.') {
                pos = i;
                break;
            }
        }
        if (pos == -1) {
            return false;
        }
        return isDigit(str, start, pos - 1) && isDigit(str, pos + 1, end);
    }

    private boolean isDigit(char[] str, int start, int end) {
        if (end > str.length) {
            end = str.length - 1;
        }
        if (str[start] == '+' || str[start] == '-') {
            start++;
        }
        for (int i = start; i <= end; i++) {
            if (str[i] < '0' || str[i] > '9') {
                return false;
            }
        }
        return true;
    }

}
