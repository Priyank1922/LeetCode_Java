import java.util.HashSet;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> check = new HashSet<>();
        
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                char x = board[i][j];
                if(x != '.'){

                    if(!check.add(x + " in row " + i)) return false;
                    

                    if(!check.add(x + " in col " + j)) return false;
                    
                    
                    if(!check.add(x + " in box " + i/3 + "-" + j/3)) return false;
                }
            }
        }
        return true;
    }
}
