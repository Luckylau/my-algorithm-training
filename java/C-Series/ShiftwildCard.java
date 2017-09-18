package demo;

/**
 * 函数将字符串中的字符'*'移到串的前部分，前面的非'*'字符后移，但不能改变非'*'字符的先后顺序，函数返回串中字符'*'的数量。如原始串为：ab**cd
 * **e*12，处理后为*****abcde12，函数并返回值为5。（要求使用尽量少的时间和辅助空间）
 * 
 *
 */
public class ShiftwildCard {

	public String shiftWildCard(String str) {
		if (str.length() == 0 || str == null) {
			return null;
		}
		char[] chars = str.toCharArray();
		int i = str.length() - 1;
		int j = str.length() - 1;
		while (i >= 0) {
			if (chars[i] != '*') {
				char tmp = chars[i];
				chars[i] = chars[j];
				chars[j] = tmp;
				i--;
				j--;
			} else {
				i--;
			}
		}
		return String.valueOf(chars);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShiftwildCard shiftwildCard = new ShiftwildCard();
		String str = "ab**cd**e*12";
		System.out.println(shiftwildCard.shiftWildCard(str));

	}

}
