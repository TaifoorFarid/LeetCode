public class MaxAreaOdisland695 {
    public int maxAreaOfIsland(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int maxArea = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    int islandSize = DFS(grid, i, j);
                    maxArea = (islandSize > maxArea) ? islandSize : maxArea;
                }
            }
        }
        return maxArea;
    }

    private int DFS(int[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0)
            return 0;

        int count = 1;
        grid[r][c] = 0;

        count += DFS(grid, r + 1, c);
        count += DFS(grid, r - 1, c);
        count += DFS(grid, r, c + 1);
        count += DFS(grid, r, c - 1);

        return count;
    }
}
