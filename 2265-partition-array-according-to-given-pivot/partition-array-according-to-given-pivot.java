class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
    //   ArrayList<Integer>ans=new ArrayList<>();
    

      int n=nums.length;
      int[] ans=new int[n];
      int i=0;
      int j=n-1;
      for(int l=0,r=n-1;l<n;l++,r--){
        if(nums[l]<pivot){
            ans[i]=nums[l];
            i++;
        }
        if(nums[r]>pivot){
            ans[j]=nums[r];
            j--;
        }
      } 
      while(i<=j){
       ans[i]=pivot;
       i++;
      } 
      return ans;
    }
}