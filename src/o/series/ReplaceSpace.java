package o.series;

/**
 * @Author luckylau
 * @Date 2019/10/21
 */
public class ReplaceSpace {

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("We Are Happy");
        ReplaceSpace replaceSpace = new ReplaceSpace();
        System.out.println(replaceSpace.replaceSpace(sb));
    }

    private String replaceSpace(StringBuffer str) {
        if (str == null) {
            return null;
        }
        char[] chars = str.toString().toCharArray();
        int spaceNum = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                spaceNum++;
            }
        }

        char[] newChars = new char[spaceNum * 2 + chars.length];
        int newLength = spaceNum * 2 + chars.length - 1;

        for (int j = chars.length - 1; j >= 0; j--) {
            if (chars[j] != ' ') {
                newChars[newLength--] = chars[j];
            } else {
                newChars[newLength--] = '0';
                newChars[newLength--] = '2';
                newChars[newLength--] = '%';
            }
        }
        return String.valueOf(newChars);

    }
}
