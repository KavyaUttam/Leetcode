/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int findmaxpathsum(TreeNode node,int[] res){
        if(node==null)return 0;
        int left=Math.max(0,findmaxpathsum(node.left,res));
        int right=Math.max(0,findmaxpathsum(node.right,res));
        res[0]=Math.max(res[0],left+right+node.val);
        return node.val+Math.max(left,right);
    }
    public int maxPathSum(TreeNode root) {
        int[] res={root.val};
        findmaxpathsum(root,res);
        return res[0];
    }
}