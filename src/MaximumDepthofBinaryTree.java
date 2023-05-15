/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
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
    int answer = 0;
    public int maxDepth(TreeNode root) {
        if(root != null) {
            findDepth(root, 1);
        }
        
        return answer;
    }

    public void findDepth(TreeNode root, int depth) {
        answer = Math.max(depth, answer);

        if(root.right != null) {
            findDepth(root.right, depth + 1);
        }
        if(root.left != null) {
            findDepth(root.left, depth + 1);
        }
    }
}
