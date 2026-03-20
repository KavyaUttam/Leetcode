import java.util.*;

class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid2.length;
        int n = grid2[0].length;

        boolean[][] vis = new boolean[m][n];
        int count = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid2[i][j] == 1 && !vis[i][j]){
                    if(bfs(grid1, grid2, vis, i, j)){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private boolean bfs(int[][] grid1, int[][] grid2, boolean[][] vis, int i, int j){
        int m = grid2.length;
        int n = grid2[0].length;

        Queue<int[]> q = new LinkedList<>();
        Set<String> island = new HashSet<>();

        q.offer(new int[]{i, j});
        vis[i][j] = true;

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        // BFS traversal
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            island.add(r + "," + c); 

            for(int[] d : dirs){
                int nr = r + d[0];
                int nc = c + d[1];

                if(nr >= 0 && nc >= 0 && nr < m && nc < n &&
                   grid2[nr][nc] == 1 && !vis[nr][nc]){

                    vis[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        for(String cell : island){
            String[] parts = cell.split(",");
            int r = Integer.parseInt(parts[0]);
            int c = Integer.parseInt(parts[1]);

            if(grid1[r][c] == 0){
                return false;
            }
        }

        return true;
    }
}