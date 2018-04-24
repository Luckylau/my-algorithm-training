package c.series;

/**
 * ��Ŀ������ �����ַ���������ת���������ַ���ǰ������ɸ��ַ��ƶ����ַ�����β��������ַ���abcdef����ת2λ�õ��ַ���cdefab��
 * ��ʵ���ַ�������ת�ĺ�����Ҫ��Գ���Ϊn���ַ���������ʱ�临�Ӷ�ΪO(n)���ռ临�Ӷ�ΪO(1)��
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
