package me.seanxiao.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PopulatingNextRightPointersinEachNodeII {

    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        List<TreeLinkNode> queue = new ArrayList<TreeLinkNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<TreeLinkNode> temp = new ArrayList<TreeLinkNode>();
            TreeLinkNode tempNode = null;
            for (int i = 0; i < queue.size(); i++) {
                TreeLinkNode node = queue.get(i);
                if (tempNode == null) {
                    tempNode = node;
                }
                else {
                    tempNode.next = node;
                    tempNode = node;
                }
                if (node.left != null) {
                    temp.add(node.left);
                }
                if (node.right != null) {
                    temp.add(node.right);
                }
            }
            queue = temp;
        }
    }
}
