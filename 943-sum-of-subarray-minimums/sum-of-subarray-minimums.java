import java.util.Stack;

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long total = 0;
        long M = (long) 1e9 + 7;
        Stack<Integer> s = new Stack<>();
        
        for (int i = 0; i <= n; i++) {
            int currentVal = (i == n) ? -1 : arr[i];
            
            while (!s.isEmpty() && arr[s.peek()] >= currentVal) {
                int mid = s.pop();
                long right = i - mid; 
                long left = s.isEmpty() ? (mid + 1) : (mid - s.peek()); 
                
                long count = (left * right) % M;
                total = (total + (count * arr[mid]) % M) % M;
            }
            s.push(i);
        }
        
        return (int) total;
    }
}