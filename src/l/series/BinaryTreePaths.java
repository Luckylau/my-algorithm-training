package l.series;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author luckylau
 * @Date 2020/2/1
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }
        List<Integer> values = new ArrayList<>();
        findPaths(paths, values, root);
        return paths;
    }

    private void findPaths(List<String> paths, List<Integer> values, TreeNode root) {
        if (root == null) {
            return;
        }
        values.add(root.val);
        if (root.left == null && root.right == null) {
            paths.add(buildPath(values));
        } else {
            findPaths(paths, values, root.left);
            findPaths(paths, values, root.right);
        }
        values.remove(values.size() - 1);
    }

    private String buildPath(List<Integer> values) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.size(); i++) {
            sb.append(values.get(i));
            if (i != values.size() - 1) {
                sb.append("->");
            }
        }
        return sb.toString();
    }
}
