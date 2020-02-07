package o.series;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */

/**
 * @Author luckylau
 * @Date 2019/12/27
 */
public class VerifySquenceOfBST {

    public static void main(String[] args) {
        int[] seq = {1, 4, 3, 9, 10, 11, 8};
        VerifySquenceOfBST verifySquenceOfBST = new VerifySquenceOfBST();
        System.out.println(verifySquenceOfBST.verifySquenceOfBST(seq));
    }

    public boolean verifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return verifySqueneceOfBST(sequence, 0, sequence.length - 1);
    }

    private boolean verifySqueneceOfBST(int[] seq, int start, int end) {
        if (end <= start) {
            return true;
        }
        int point = end;
        while (point > start && seq[point - 1] > seq[end]) {
            point--;
        }
        for (int i = point - 1; i >= start; i--) {
            if (seq[i] > seq[end]) {
                return false;
            }
        }

        return verifySqueneceOfBST(seq, start, point - 1) &&
                verifySqueneceOfBST(seq, point, end - 1);

    }

}
