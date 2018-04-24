package c.series;
/**
 * 
 * ���ַ������ҳ�����������ִ�������������ĳ��ȷ��ء�
 *
 */
public class FindlongDigtal {

	public String findlongDigtal(String input) {
		if (input.length() == 0 || input == null) {
			return null;
		}
		int maxLen = 0;
		int index = -1;
		int len = 0;
		int start = 0;
		while (start < input.length()) {
			if (input.charAt(start) <= '9' && input.charAt(start) >= '0') {
				len++;
			} else {
				if (len > maxLen) {
					maxLen = len;
					index = start - len;
				}
				len = 0;
			}
			start++;
		}
		if (len > maxLen) {
			maxLen = len;
			index = start - len;
		}
		return input.substring(index, index + maxLen);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindlongDigtal findlongDigtal = new FindlongDigtal();
		String str = "abcd12Y3fsfsa45ed125ss14151351123456789&&&&&&";
		System.out.println(findlongDigtal.findlongDigtal(str));

	}

}
