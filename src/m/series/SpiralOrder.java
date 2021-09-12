package m.series;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 *
 * @Author luckylau
 * @Date 2021/4/14
 */
public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return null;
        }
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int down = matrix.length - 1;
        List<Integer> res = new ArrayList<>();
        for (; ; ) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;
            if (top > down) {
                break;
            }
            for (int i = top; i <= down; i++) {
                res.add(matrix[i][right]);
            }
            right--;
            if (right < left) {
                break;
            }
            for (int i = right; i >= left; i--) {
                res.add(matrix[down][i]);
            }
            down--;
            if (down < top) {
                break;
            }
            for (int i = down; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            left++;
            if (left > right) {
                break;
            }
        }
        return res;
    }
}
