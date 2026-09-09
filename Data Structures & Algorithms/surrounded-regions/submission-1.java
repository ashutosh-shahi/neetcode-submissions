class Solution {
    public void dfs(char[][] board, int row, int col, int[][] vis) {
        vis[row][col] = 1;
        int n = board.length;
        int m = board[0].length;
        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};
        for(int i = 0; i < 4; i++) {
            int nr = row + dr[i];
            int nc = col + dc[i];
            if(nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
            if(vis[nr][nc] != 1 && board[nr][nc] == 'O') {
                dfs(board, nr, nc, vis);
            }
        }
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] vis = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if((i == 0 || i == n-1 || j ==0 || j == m-1) && board[i][j] == 'O') {
                    dfs(board, i, j, vis);
                }
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == 'O' && vis[i][j] == 0) {
                    board[i][j] = 'X';
                }
            }
        }

    }
}
