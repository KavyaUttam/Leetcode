class Solution {
    private boolean canMake(int[] bloomDay, int day, int k, int m){
        int bouquet = 0;
        int count = 0;
        for(int i = 0; i<bloomDay.length; i++){
            if(bloomDay[i] <= day){
                count++;
                if(count == k){
                    bouquet++;
                    count = 0;
                }
            }else{
                count = 0;
            }
        }

        return bouquet >= m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int n =  bloomDay.length;

        if(bloomDay.length < (long) m*k) return -1;

        for(int i = 0; i < n; i++){
            max = Math.max(max, bloomDay[i]);
            min = Math.min(min, bloomDay[i]);
        }

        int start = min;
        int end = max;
        int ans = max;
        while(start <= end){
            int mid = start + (end - start)/2;

            boolean make = canMake(bloomDay, mid, k, m);
            if(make){
                ans = mid;
                end = mid-1;
            }else{
                start = mid + 1;
            }

            
        }

        return ans;
    }
}
