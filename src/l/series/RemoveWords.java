package l.series;

/**
 * 移除元素
 */
public class RemoveWords {

    public static void main(String[] args) {
        String source = "They are students.";
        String target = "aeiou";
        RemoveWords removeWords = new RemoveWords();
        System.out.println(removeWords.removeWords(source, target));

    }

    public String removeWords(String source, String target) {
        if (source == null || source.length() == 0) {
            return source;
        }
        if (target == null || target.length() == 0) {
            return source;
        }

        char[] hash = new char[256];
        for (int i = 0; i < target.length(); i++) {
            hash[target.charAt(i)] = 1;
        }
        int index = 0;
        char[] chars = source.toCharArray();
        for (int j = 0; j < chars.length; j++) {
            if (hash[chars[j]] == 0) {
                chars[index] = chars[j];
                index++;
            }
        }
        return String.valueOf(chars).substring(0, index);
    }

}
