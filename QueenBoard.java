public class QueenBoard{
  private int[][] board;

  public QueenBoard(int size){
    board = new int[size][size];
}

private void threaten(int r, int c) {
  for (int rII = r -1; rII >=0; rII--) {
    board[rII][c]++; //add up by 1 each threaten up the column
  }
  for (int rI = r + 1; rI < board.length; rI++) {
    board[rI][c]++;
    //add up by 1 each threaten down the column
  }
  for (int cII = c -1; cII >= 0; cII--) {
    board[r][cII]++;
  }
  for (int cI = c + 1; cI < board.length; cI++) {
    board[r][cI]++;
  }
  //mark off the row threatened. ^
}
public boolean addQueen(int r, int c) {
  if (board[r][c] == 0) {
    board[r][c]--;
    threaten(r,c);
    return true;
  }else{
    return false;
  }
}
//private boolean removeQueen(int r, int c)


/**
*@return The output string formatted as follows:
*All numbers that represent queens are replaced with 'Q'
*all others are displayed as underscores '_'
*There are spaces between each symbol:
*"""_ _ Q _
*Q _ _ _

*_ _ _ Q

*_ Q _ _"""
*(pythonic string notation for clarity,
*excludes the character up to the *)
*/
public String toString(){
  String out = "";
  for (int i = 0; i < board.length; i++) {
    for (int j = 0; j < board.length; j++) {
      if (board[i][j] == 0) out += "_ ";
      if (board[i][j] == -1) out += "Q ";
      if (board[i][j] > 0) out += "X ";
    }
    out += "\n";
  }
  return out;
}
}
