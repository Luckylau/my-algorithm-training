package demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindSumIsN {
	public List<List<Integer>> findSumIsN(int n) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (n < 3) {
			return res;
		}
		int low = 1;
		int high = 2;
		int sum = low + high;
		int mid = n / 2;
		while (low < mid) {
			if (sum == n) {
				List<Integer> list = new ArrayList<Integer>();
				for (int i = low; i <= high; i++) {
					list.add(i);
				}
				res.add(list);
			}
			while (sum > n) {
				sum -= low;
				low++;
				if (sum == n) {
					List<Integer> list = new ArrayList<Integer>();
					for (int i = low; i <= high; i++) {
						list.add(i);
					}
					res.add(list);
				}
			}
			high++;
			sum += high;
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindSumIsN findSumIsN = new FindSumIsN();
		System.out.println(Arrays.deepToString(findSumIsN.findSumIsN(15).toArray()));

	}

}
