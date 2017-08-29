package demo;

/**
 * 题目描述： 定义字符串的左旋转操作：把字符串前面的若干个字符移动到字符串的尾部，如把字符串abcdef左旋转2位得到字符串cdefab。
 * 请实现字符串左旋转的函数，要求对长度为n的字符串操作的时间复杂度为O(n)，空间复杂度为O(1)。
 * 
 *
 */
public class LeftRotateString {

	public String leftRotateString(String str, int pos) {
		if (str.length() == 0 || str == null) {
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
