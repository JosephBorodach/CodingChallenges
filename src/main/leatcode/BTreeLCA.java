package src.main.leatcode;

public class BTreeLCA {
     public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
     }


    /**
     * Nailed this
     * Recursively transvers the tree from top to bottom, the first node which lies in between the two #s p & q is the LCA of the 2 nodes.
     */
    private TreeNode root;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.root = root;

        // Start at the root, at the very top
        return recursion(this.root, p, q);
    }

    /**
     * Create a recursive function that takes a node and the two values n1 and n2.
     * If the value of the current node is less than both n1 and n2, then LCA lies in the right subtree. Call the recursive function for the right subtree.
     */
    private TreeNode recursion (TreeNode n, TreeNode p, TreeNode q) {
        if (n == null) {
            return null;
        }

        // You are at the LCA! The current node is in btwn both p & q
        if (n.val > p.val && n.val < q.val || n.val < p.val && n.val > q.val) {
            return n;
        }

        // If both n1 and n2 are greater than root, then LCA lies in right
        if (n.val < p.val && n.val < q.val) {
            return recursion(n.right, p, q);
        }
        // If both n1 and n2 are smaller than root, then LCA lies in left
        if (n.val > p.val && n.val > q.val) {
            return recursion(n.left, p, q);
        }

        // If both p and q are to the left of the root, then return the node to the left of the root
        if (p.val < this.root.val && q.val < this.root.val) {
            return this.root.left;
        }

        // If both p and q are to the right of the root, then return the node to the right of the root
        if (p.val > this.root.val && q.val > this.root.val) {
            return this.root.right;
        }

        // The LCA is the root
        return this.root;
    }
}
