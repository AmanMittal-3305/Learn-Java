import java.util.ArrayList;

public class BinaryTreeQuestion {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    //check for univalued tree
    public static boolean checkUnivalued(Node root){
        if(root == null){
            return true;
        }
        return checkUnivaluedHelper(root, root.data);
    }

    private static boolean checkUnivaluedHelper(Node node, int data) {
        if (node == null) {
            return true;
        }
        if (node.data != data) {
            return false;
        }
        return checkUnivaluedHelper(node.left, data) && checkUnivaluedHelper(node.right, data);
    }


    //invert binary tree
    public static Node invert(Node root){
        if(root == null){
            return root;
        }
        invert(root.left);
        invert(root.right);
        Node curr = root.left;
        root.left = root.right;
        root.right = curr;
        return root;
    }

    public static void printTree(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        printTree(root.left);
        printTree(root.right);
    }

    //Path Sum II -> https://leetcode.com/problems/path-sum-ii/description/
    public static ArrayList<ArrayList<Integer>> pathSum(Node root, int targetSum) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        dfs(root, targetSum, path, ans);
        return ans;
    }

    private static void dfs(Node root, int targetSum, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> ans) {
        if (root == null) {
            return;
        }

        // Add current node's value to the path and update targetSum
        path.add(root.data);
        targetSum -= root.data;

        // Check if we're at a leaf node and the path sum equals targetSum
        if (root.left == null && root.right == null && targetSum == 0) {
            ans.add(new ArrayList<>(path)); // Add a copy of the path to results
        } else {
            // Recur down to left and right children
            dfs(root.left, targetSum, path, ans);
            dfs(root.right, targetSum, path, ans);
        }

        // Backtrack to explore other paths
        path.remove(path.size() - 1);
    }

    //Path Sum -> https://leetcode.com/problems/path-sum/
    public boolean hasPathSum(Node root, int targetSum) {
        // If root is null, return false as there's no path
        if (root == null) {
            return false;
        }

        // Subtract the root's value from targetSum
        targetSum -= root.data;

        // Check if we have reached a leaf node and targetSum equals zero
        if (root.left == null && root.right == null) {
            return targetSum == 0;
        }

        // Recur down the left and right subtrees
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }


    // Max path Sum -> https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(Node root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(Node node) {
        if (node == null) {
            return 0;
        }

        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        int currentPathSum = node.data + leftGain + rightGain;

        maxSum = Math.max(maxSum, currentPathSum);

        return node.data + Math.max(leftGain, rightGain);
    }

    // Sum Root to Leaf Numbers -> https://leetcode.com/problems/sum-root-to-leaf-numbers/description/
    public int sumNumbers(Node root) {

        if (root == null) {
            return 0;
        }

        int[] sum = {0};

        helper(root, 0, sum);

        return sum[0];

    }

    private static void helper(Node root, int currentSum, int[] sum) {

        if (root == null) {
            return;
        }

        currentSum = currentSum * 10 + root.data;

        if (root.left == null && root.right == null) {

            sum[0] += currentSum;

            return;
        }

        helper(root.left, currentSum, sum);

        helper(root.right, currentSum, sum);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

//        System.out.println(checkUnivalued(root)); // Should print true

        invert(root);
        printTree(root);


    }
}
