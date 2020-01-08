package l.series;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author luckylau
 * @Date 2020/1/8
 */
public class ReconstructQueue {
    public static void main(String[] args) {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        ReconstructQueue reconstructQueue = new ReconstructQueue();
        for (int i = 0; i < 6; i++) {
            System.out.println(Arrays.toString(reconstructQueue.reconstructQueue(people)[i]));
        }
    }

    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0) {
            return new int[0][0];
        }
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        List<int[]> queue = new ArrayList<>();
        for (int[] p : people) {
            queue.add(p[1], p);
        }
        return queue.toArray(new int[queue.size()][]);
    }
}
