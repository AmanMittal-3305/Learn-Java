public class Word_Search {
    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public boolean findWord(int i, int j, int idx, String word, char[][] board){
        if(idx == word.length()){
            return true;
        }
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '$'){
            return false;
        }
        if(board[i][j] != word.charAt(idx)){
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '$';

        for(int[] t : dir){
            int new_i = i + t[0];
            int new_j = j + t[1];

            if(findWord(new_i, new_j , idx+1, word, board)){
                return true;
            }
        }
        board[i][j] = temp;

        return false;
    }
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == word.charAt(0) && findWord(i, j, 0, word, board)){
                    return true;
                }
            }
        }

        return false;
    }
}
