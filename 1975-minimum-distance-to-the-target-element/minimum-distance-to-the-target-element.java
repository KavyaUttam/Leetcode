class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int n = nums.length;
        
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        
        queue.offer(start);
        visited[start] = true;
        int distance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
               if (nums[curr] == target) {
                    return distance;
                }
                // Move left
                if (curr - 1 >= 0 && !visited[curr - 1]) {
                    queue.offer(curr - 1);
                    visited[curr - 1] = true;
                }
                // Move right
                if (curr + 1 < n && !visited[curr + 1]) {
                    queue.offer(curr + 1);
                    visited[curr + 1] = true;
                }
            }
            
            distance++;
        }
        
        return -1;
    }
}