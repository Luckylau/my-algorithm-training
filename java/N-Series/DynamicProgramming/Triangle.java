/**
 * Given a triangle, find the minimum path sum from top to bottom. 
 * Each step you may move to adjacent numbers on the row below.
 * 
 * Example
 * Given the following triangle:
 *[
 *    [2],
 *  [3,4],
 *  [6,5,7],
 * [4,1,8,3]
 *]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 */
package chapter5;

public class Triangle {
	
    public int minimumTotal(int[][] triangle) {
        // write your code here
        if(triangle.length == 0 || triangle ==null){
            return -1;
        }
        if(triangle[0].length ==0 || triangle[0] == null) {
            return -1;
        }
        int n = triangle.length;
        int[][] f= new int[n][n];
        
        f[0][0] = triangle[0][0];
        for (int i =1 ; i< n ;i++ ){
            f[i][0] = f[i-1][0] +triangle[i][0];
            f[i][i] = f[i-1][i-1]+triangle[i][i];
        }
        
        for(int i = 2 ; i < n; i++ ){
            for(int j = 1 ; j < i ; j++ ){
                f[i][j] = Math.min(f[i-1][j-1],f[i-1][j]) +triangle[i][j];
            }
        }
        
        int best = f[n-1][0];
        for(int i = 1 ; i < n ; i++ ) {
            best =Math.min(best , f[n-1][i]);
        }
        return best;
    }
    
    public int minimumTotal2(int[][] triangle) {
        // write your code here
        if(triangle.length == 0 || triangle ==null) {
            return -1;
        }
        if(triangle[0].length ==0 || triangle[0] == null) {
            return -1;
        }
        int n = triangle.length;
        int[][] f = new int [n][n];
        
        for (int i = 0 ; i < n ; i++ ) {
            f[n-1][i] = triangle[n-1][i];
        }
        
        for ( int i = n-2 ; i >= 0 ; i-- ) {
            for ( int j = 0 ; j <= i ; j++ ) {
                f[i][j] = Math.min(f[i + 1][j] , f[i + 1][j + 1]) + triangle[i][j]; 
            }
        }
        
        return f[0][0];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] triangle = new int[4][4];
		triangle[0][0]=2;
		triangle[1][0]=3;
		triangle[2][0]=6;
		triangle[3][0]=4;
		triangle[1][1]=4;
		triangle[2][1]=5;
		triangle[3][1]=1;
		triangle[2][2]=7;
		triangle[3][2]=8;
		triangle[3][3]=3;
		Triangle tri = new Triangle();
		System.out.println(tri.minimumTotal(triangle));
		System.out.println(tri.minimumTotal2(triangle));
		
	}

}
