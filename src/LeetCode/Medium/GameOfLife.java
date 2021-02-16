package LeetCode.Medium;

import java.util.Arrays;

public class GameOfLife {
//    According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised
//    by the British mathematician John Horton Conway in 1970."
//
//    The board is made up of an m x n grid of cells, where each cell has an initial state: live
//            (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight
//    neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
//
//    Any live cell with fewer than two live neighbors dies as if caused by under-population.
//    Any live cell with two or three live neighbors lives on to the next generation.
//    Any live cell with more than three live neighbors dies, as if by over-population.
//    Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
//    The next state is created by applying the above rules simultaneously to every cell in the current state, where
//    births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.
//
//
//
//            Example 1:
//
//
//    Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
//    Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
//    Example 2:
//
//
//    Input: board = [[1,1],[1,0]]
//    Output: [[1,1],[1,1]]
//
//
//    Constraints:
//
//    m == board.length
//    n == board[i].length
//1 <= m, n <= 25
//    board[i][j] is 0 or 1.
//
//
//    Follow up:
//
//    Could you solve it in-place? Remember that the board needs to be updated simultaneously: You cannot update some
//    cells first and then use their updated values to update other cells.
//    In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause
//    problems when the active area encroaches upon the border of the array (i.e., live cells reach the border). How would
//    you address these problems?

//    public int bfs(int[][] board, int row, int col) {
//        int count = 0;
//        if (row < 0 || row > board.length - 1 || col < 0 || col > board[row].length - 1) {
//            return 0;
//        }
//        int countStatus = board[row][col];
//        if (row > 0 && board[row - 1][col] == 1) {
//            count++;
//        }
//        if (board.length < 0 && board[row + 1][col] == 1) {
//            count++;
//        }
//        if (col > 0 && board[row][col - 1] == 1) {
//            count++;
//        }
//        if (board.length < 0 && board[row][col + 1] == 1) {
//            count++;
//        }
//        return count;
//    }
//
//    public void gameOfLife1(int[][] board) {
//        int count = 0;
//        for (int row = 0; row < board.length; row++) {
//            for (int col = 0; col < board[0].length; col++) {
//                if (board[row][col] == 1) {
//                    count = bfs(board, row, col);
//                }
//                if (count < 2) {
//                    board[row][col] = 0;
//                } else if (count >= 2) {
//                    continue;
//                } else if (count >= 3 && board[row][col] == 1) {
//                    board[row][col] = 0;
//                } else if (count == 3 && board[row][col] == 0) {
//                    board[row][col] = 1;
//                }
//            }
//        }
//
////        for (int row = 0; row < board.length; row++) {
////            for (int col = 0; col < board[row].length; col++) {
////                if (count < 2) {
////                    board[row][col] = 0;
////                } else
////                if (count >= 2) {
////                    continue;
////                } else
////                if (count >= 3 && board[row][col] == 1) {
////                    board[row][col] = 0;
////                } else
////                if (count == 3 && board[row][col] == 0) {
////                    board[row][col] = 1;
////                }
////            }
////        }
//    }

    //private int[][] board;

    public int getCountOfBoardOnes(int[][] board, int row, int col) {
        int liveCells = 0;

        if (row > 0 && board[row - 1][col] == 1) {
            liveCells++;
        }
        if (row < (board.length - 1) && board[row + 1][col] == 1) {
            liveCells++;
        }
        if (col > 0 && board[row][col - 1] == 1) {
            liveCells++;
        }
        if (col < board[row].length - 1 && board[row][col + 1] == 1) {
            liveCells++;
        }
        if (row < (board.length - 1) && col < (board[row].length - 1) && board[row+1][col+1] == 1) {
            liveCells++;
        }
        if (row > 0 && col > 0 && board[row-1][col-1] == 1) {
            liveCells++;
        }
        if (row > 0 && col < board[row].length-1 && board[row-1][col+1] == 1) {
            liveCells++;
        }
        if (row < board.length-1 && col > 0 && board[row+1][col-1] == 1) {
            liveCells++;
        }
        return liveCells;
    }

    public int[][] gameOfLife(int[][] board) {
        int count = 0;
        int[][] copyBoard = new int[board.length][board[0].length];

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == 1) {
                    count = getCountOfBoardOnes(board, row, col);
                }

                if (count < 2) {
                    copyBoard[row][col] = 0;
                } else if (count == 2 || count == 3) {
                    copyBoard[row][col] = 1;
                } else if (count == 3 && board[row][col] == 0) {
                    copyBoard[row][col] = 1;
                } else if (count >= 3 && board[row][col] == 1) {
                    copyBoard[row][col] = 0;
                }
            }
        }
        return copyBoard;
    }

//    public static void main(String[] args) {
//        GameOfLife res = new GameOfLife();
//        int[][] board = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board.length; j++) {
//                //System.out.print(res.getCountOfBoardOnes(board, i, j));
//                System.out.println(res.gameOfLife(board[i][j]));
//                System.out.print(",");
//            }
//            System.out.println("");
//        }
//        //System.out.println(Arrays.toString(res.gameOfLife(board)));
//        //res.gameOfLife(boards);
//    }
}


////method2
//class Solution {
//    private int[][] board;
//
//    public void gameOfLife(int[][] board) {
//        this.board = board;
//
//        dfs(0, 0);
//    }
//
//    private void dfs(int i, int j) {
//        if (i < 0 || i > board.length - 1 || j < 0 || j > board[i].length - 1)
//            return;
//
//        int status = calculcateNextState(i, j);
//        if (j + 1 < board[i].length)
//            dfs(i, j + 1);
//        else
//            dfs(i + 1, 0);
//        board[i][j] = status;
//    }
//
//
//    private int calculcateNextState(int i, int j) {
//        int next = getState(i, j + 1);
//        int prev = getState(i, j - 1);
//        int up = getState(i - 1, j);
//        int down = getState(i + 1, j);
//        int prevUp = getState(i - 1, j - 1);
//        int nextUp = getState(i - 1, j + 1);
//        int nextDown = getState(i + 1, j + 1);
//        int prevDown = getState(i + 1, j - 1);
//
//        int liveCells =
//                (next == 1 ? 1 : 0) +
//                        (prev == 1 ? 1 : 0) +
//                        (up == 1 ? 1 : 0) +
//                        (down == 1 ? 1 : 0) +
//                        (prevUp == 1 ? 1 : 0) +
//                        (nextUp == 1 ? 1 : 0) +
//                        (nextDown == 1 ? 1 : 0) +
//                        (prevDown == 1 ? 1 : 0);
//
//        if (board[i][j] == 1) {
//            if (liveCells < 2 || liveCells > 3)
//                return 0;
//            else
//                return 1;
//        } else {
//            if (liveCells == 3)
//                return 1;
//            else
//                return 0;
//        }
//
//    }
//
//    private int getState(int i, int j) {
//        if (i < 0 || i > board.length - 1 || j < 0 || j > board[i].length - 1)
//            return -1;
//        else
//            return board[i][j];
//    }
//}
