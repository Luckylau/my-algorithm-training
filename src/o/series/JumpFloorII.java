package o.series;

import java.util.Arrays;

/**
 * @Author luckylau
 * @Date 2019/12/17
 */
public class JumpFloorII {

    public static void main(String[] args) {
        JumpFloorII jumpFloorII = new JumpFloorII();
        System.out.println(jumpFloorII.jumpFloor(10));
        System.out.println(jumpFloorII.jumpFloor2(10));
    }

    public int jumpFloor(int target) {
        int[] df = new int[target + 1];
        df[0] = 1;
        df[1] = 1;
        if (target >= 2) {
            for (int i = 2; i < target + 1; i++) {
                df[i] = 0;
                for (int j = 0; j < i; j++) {
                    df[i] += df[j];
                }
            }
        }
        System.out.println(Arrays.toString(df));
        return df[target];

    }

    public int jumpFloor2(int target) {
        if (target <= 0) {
            return 1;
        } else if (target == 1) {
            return 1;
        } else {
            return 2 * jumpFloor2(target - 1);
        }
    }

}
