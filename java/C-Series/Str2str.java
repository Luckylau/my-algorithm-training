package demo;

/**
 * 在一个字符串中找到第一个只出现一次的字符。如输入abaccdeff，则输出b
 * 
 *
 */
public class Str2str {

	public int firstNotRepeat(String str) {
		char[] chars = str.toCharArray();
		int i, j;
		for (i = 0; i < chars.length; i++) {
			for (j = 0; j < chars.length; j++) {
				if (i != j && chars[i] == chars[j]) {
					break;
				}
			}
			if (j == chars.length) {
				return i;
			}
		}
		return -1;
	}

	public int firstNotRepeat2(String str) {
		char[] chars = str.toCharArray();
		int[] hash = new int[256];
		for (int i = 0; i < hash.length; i++) {
			hash[i] = 0;
		}
		for (int j = 0; j < chars.length; j++) {
			hash[chars[j]]++;
		}
		for (int k = 0; k < chars.length; k++) {
			if (hash[chars[k]] == 1) {
				return k;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "ab#acbcdeff";
		Str2str str2str = new Str2str();
		System.out.println(str2str.firstNotRepeat(str));
		System.out.println(str2str.firstNotRepeat2(str));

	}

}
