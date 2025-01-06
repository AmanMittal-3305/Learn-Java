import java.util.*;

public class startsWith_Trie {
    static class Node{
        Node[] children = new Node[26];
        boolean eow ;

        public Node(){
            for(int i = 0; i < 26; i++){
                children[i] = null;
            }
        }
    }

}
