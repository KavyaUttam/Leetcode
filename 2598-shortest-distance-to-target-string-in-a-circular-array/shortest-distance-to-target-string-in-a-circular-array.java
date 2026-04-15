class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
       int n=words.length;
       int result=Integer.MAX_VALUE;
       for(int i=0;i<n;i++){
        if (words[i].equals(target)){
            int straightdistance=Math.abs(i-startIndex);
            int circulardistance=n-straightdistance;
            result=Math.min(result,Math.min(straightdistance, circulardistance));
        }
       } 
       return result==Integer.MAX_VALUE ?-1:result;
    }
}