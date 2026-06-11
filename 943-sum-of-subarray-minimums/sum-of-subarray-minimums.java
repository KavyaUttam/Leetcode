import java.util.Stack;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    static ArrayList<Integer> NSL(int[] arr) {
        Stack<Integer> s = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                res.add(i + 1); 
            } else {
                res.add(i - s.peek()); 
            }
            s.push(i); 
        }
        return res;
    }

    public static ArrayList<Integer> NSR(int[] arr) {
        Stack<Integer> s = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] > arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                res.add(arr.length - i);
            } else {
                res.add(s.peek() - i);
            }
            s.push(i); 
        }
        Collections.reverse(res); 
        return res;
    }

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long total = 0;
        long M = (long) 1e9 + 7;
        ArrayList<Integer> leftList = NSL(arr); 
        ArrayList<Integer> rightList = NSR(arr);
        
        for (int i = 0; i < n; i++) {
            long left = leftList.get(i);
            long right = rightList.get(i);
            
            long count = (left * right) % M;
            total = (total + (count * arr[i]) % M) % M;
        }
        
        return (int) total;
    }
}