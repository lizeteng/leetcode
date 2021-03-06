package com.lizeteng.leetcode.medium._144;

import com.lizeteng.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的前序遍历。
 *
 * 示例：
 * 输入：[1, null, 2, 3]
 *    1
 *     \
 *      2
 *     /
 *    3
 * 输出：[1, 2, 3]
 *
 * 进阶：
 * 通过迭代算法完成。
 *
 * @author lizeteng
 * @date 2018/11/15
 */
public class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {
        TreeNode treeNode = root;
        List<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> linkedStack = new LinkedList<>();

        while (treeNode != null || !linkedStack.isEmpty()) {
            if (treeNode != null) {
                result.add(treeNode.val);

                linkedStack.push(treeNode);

                treeNode = treeNode.left;
            } else {
                treeNode = linkedStack.pop();

                treeNode = treeNode.right;
            }
        }

        return result;
    }

    public List<Integer> preorderTraversalRecursion(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        preorderTraversalRecursionInternally(result, root);

        return result;
    }

    private void preorderTraversalRecursionInternally(List<Integer> result, TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        result.add(treeNode.val);

        preorderTraversalRecursionInternally(result, treeNode.left);
        preorderTraversalRecursionInternally(result, treeNode.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        System.out.println(new Solution().preorderTraversal(root));
        System.out.println(new Solution().preorderTraversalRecursion(root));
    }
}
