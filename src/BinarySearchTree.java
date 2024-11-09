import java.util.*;

public class BinarySearchTree {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }

    public static Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(root.data > val){
            //left subtree
            root.left = insert(root.left, val);
        }else{
            //right subtree
            root.right = insert(root.right,val);
        }
        return root;
    }

    public static boolean search(Node root, int key){
        if(root == null){
            return false;
        }
        if(root.data == key){
            return true;
        }
        if(root.data > key){
            return search(root.left,key);
        }
        else{
            return search(root.right, key);
        }
    }

    public static Node findInorderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    public static Node delete(Node root, int val){
        if(root.data < val){
            root.right = delete(root.right, val);
        } else if (root.data > val) {
            root.left = delete(root.left,val);
        }else {
            if(root.left == null && root.right == null){
                return null;
            }
            if(root.left == null){
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }

    public static void printInRange(Node root, int k1, int k2){
        if(root == null){
            return;
        }
        if(root.data >= k1 && root.data <= k2){
            printInRange(root.left,k1,k2);
            System.out.print(root.data + " ");
            printInRange(root.right,k1,k2);
        } else if (root.data < k1) {
            printInRange(root.right, k1, k2);
        }else {
            printInRange(root.left, k1, k2);
        }
    }

    public static void rootToLeaf(Node root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.data);
        if (root.left == null && root.right == null) {
            System.out.println(path);
        } else {
            rootToLeaf(root.left, path);
            rootToLeaf(root.right, path);
        }
        path.remove(path.size() - 1);
    }

    public static boolean validateBST(Node root) {
        return validateBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean validateBST(Node node, int min, int max) {
        if (node == null) {
            return true;
        }
        if (node.data <= min || node.data >= max) {
            return false;
        }
        return validateBST(node.left, min, node.data) && validateBST(node.right, node.data, max);
    }

    public static boolean isValidateBST(Node root, Node min, Node max){
        if(root == null){
            return true;
        }
        if(min != null && root.data <= min.data){
            return false;
        }
        if(max != null && root.data >= max.data){
            return false;
        }
        return isValidateBST(root.left, min, root) && isValidateBST(root.right, root, max);
    }

    public static void mirrorBST(Node root){
        if(root == null){
            return;
        }
        Node temp =root.left;
        root.left = root.right;
        root.right =temp;
        mirrorBST(root.left);
        mirrorBST(root.right);
    }



    public static void inorder(Node root){
        if (root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }


    public static void main(String[] args) {
        int[] values = {8,5,3,6,10,11,14};
        Node root = null;
        for (int value : values) {
            root = insert(root, value);
        }

        // Inorder Traversal
//        System.out.print("Inorder Traversal: ");
//        inorder(root);
//        System.out.println();

        // Searching for a value
//        if (search(root, 2)) {
//            System.out.println("Found");
//        } else {
//            System.out.println("Not found");
//        }
//        inorder(root);
//        System.out.println();
//        delete(root,3);
//        inorder(root);

//        printInRange(root,2,7);


//        rootToLeaf(root ,  new ArrayList<>());

//        if(isValidateBST(root,null, null )){
//            System.out.println("It is a binary search tree");
//        }else{
//            System.out.println("Not a binary search tree");
//        }

        inorder(root);
        System.out.println();
        mirrorBST(root);
        inorder(root);
    }

}
