package datastructures.Queue;

import java.util.ArrayDeque;
import java.util.Queue;

class PairForCountIslands {

    int x;
    int y;

    public PairForCountIslands(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class CountNumberOfIslands {
//    Given a binary matrix where 0 represents water and 1 represents islands, count the number of islands in it.
//    An island is formed by connected ones.

    private static final int[] row = {-1, -1, -1, 0, 1, 0, 1, 1};
    private static final int[] col = {-1, 1, 0, -1, -1, 1, 0, 1};

    public static boolean isSafe(int[][] mat, int x, int y, boolean[][] processed) {
        return (x >= 0 && x < processed.length) && (y >= 0 && y < processed[0].length) &&
                (mat[x][y] == 1 && !processed[x][y]);
    }

    public static void bfs(int[][] mat, boolean[][] processed, int i, int j) {
        Queue<PairForCountIslands> queue = new ArrayDeque<>();
        queue.add(new PairForCountIslands(i, j));

        processed[i][j] = true;

        while (!queue.isEmpty()) {
            int x = queue.peek().x;
            int y = queue.peek().y;
            queue.poll();

            for (int k = 0; k < 8; k++) {
                if (isSafe(mat, x+row[k], y+col[k], processed)) {
                    processed[x+row[k]][y+col[k]] = true;
                    queue.add(new PairForCountIslands(x+row[k], y+col[k]));
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] mat=
                {
                        { 1, 0, 1, 0, 0, 0, 1, 1, 1, 1 },
                        { 0, 0, 1, 0, 1, 0, 1, 0, 0, 0 },
                        { 1, 1, 1, 1, 0, 0, 1, 0, 0, 0 },
                        { 1, 0, 0, 1, 0, 1, 0, 0, 0, 0 },
                        { 1, 1, 1, 1, 0, 0, 0, 1, 1, 1 },
                        { 0, 1, 0, 1, 0, 0, 1, 1, 1, 1 },
                        { 0, 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                        { 0, 0, 0, 1, 0, 0, 1, 1, 1, 0 },
                        { 1, 0, 1, 0, 1, 0, 0, 1, 0, 0 },
                        { 1, 1, 1, 1, 0, 0, 0, 1, 1, 1 }
                };

        int M = mat.length;
        int N = mat[0].length;

        boolean[][] processed = new boolean[M][N];
        int island = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (mat[i][j] == 1 && !processed[i][j]) {
                    bfs(mat, processed, i, j);
                    island++;
                }
            }
        }
        System.out.println(island);
    }
}
