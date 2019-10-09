/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * Example
 * Consider the following matrix:
 * [
 * 	[1, 3, 5, 7],
 * 	[10, 11, 16, 20],
 * 	[23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
 * Challenge
 * O(log(n) + log(m)) time
 */
package n.series.BinarySearchandSortedSearch;

public class Searcha2DMatrix {

	public static void main(String[] args) {
		int[][] nums = new int[][]{
				{1, 3, 5, 7},
				{10, 11, 16, 20},
				{23, 30, 34, 50}
		};
		Searcha2DMatrix searcha2DMatrix = new Searcha2DMatrix();
		System.out.println(searcha2DMatrix.searchMatrix(nums, 52));
		System.out.println(searcha2DMatrix.searchMatrix2(nums, 52));

	}

	private boolean searchMatrix2(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0) {
			return false;
		}
		if (matrix[0] == null || matrix[0].length == 0) {
			return false;
		}
		int row = matrix.length;
		int column = matrix[0].length;

		int start = 0;
		int end = row - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (matrix[mid][0] == target) {
				return true;
			} else if (matrix[mid][0] < target) {
				start = mid + 1;
			} else if (matrix[mid][0] > target) {
				end = mid - 1;
			}
		}

		if (end < row - 1 && matrix[end + 1][0] < target) {
			row = end + 1;
		} else if (start > 0 && matrix[start - 1][0] < target) {
			row = start - 1;
		} else {
			return false;
		}

		start = 0;
		end = column - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (matrix[row][mid] == target) {
				return true;
			} else if (matrix[row][mid] < target) {
				start = mid + 1;
			} else if (matrix[row][mid] > target) {
				end = mid - 1;
			}
		}

		return false;
	}

	private boolean searchMatrix(int[][] matrix, int target) {
	        // write your code here
	        if (matrix == null || matrix.length == 0){
	            return false;
	        }
	        if (matrix[0] == null || matrix[0].length == 0){
	            return false;
	        }
	        int row = matrix.length;
	        int column = matrix[0].length;

	        int start = 0;
	        int end = row - 1;
	        while(start + 1 < end){
	            int mid = start + (end - start)/2;
	            if(matrix[mid][0] == target){
	                return true;
	            }else if (matrix[mid][0] <target){
	                start = mid;
	            }else if (matrix[mid][0] > target){
					end = mid;
	            }
	        }
	        if (matrix[end][0] <= target){
	            row = end;
	        }else if (matrix[start][0] <= target){
	            row = start;
	        }else {
	            return false;
	        }

		start = 0;
	        end = column - 1;
	        while(start + 1 < end){
	            int mid = start + (end - start)/2;
	            if(matrix[row][mid] == target){
	                return true;
	            }else if(matrix[row][mid] < target){
	                start = mid;
	            }else if (matrix[row][mid] > target){
	                end = mid;
	            }
	        }
	        if(matrix[row][start] == target){
	            return true;
	        }else if (matrix[row][end] == target){
	            return true;
	        }

		return false;

	}

}
