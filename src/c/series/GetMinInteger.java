package c.series;

import java.util.Arrays;
import java.util.Comparator;

public class GetMinInteger {

	public String getMinInteger(int[] nums) {
		if (nums.length == 0 || nums == null) {
			return null;
		}
		Integer[] res = new Integer[nums.length];
		for (int i = 0; i < nums.length; i++) {
			res[i] = nums[i];
		}
		Arrays.sort(res, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return ("" + o1 + 02).compareTo("" + o2 + o1);
			}
		});
		StringBuffer sb = new StringBuffer();
		for (int j = 0; j < res.length; j++) {
			sb.append(res[j]);
		}
		return sb.toString();
	}

	public String getMinInteger2(int[] nums) {
		if (nums.length == 0 || nums == null) {
			return null;
		}
		for (int i = 1; i < nums.length; i++) {
			for (int j = i; j > 0; j--) {
				if (("" + nums[j] + nums[j - 1]).compareTo("" + nums[j - 1] + nums[j]) < 0) {
					int tmp = nums[j];
					nums[j] = nums[j - 1];
					nums[j - 1] = tmp;
				}
			}
		}
		StringBuffer sb = new StringBuffer();
		for (int j = 0; j < nums.length; j++) {
			sb.append(nums[j]);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		int[] nums = { 123, 32, 7, 31 };
		GetMinInteger getMinInteger = new GetMinInteger();
		System.out.println(getMinInteger.getMinInteger(nums));
		System.out.println(getMinInteger.getMinInteger2(nums));
	}

}
