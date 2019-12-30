package o.series;
/**
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */

/**
 * @Author luckylau
 * @Date 2019/12/30
 */
public class ReverseSentence {
    public String reverseSentence(String str) {
        if (str == null || str.trim().length() == 0) {
            return str;
        }
        String[] strs = str.split(" ");
        for (int start = 0, end = strs.length - 1; start < end; start++, end--) {
            String tmp = strs[start];
            strs[start] = strs[end];
            strs[end] = tmp;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < strs.length; i++) {
            sb.append(strs[i]);
            sb.append(" ");
        }
        return sb.toString().substring(0, sb.length() - 1);
    }
}
