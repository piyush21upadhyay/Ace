package com.ace.binarytree.breadthfirstsearch;

import java.util.List;

public class BinaryTreeRightSideView {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left= null;
            this.right=null;
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.right.left=new TreeNode(4);
        node.right.right=new TreeNode(5);

        List<Integer> rightSideView = rightSideView(node);
        System.out.println("Right side view of the binary tree is: "+rightSideView);
    }

    private static List<Integer> rightSideView(TreeNode node) {
        List<Integer> result = new java.util.ArrayList<>();
        dfs(node, result, 0);//pre-order traversal
        return result;
    }

    private static void dfs(TreeNode node, List<Integer> result, int level) {
        if(node==null){
            return;
        }
        // If this is the first node of its level
        if(result.size()==level){
            result.add(node.val);
        }
        // Traverse the right node first for right side view, else traverse the left node first for left side view
        dfs(node.right, result, level+1);
        dfs(node.left, result, level+1);
    }
}
