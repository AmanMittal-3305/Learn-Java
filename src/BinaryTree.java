import java.util.*;

public class BinaryTree {
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

    public static int height(Node root){
        if(root == null){
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh,rh) + 1;
    }

    public static int countNodes(Node root){
        if(root == null){
            return 0;
        }
        int lefCount = countNodes(root.left);
        int rightCount = countNodes(root.right);
        return lefCount+rightCount+1;
    }

    public static int sum(Node root){
        if(root == null){
            return 0;
        }
        int leftSum = sum(root.left);
        int rightSum = sum(root.right);
        return leftSum + rightSum + root.data;
    }

    public static int diameter(Node root){ // O(n^2)
        if(root == null) {
            return 0;
        }
        int ld = diameter(root.left);
        int lh = height(root.left);
        int rd = diameter(root.right);
        int rh = height(root.right);
        int selfDiam = lh+rh+1;
        return Math.max(selfDiam, Math.max(ld,rd));
    }

    static class Info{
        int ht;
        int diam;
        public Info(int ht, int diam){
            this.ht = ht;
            this.diam = diam;
        }
    }
    public static Info diameter2(Node root){ // O(n)
        if(root == null){
            return new Info(0,0);
        }
        Info leftInfo = diameter2(root.left);
        Info rightInfo = diameter2(root.right);
        int diam = Math.max(Math.max(leftInfo.diam,rightInfo.diam),leftInfo.ht + rightInfo.ht + 1);
        int ht = Math.max(leftInfo.ht, rightInfo.ht) +1;

        return new Info(ht,diam);
    }

    public static boolean isIdentical(Node root, Node subroot){
        if(root == null && subroot == null){
            return true;
        }
        else if(root == null || subroot == null || root.data != subroot.data){
            return false;
        }
        if(!isIdentical(root.left, subroot.left)){
            return false;
        }
        if(!isIdentical(root.right, subroot.right)){
            return false;
        }
        return true;
    }
    public static boolean isSubtree(Node root, Node subroot){
        if(root == null){
            return false;
        }
        if(isIdentical(root, subroot)){
            return true;
        }
        boolean left = isSubtree(root.left, subroot);
        boolean right = isSubtree(root.right, subroot);
        return left || right;
    }

    static class Binarytree {
        static int index = -1;

        public static Node buildTree(int nodes[]) {
            index++;
            if (nodes[index] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[index]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        public static void preorder(Node root) {
            if (root == null) {
//                System.out.print("-1 ");
                return;
            }
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
        public static void inorder(Node root) {
            if (root == null) {
//                System.out.print("-1 ");
                return;
            }
//            System.out.println();
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }

        public static void postorder(Node root) {
            if (root == null) {
//                System.out.print("-1 ");
                return;
            }
//            System.out.println();
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }

        public static void levelOrder(Node root){
            if(root == null){
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()){
                Node currNode = q.remove();
                if(currNode == null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    System.out.print(currNode.data + " ");
                    if(currNode.left != null){
                        q.add(currNode.left);
                    }
                    if(currNode.right != null){
                        q.add(currNode.right);
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
//        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
//        Binarytree tree = new Binarytree();
//        Node root = tree.buildTree(nodes); // Call buildTree statically
//        System.out.println(root.data + " , " + root.left.data + " , " + root.right.data);
//        tree.preorder(root); // Call preorder statically
//        tree.inorder(root);
//        tree.postorder(root);
//        tree.levelOrder(root);
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        root.right.right.left = new Node(7);
//        System.out.println(diameter2(root).diam);


        Node subroot = new Node(2);
        subroot.left = new Node(4);
        subroot.right = new Node(5);

        System.out.println(isSubtree(root,subroot));
    }
}
