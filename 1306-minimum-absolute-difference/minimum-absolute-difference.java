class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(arr);
        int i=0,j=1,n=arr.length;
        int mindiff=arr[j]-arr[i];
        result.add(Arrays.asList(arr[i],arr[j]));
        i++;
        j++;
        while(j<n){
            int diff=arr[j]-arr[i];
            if(diff<mindiff){
                mindiff=diff;
                result.clear();
                result.add(Arrays.asList(arr[i],arr[j]));
            }else if(diff==mindiff){
                result.add(Arrays.asList(arr[i],arr[j]));
            }
            i++;
            j++;
        }
        return result;
    }
}