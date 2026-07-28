class Solution {
    public int distributeCandies(int n, int limit) {
      int count=0;
      for(int first=0;first<=limit;first++){
        for(int second=0;second<=limit;second++){
         for(int third=0;third<=limit;third++){
            if(first+second+third==n){
                count++;
            }
         
    }
    } 
      } 
    return count;  
    }
}