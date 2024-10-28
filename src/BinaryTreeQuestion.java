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
