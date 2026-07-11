class Solution {
    public int[] arrayRankTransform(int[] arr) {
       int[] copy = arr.clone();
       Arrays.sort(copy);
       Map<Integer,Integer>mp=new HashMap<>();
       int rank=1;
       for(int num:copy){
        if(!mp.containsKey(num)){
        mp.put(num,rank);
        rank++;
        }
       }
       for(int i=0;i<arr.length;i++){
        arr[i]=mp.get(arr[i]);
       }
       return arr;
    }
}