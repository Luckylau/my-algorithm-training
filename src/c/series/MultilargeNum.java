package c.series;

/**
 * 
 * �������
 *
 */
public class MultilargeNum {
	public String multilargerNum(String num1, String num2) {
		if (num1.length() == 0 || num2.length() == 0 || num1 == null || num2 == null) {
			return null;
		}
		int[] res = new int[num1.length() + num2.length()];
		int[] n1 = new int[num1.length()];
		int[] n2 = new int[num2.length()];
		char[] char1 = num1.toCharArray();
		char[] char2 = num2.toCharArray();
		for (int i = 0; i < char1.length; i++) {
			n1[i] = char1[i] - '0';
		}
		for (int i = 0; i < char2.length; i++) {
			n2[i] = char2[i] - '0';
		}
		for (int i = 0; i < n1.length; i++) {
			for (int j = 0; j < n2.length; j++) {
				res[i + j] += n1[i] * n2[j];
			}
		}
		for (int i = res.length - 1; i > 0; i--) {
			res[i - 1] += res[i] / 10;
			res[i] = res[i] % 10;
		}
		String result = "";
		for (int i = 0; i < res.length; i++) {
			result += res[i];
		}
		return result;

	}

	public static void main(String[] args) {
		MultilargeNum MultilargeNum = new MultilargeNum();
		String num1 = "1234567890";
		String num2 = "987654321";
		System.out.println(MultilargeNum.multilargerNum(num1, num2));

	}
}
