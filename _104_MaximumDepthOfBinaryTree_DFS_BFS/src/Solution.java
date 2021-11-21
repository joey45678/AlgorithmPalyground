
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public class TreeNode { int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;}}

    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }


    public int maxDepth(TreeNode root) {
        int depth = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            depth++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.remove();
                System.out.print(cur.val + " ");
                if (cur.left != null)
                    q.add(cur.left);
                if (cur.right != null)
                    q.add(cur.right);
            }
        }
        return depth;
    }


}
