package c.series;

/**
 * �������ַ����е��ַ�'*'�Ƶ�����ǰ���֣�ǰ��ķ�'*'�ַ����ƣ������ܸı��'*'�ַ����Ⱥ�˳�򣬺������ش����ַ�'*'����������ԭʼ��Ϊ��ab**cd
 * **e*12�������Ϊ*****abcde12������������ֵΪ5����Ҫ��ʹ�þ����ٵ�ʱ��͸����ռ䣩
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
