package util;

import n.series.binarytreeanddivideconqueranddfsandbfs.BinaryTreeLevelOrderTraversal;

import java.util.ArrayList;

/**
 * @Author luckylau
 * @Date 2019/12/28
 */
public class TreePrint {

    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        BinaryTreeLevelOrderTraversal binaryTreeLevelOrderTraversal = new BinaryTreeLevelOrderTraversal();
        return binaryTreeLevelOrderTraversal.levelOrder(root);
    }

}
