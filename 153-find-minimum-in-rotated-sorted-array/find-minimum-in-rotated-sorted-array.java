class Solution {
    public int findMin(int[] nums) {
      int minVal = Integer.MAX_VALUE;
      int low=0;
      int high=nums.length-1;
      while(low<=high){
        int mid= (low+high)/2;
        if(nums[low]<=nums[mid]){
            minVal=Math.min(minVal,nums[low]);
            low=mid+1;
        }
        else{
            high=mid-1;
             minVal=Math.min(minVal,nums[mid]);
        }
      }
      return minVal;
    }
}