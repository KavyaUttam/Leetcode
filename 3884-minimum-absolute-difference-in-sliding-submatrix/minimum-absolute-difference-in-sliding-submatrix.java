class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] res = new int[m - k + 1][n - k + 1];

        for(int i = 0; i <= m - k; i++){
            for(int j = 0; j <= n - k; j++){

                Set<Integer> set = new HashSet<>();
                ArrayList<Integer> list = new ArrayList<>();

                for(int r = i; r < i + k; r++){
                    for(int c = j; c < j + k; c++){
                        if(!set.contains(grid[r][c])){
                            set.add(grid[r][c]);
                            list.add(grid[r][c]);
                        }
                    }
                }

                Collections.sort(list);

                int minDiff = Integer.MAX_VALUE;

                if(list.size() <= 1){
                    minDiff = 0;
                } else {
                    for(int x = 0; x < list.size() - 1; x++){
                        minDiff = Math.min(minDiff, list.get(x+1) - list.get(x));
                    }
                }

                res[i][j] = minDiff;
            }
        }

        return res;
    }
}