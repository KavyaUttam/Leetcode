class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length;
        int m = maze[0].length;
        int ans = Integer.MAX_VALUE;
        boolean[][] visited = new boolean[n][m];
        ans = Math.min(ans, bfs(entrance[0], entrance[1], 0, maze, visited));
        return ans;

    }

    int bfs(int i, int j, int distance, char[][] maze, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        int[] dx = { 0, 0, -1, 1 };
        int[] dy = { -1, 1, 0, 0 };
        visited[i][j] = true;
        q.add(new int[] { i, j, distance });
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            int crntdist = curr[2];
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= 0 && ny >= 0 && nx < maze.length && ny < maze[0].length && !visited[nx][ny]
                        && maze[nx][ny] == '.') {
                    visited[nx][ny] = true;

                    q.add(new int[] { nx, ny, crntdist + 1 });
                }

            }
            if ((x == 0 || y == 0 || x == maze.length - 1 || y == maze[0].length - 1)
                    && !(x == i && y == j)) {
                return crntdist;
            }
        }
        return -1;
    }
}