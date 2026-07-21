class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zerocount=0;
         int totalproduct=1;
         int n=nums.length;
         int result[]= new int[n];
     for(int i=0;i<n;i++){
        if(nums[i]==0){
            zerocount++;

        }else{
        totalproduct*=nums[i];}
     } 
     for(int i=0;i<n;i++){
        if(zerocount>1){
            result[i]=0;
        }
        else if(zerocount==1){
            result[i]=(nums[i]==0)?totalproduct:0;
        }
        else{
            result[i]=totalproduct / nums[i];
        }
     }
     return result;  
    }
}