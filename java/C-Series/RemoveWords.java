package demo;

public class RemoveWords {

	public String removeWords(String source, String target) {
		if (source.length() == 0 || source == null) {
			return source;
		}
		if (target.length() == 0 || target == null) {
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

	public static void main(String[] args) {
		String source = "They are students.";
		String target = "aeiou";
		RemoveWords removeWords = new RemoveWords();
		System.out.println(removeWords.removeWords(source, target));

	}

}
