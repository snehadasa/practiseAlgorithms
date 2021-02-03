package LeetCode.Medium;

import java.util.Stack;

public class NumberOfIslands {
 //   Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.

//    An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
//    You may assume all four edges of the grid are all surrounded by water.
//
//
//
//    Example 1:
//
//    Input: grid = [
//            ["1","1","1","1","0"],
//            ["1","1","0","1","0"],
//            ["1","1","0","0","0"],
//            ["0","0","0","0","0"]
//            ]
//    Output: 1
//    Example 2:
//
//    Input: grid = [
//            ["1","1","0","0","0"],
//            ["1","1","0","0","0"],
//            ["0","0","1","0","0"],
//            ["0","0","0","1","1"]
//            ]
//    Output: 3
//
//
//    Constraints:
//
//    m == grid.length
//    n == grid[i].length
//1 <= m, n <= 300
//    grid[i][j] is '0' or '1'.

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == '1') {
                    count+= 1;
                    breadthFirstSearch(grid, row, col);  //setting if encountered '1' to '0' amd also checking the coundaries if it has '1'
                }
            }
        }
        return count;
    }

    private void breadthFirstSearch(char[][] grid, int row, int col) {

        //check if row and col are out of the length and if it is only 0;
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col] == '0')
            return;

        //checking if boundaries has 1's.
        grid[row][col] = '0'; //if we see a '1', set that value to '0' so that it is not counted again.
        breadthFirstSearch(grid, row+1, col); //recursive check for upper row
        breadthFirstSearch(grid, row-1, col); //bottom row
        breadthFirstSearch(grid, row, col+1);  //right column
        breadthFirstSearch(grid, row, col-1);  //left column
    }

    public static void main(String[] args) {
        char[][] grid = {
        {'0','1','1','1','0'},
        {'1','1','0','1','0'},
        {'1','1','0','0','1'},
        {'0','0','1','0','0'}
            };

        NumberOfIslands res = new NumberOfIslands();
        System.out.println(res.numIslands(grid));
    }

    //method2
    public int numIslands2(char[][] grid) {
        int count=0;
        boolean visited[][]=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]!='0' && visited[i][j]==false){
                    count++;
                    countIslands(grid,i,j,visited);
                }
            }
        }
        return count;
    }
    private void countIslands(char grid[][],int i,int j,boolean visited[][]){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]=='0' || visited[i][j]==true){
            return;
        }
        visited[i][j]=true;
        countIslands(grid,i-1,j,visited);
        countIslands(grid,i+1,j,visited);
        countIslands(grid,i,j-1,visited);
        countIslands(grid,i,j+1,visited);
    }

    //method3
    public int numIslands3(char[][] grid) {

        int islandCount = 0;
        for(int i = 0; i<grid.length; i++)
        {
            for(int j = 0; j<grid[i].length; j++)
            {
                if(grid[i][j] == '1')
                {
                    islandCount++;
                    j = markLand(grid, i, j)+1;
                }
            }
        }
        return islandCount;
    }
    class coordObj
    {
        int row;
        int col;
        public coordObj(int xPos, int yPos)
        {
            row = xPos;
            col = yPos;
        }
    }
    public int markLand(char[][] grid, int x, int y)
    {
        coordObj startCoord = new coordObj(x,y);
        Stack<coordObj> coords = new Stack<coordObj>();
        grid[x][y] = 2;
        coords.push(startCoord);
        int maxCol = y;
        while(!coords.isEmpty())//mark surroundings
        {
            coordObj topCoord = coords.pop();
            int currRow = topCoord.row;
            int currCol = topCoord.col;
            if(currRow-1 >= 0 && grid[currRow-1][currCol] == '1')//check if 0
            {
                //append to stack
                coordObj newCoord = new coordObj(currRow-1, currCol);
                coords.push(newCoord);
                //change value to 2
                grid[currRow-1][currCol] = '2';
            }
            if(currRow+1 < grid.length && grid[currRow+1][currCol] == '1')
            {
                coordObj newCoord = new coordObj(currRow+1, currCol);
                coords.push(newCoord);
                //change value to 2
                grid[currRow+1][currCol] = '2';
            }
            if(currCol - 1 >= 0 && grid[currRow][currCol-1] == '1')
            {
                coordObj newCoord = new coordObj(currRow, currCol-1);
                coords.push(newCoord);
                //change value to 2
                grid[currRow][currCol-1] = '2';
            }
            if(currCol + 1 < grid[currRow].length && grid[currRow][currCol+1] == '1')
            {
                coordObj newCoord = new coordObj(currRow, currCol+1);
                coords.push(newCoord);
                //change value to 2
                grid[currRow][currCol+1] = '2';
                if(currCol+1>maxCol && currRow == x){maxCol = currCol+1;}
            }
        }
        return maxCol;
    }
}
