public class IslandCount200 {

    public static void main(String[] args) {
        char[][] grid = {
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' }
        };
        IslandCount200 i = new IslandCount200();
        System.out.println(i.numIslands(grid));
    }

    public int numIslands(char[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int islandCount = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == '1') {
                    DFS(grid, i, j);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }

    private void DFS(char[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0')
            return;

        grid[r][c] = '0';

        DFS(grid, r + 1, c);
        DFS(grid, r - 1, c);
        DFS(grid, r, c + 1);
        DFS(grid, r, c - 1);
    }
}
// { '1', '1', '1', '1', '0' },
// { '1', '1', '0', '1', '0' },
// { '1', '1', '0', '0', '0' },
// { '0', '0', '0', '0', '0' }