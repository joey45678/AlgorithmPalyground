
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return false;

        return dfs(root.left, root.right);
    }

    public boolean dfs(TreeNode node, TreeNode node2) {
        if (node == null && node2 == null)
            return true;

        if (node == null || node2 == null)
            return false;

        if (node.val != node2.val)
            return false;

        return dfs(node.left, node2.right) && dfs(node.right, node2.left);
    }

}