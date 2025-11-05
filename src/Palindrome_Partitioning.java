import java.util.*;

public class Palindrome_Partitioning {
    public boolean isPallindrome(String s, int start, int end){
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public void backtrack(String s, int idx, int n, List<String>  curr, List<List<String>> res){
        if(idx == n){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i = idx; i < n; i++){
            if(isPallindrome(s, idx, i)){
                curr.add(s.substring(idx, i + 1));
                backtrack(s, i + 1, n, curr, res);
                curr.remove(curr.size() - 1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        int n = s.length();
        List<List<String>> res = new ArrayList<>();
        List<String>  curr = new ArrayList<>();
        backtrack(s, 0, n, curr, res);
        return res;
    }
}
