import java.util.*;

public class Vertical_Order_Traversal_of_a_Binary_Tree {
    public class TreeNode {
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
    class Info {
        TreeNode node;
        int col;
        int row;

        Info(TreeNode n, int c, int r) {
            node = n;
            col = c;
            row = r;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<Info> nodes = new ArrayList<>();

        // BFS queue
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(root, 0, 0));

        while(!q.isEmpty()) {
            Info curr = q.poll();
            nodes.add(curr);

            if(curr.node.left != null) {
                q.add(new Info(curr.node.left, curr.col - 1, curr.row + 1));
            }
            if(curr.node.right != null) {
                q.add(new Info(curr.node.right, curr.col + 1, curr.row + 1));
            }
        }

        // Sort by column, then row, then value
        Collections.sort(nodes, (a, b) -> {
            if(a.col != b.col)
                return a.col - b.col;
            if(a.row != b.row)
                return a.row - b.row;
            return a.node.val - b.node.val;
        });

        // Build result
        List<List<Integer>> res = new ArrayList<>();
        int prevCol = Integer.MIN_VALUE;

        for(Info info : nodes) {
            if(info.col != prevCol) {
                res.add(new ArrayList<>());
                prevCol = info.col;
            }
            res.get(res.size() - 1).add(info.node.val);
        }

        return res;
    }
}
