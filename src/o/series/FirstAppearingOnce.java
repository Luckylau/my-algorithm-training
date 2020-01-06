package o.series;
/**
 * 字符流中第一个不重复的字符
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @Author luckylau
 * @Date 2019/12/23
 */
public class FirstAppearingOnce {

    char[] chars = new char[256];
    List<Character> list = new ArrayList<>();

    public static void main(String[] args) {
        FirstAppearingOnce firstAppearingOnce = new FirstAppearingOnce();
        firstAppearingOnce.insert('g');
        firstAppearingOnce.insert('o');
        firstAppearingOnce.insert('o');
        firstAppearingOnce.insert('g');
        firstAppearingOnce.insert('l');
        System.out.println(firstAppearingOnce.firstAppearingOnce());


    }

    public void insert(char ch) {
        chars[ch]++;
        list.add(ch);
    }

    /**
     * return the first appearence once char in current stringstream
     */
    public char firstAppearingOnce() {
        char res = '#';
        for (int i = 0; i < list.size(); i++) {
            if (chars[list.get(i)] == 1) {
                return list.get(i);
            }
        }
        return res;
    }
}
