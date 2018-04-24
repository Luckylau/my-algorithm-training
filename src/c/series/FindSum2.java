package c.series;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ������������n��m,������1,2,3������n������ȡ��������ʹ��͵���m�� Ҫ�����еĿ�������г�����ʵ���Ͼ���һ���������⡣
 * 
 *
 */
public class FindSum2 {

	public List<List<Integer>> findSum2(int sum, int n) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<>();
		helper(sum, n, list, res);
		return res;
	}

	private void helper(int sum, int n, List<Integer> list, List<List<Integer>> res) {
		if (sum == 0) {
			res.add(new ArrayList<Integer>(list));
			return;
		}
		if (sum < 0 || n <= 0) {
			return;
		}
		list.add(n);
		helper(sum - n, n - 1, list, res);
		list.remove(list.size() - 1);
		helper(sum, n - 1, list, res);

	}

	public static void main(String[] args) {
		FindSum2 findSum2 = new FindSum2();
		System.out.println(Arrays.deepToString(findSum2.findSum2(4, 6).toArray()));

	}

}
