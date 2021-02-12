package LeetCode.Easy;

public class TicTacToe {
//    Tic-tac-toe is played by two players A and B on a 3 x 3 grid.
//
//    Here are the rules of Tic-Tac-Toe:
//
//    Players take turns placing characters into empty squares (" ").
//    The first player A always places "X" characters, while the second player B always places "O" characters.
//"X" and "O" characters are always placed into empty squares, never on filled ones.
//    The game ends when there are 3 of the same (non-empty) character filling any row, column, or diagonal.
//    The game also ends if all squares are non-empty.
//    No more moves can be played if the game is over.
//    Given an array moves where each element is another array of size 2 corresponding to the row and column of the
//    grid where they mark their respective character in the order in which A and B play.
//
//    Return the winner of the game if it exists (A or B), in case the game ends in a draw return "Draw", if there are
//    still movements to play return "Pending".
//
//    You can assume that moves is valid (It follows the rules of Tic-Tac-Toe), the grid is initially empty and
//    A will play first.
//
//
//
//    Example 1:
//
//    Input: moves = [[0,0],[2,0],[1,1],[2,1],[2,2]]
//    Output: "A"
//    Explanation: "A" wins, he always plays first.
//            "X  "    "X  "    "X  "    "X  "    "X  "
//            "   " -> "   " -> " X " -> " X " -> " X "
//            "   "    "O  "    "O  "    "OO "    "OOX"
//    Example 2:
//
//    Input: moves = [[0,0],[1,1],[0,1],[0,2],[1,0],[2,0]]
//    Output: "B"
//    Explanation: "B" wins.
//"X  "    "X  "    "XX "    "XXO"    "XXO"    "XXO"
//        "   " -> " O " -> " O " -> " O " -> "XO " -> "XO "
//        "   "    "   "    "   "    "   "    "   "    "O  "
//    Example 3:
//
//    Input: moves = [[0,0],[1,1],[2,0],[1,0],[1,2],[2,1],[0,1],[0,2],[2,2]]
//    Output: "Draw"
//    Explanation: The game ends in a draw since there are no moves to make.
//"XXO"
//        "OOX"
//        "XOX"
//    Example 4:
//
//    Input: moves = [[0,0],[1,1]]
//    Output: "Pending"
//    Explanation: The game has not finished yet.
//            "X  "
//            " O "
//            "   "
//
//
//    Constraints:
//
//            1 <= moves.length <= 9
//    moves[i].length == 2
//            0 <= moves[i][j] <= 2
//    There are no repeated elements on moves.
//    moves follow the rules of tic tac toe.

    public String tictactoe(int[][] moves) {
        char[][] ticTacToePlayer = new char[3][3];  //which player has made that particular move

        //Player 1 as A, 2 as B, '' then none have played;

        for (int i = 0; i < moves.length; i++) {
            int[] move = moves[i];
            char player = i % 2 == 0 ? 'A' : 'B';  //length = 3 and it starts from 0;
            ticTacToePlayer[move[0]][move[1]] = player;  //Determine which player is playing
        }

        //check if rows are same
        for (int row = 0; row < 3; row++) {
            if (ticTacToePlayer[row][0] == 'A' || ticTacToePlayer[row][0] == 'B') {   //if the block is not played yet(pending condition)
                if (ticTacToePlayer[row][0] == ticTacToePlayer[row][1] && ticTacToePlayer[row][0] == ticTacToePlayer[row][2]) {
                    return ticTacToePlayer[row][0] == 'A' ? "A" : "B";
                }
            }
        }

        //check if col are same
        for (int col = 0; col < 3; col++) {
            if (ticTacToePlayer[0][col] == 'A' || ticTacToePlayer[0][col] == 'B') {
                if (ticTacToePlayer[0][col] == ticTacToePlayer[1][col] && ticTacToePlayer[0][col] == ticTacToePlayer[2][col]) {
                    return ticTacToePlayer[0][col] == 'A' ? "A" : "B";
                }
            }
        }

        //check if primary diagonal is same
        if (ticTacToePlayer[0][0] == 'A' || ticTacToePlayer[0][0] == 'B') {
            if (ticTacToePlayer[0][0] == ticTacToePlayer[1][1] && ticTacToePlayer[0][0] == ticTacToePlayer[2][2]) {
                return ticTacToePlayer[0][0] == 'A' ? "A" : "B";
            }
        }

        //check if secondary diagonals is same
        if (ticTacToePlayer[0][0] == 'A' || ticTacToePlayer[0][0] == 'B') {
            if (ticTacToePlayer[2][0] == ticTacToePlayer[1][1] && ticTacToePlayer[2][0] == ticTacToePlayer[0][2]) {
                return ticTacToePlayer[2][0] == 'A' ? "A" : "B";
            }
        }

        return moves.length == 9 ? "Draw" : "Pending";
    }

    public static void main(String[] args) {
        int [][]moves = {{0,0},{1,1},{2,0},{1,0},{1,2},{2,1},{0,1},{0,2},{2,2}};
        TicTacToe res = new TicTacToe();
        System.out.println(res.tictactoe(moves));
    }
}