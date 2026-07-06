class Solution {
    public int majorityElement(int[] nums) {
        //Moore voting algorithm
     int n=nums.length;
     int count=0;
     int element=0;
     for(int num:nums){
        if(count==0){
            element=num;
            
        }
        if(num==element){
            count++;
        }
        else{
            count--;
        }
     }
     return element;
    }
}