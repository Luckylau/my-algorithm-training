package c.series;

/**
 *左翻转字符串
 */
public class LeftRotateString {

	public String leftRotateString(String str, int pos) {
		if (str == null || str.length() == 0) {
			return str;
		}
		char[] chars = str.toCharArray();
		inverse(chars, 0, pos);
		inverse(chars, pos, chars.length);
		inverse(chars, 0, chars.length);
		return String.valueOf(chars);
	}

	private void inverse(char[] chars, int start, int end) {
		for (int i = start, j = end - 1; i < j; i++, j--) {
			char tmp = chars[i];
			chars[i] = chars[j];
			chars[j] = tmp;
		}
	}

	public static void main(String[] args) {
		String str = "abcdefg";
		LeftRotateString leftRotateString = new LeftRotateString();
		System.out.println(leftRotateString.leftRotateString(str, 2));
	}

}
