import java.util.*;

public class WordBreak_Trie {
    static class Node{
        Trie.Node[] children = new Trie.Node[26];
        boolean eow = false;

        Node(){
            for(int i = 0; i < 26; i++){
                children[i] = null;
            }
        }
    }

    public static Trie.Node root = new Trie.Node();

    public static void insert(String word){ // O(L)
        Trie.Node curr = root;
        for(int level = 0; level < word.length(); level++){
            int idx = word.charAt(level) - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Trie.Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public static boolean search(String word){ // O(L)
        Trie.Node curr = root;
        for(int i = 0; i < word.length(); i++){
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow;
    }

    public static boolean wordBreak(String key){
        if(key.length() == 0){
            return true;
        }
        for(int i = 1; i <= key.length(); i++){
            if( search(key.substring(0,i)) &&
            wordBreak(key.substring(i)) ){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] arr = {"i", "like", "sam", "samsung","mobile", "ice" };
        for (String s : arr) {
            insert(s);
        }
        String key = "ilikesamsung";
        System.out.println(wordBreak(key));
    }
}
