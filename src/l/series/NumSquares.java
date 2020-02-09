package l.series;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author luckylau
 * @Date 2020/1/16
 */
public class NumSquares {
    public static void main(String[] args) {
        NumSquares numSquares = new NumSquares();
        System.out.println(numSquares.numSquares(12));
        System.out.println(numSquares.numSquares2(12));
    }

    public int numSquares(int n) {
        List<Integer> square = generateSquares(n);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] mark = new boolean[n + 1];
        queue.add(n);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            while (size > 0) {
                int cur = queue.poll();
                for (int sqr : square) {
                    int next = cur - sqr;
                    if (next < 0) {
                        break;
                    }
                    if (next == 0) {
                        return step;
                    }
                    if (!mark[next]) {
                        queue.offer(next);
                        mark[next] = true;
                    }
                }
                size--;
            }
        }
        return -1;
    }

    private List<Integer> generateSquares(int n) {
        List<Integer> list = new LinkedList<>();
        int start = 1;
        int diff = 3;
        while (start <= n) {
            list.add(start);
            start += diff;
            diff += 2;
        }
        return list;
    }

    public int numSquares2(int n) {
        List<Integer> squares = generateSquares(n);
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (Integer square : squares) {
                if (square > i) {
                    break;
                }
                min = Math.min(dp[i - square] + 1, min);
            }
            dp[i] = min;
        }
        return dp[n];
    }
}
