/**
 * A robot is located at the top-left corner of a m x n grid.
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid.
 * How many possible unique paths are there?
 * Example
 * Given m = 3 and n = 3, return 6.
 * Given m = 4 and n = 5, return 35.
 * 
 * 
 * 
 */
package n.series.DynamicProgramming;

public class UniquePaths {
	public int uniquePaths(int m, int n) {
        // write your code here 
        if( m == 1 || n ==1 ){
            return 1;
        }
        
        int[][] sum = new int[m][n];
        for ( int i = 0 ; i < m ; i++ ) {
            sum[i][0] = 1;
        }
        
        for ( int i = 0 ; i < n ; i++ ) {
            sum[0][i] = 1;
        }
        
        for ( int i = 1 ; i < m ; i++ ) {
            for ( int j = 1 ; j < n ; j++) {
                sum[i][j] = sum[i][j - 1] + sum[i - 1][j];
            }
        }
        
        return sum[m - 1][n - 1];
    }
	public static void main(String[] args) {
		int m = 4;
		int n = 5;
		UniquePaths uniquePaths = new UniquePaths();
		System.out.println(uniquePaths.uniquePaths(m, n));
	}

}
