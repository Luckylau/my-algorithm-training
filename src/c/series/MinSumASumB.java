package c.series;

import java.util.Arrays;
/**
 * ����������������a��b������a,b�е�Ԫ�أ�ʹ��[����aԪ�صĺ�]��[����bԪ�صĺ�]֮��Ĳ���С��
 *
 *
 */
public class MinSumASumB {
	public int minSumASumB(int[] a, int[] b) {
		int sumA = sum(a);
		int sumB = sum(b);
		if (sumA < sumB) {
			int[] tmp = a;
			a = b;
			b = tmp;
		}
		if (sumA == sumB) {
			return 0;
		}
		int fin = Integer.MAX_VALUE;
		int diff = 1;
		boolean shift = true;
		while (shift && diff > 0) {
			shift = false;
			diff = sum(a) - sum(b);
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < b.length; j++) {
					int tmp = a[i] - b[j];
					if (Math.abs(diff - 2 * tmp) < diff && Math.abs(diff - 2 * tmp) < fin) {
						fin = Math.abs(diff - 2 * tmp);
						shift = true;
						int tmp1 = a[i];
						int tmp2 = b[j];
						a[i] = tmp2;
						b[j] = tmp1;

					}
				}
			}

		}
		return fin;
	}

	private int sum(int[] a) {
		int res = 0;
		for (int i = 0; i < a.length; i++) {
			res += a[i];
		}
		return res;
	}

	public static void main(String[] args) {
		int[] a = { 10, 9, 8, 1, 2, 3 };
		int[] b = { 1, 2, 3, 4, 5 };
		MinSumASumB minSumASumB = new MinSumASumB();
		System.out.println(minSumASumB.minSumASumB(a, b));
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));

	}

}
