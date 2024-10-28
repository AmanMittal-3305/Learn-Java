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

    static int hd = 0;
    static HashMap<Integer, Integer> map= new HashMap<>();
    public static void topView(Node root, int hd){
        if(root == null){
            return;
        }
        if(!map.containsKey(hd)){
            map.put(hd,root.data);
        }
        topView(root.left,hd-1);
        topView(root.right,hd+1);
    }

    public static void printTop(HashMap<Integer, Integer> map) {
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        for (Integer key : keys) {
            System.out.println("HD: " + key + ", Value: " + map.get(key));
        }
    }

    public static void kLevel(Node root,int k , int level){
        if(root == null){
            return;
        }
        if(level == k){
            System.out.print(root.data + " ");
        }
        kLevel(root.left,k,level+1);
        kLevel(root.right,k,level+1);
    }

    public static boolean getPath(Node root, int n, ArrayList<Node> path){
        if(root == null){
            return false;
        }
        path.add(root);
        if(root.data == n){
            return true;
        }
        boolean foundLeft =getPath(root.left,n,path);
        boolean foundRight = getPath(root.right, n, path);
        if(foundLeft || foundRight){
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }

    public static Node lowestAncestor(Node root, int n1 , int n2){  //O(N)
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();
        getPath(root, n1, path1);
        getPath(root,n2,path2);
        int i = 0;
        for(i = 0; i < path1.size() && i < path2.size(); i++){
            if(path1.get(i) != path2.get(i)){
                break;
            }
        }
        Node lca = path1.get(i-1);
        return lca;
    }

    public static Node lowestAncestor2(Node root, int n1, int n2){
        if(root == null || root.data == n1 || root.data == n2){
            return root;
        }
        Node leftLca = lowestAncestor2(root.left,n1,n2);
        Node rightLca = lowestAncestor2(root.right,n1,n2);
        //leftLca -> valid  rightLca -> null
        if(rightLca == null){
            return leftLca;
        }
        //leftLca -> null   rightLca -> valid
        if(leftLca == null){
            return rightLca;
        }
        return root;
    }

    public static int minDistanceBetween2Nodes(Node root, int n1, int n2){
        if(root == null){
            return -1;
        }
        Node lca = lowestAncestor2(root,n1,n2);
        int dist1 = lcaDistance(lca,n1);
        int dist2 = lcaDistance(lca,n2);
        return dist1+dist2;
    }

    public static int lcaDistance(Node root, int n){
        if(root == null){
            return -1;
        }
        if(root.data == n){
            return 0;
        }
        int leftDist =  lcaDistance(root.left,n);
        int rightDist = lcaDistance(root.right,n);
        if(leftDist == -1 && rightDist == -1){
            return -1;
        } else if (leftDist == -1) {
            return rightDist +1;
        }else{
            return leftDist+1;
        }
    }

    public static int kthAncestor(Node root, int n , int k){
        if(root == null){
            return -1;
        }
        if(root.data == n){
            return 0;
        }
        int leftDist = kthAncestor(root.left,n,k);
        int rightDist = kthAncestor(root.right, n,k);
        if(leftDist == -1 && rightDist == -1){
            return -1;
        }
        int max = Math.max(leftDist,rightDist);
        if(max +1 == k){
            System.out.println(root.data);
        }
        return max+1;
    }

    public static int transform(Node root){
        if(root == null){
            return 0;
        }
        int leftChild = transform(root.left);
        int rightChild = transform(root.right);
        int data = root.data;
        int newLeft = root.left == null ? 0 : root.left.data;
        int newRight = root.right == null ? 0 : root.right.data;
        root.data = leftChild+rightChild+newLeft+ newRight;
        return data;
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
        root.right.left = new Node(6);
        root.right.right = new Node(7);
//        System.out.println(diameter2(root).diam);


        Node subroot = new Node(2);
        subroot.left = new Node(4);
        subroot.right = new Node(5);

//        topView(root,hd);
//        printTop(map);

//        int level = 1;
//        kLevel(root,2,level);

        int n1 = 4, n2 = 6;
//        System.out.println(lowestAncestor(root,n1,n2).data);
//        System.out.println(lowestAncestor2(root,n1,n2).data);

//        System.out.println(minDistanceBetween2Nodes(root,n1,n2));

//        kthAncestor(root,5,1);

//        transform(root);
//        System.out.println(root.data);
//        System.out.println(root.left.data);
//        System.out.println(root.right.data);
//        System.out.println(root.left.left.data);
//        System.out.println(root.left.right.data);
//        System.out.println(root.right.left.data);
//        System.out.println(root.right.right.data);

    }
}
