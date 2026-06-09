import java.util.*;

class Solution {

    public int[] NSR(int[] arr) {
        int n = arr.length;
        Stack<Integer> s = new Stack<>();
        int[] right = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }

            right[i] = s.isEmpty() ? n : s.peek();
            s.push(i);
        }

        return right;
    }

    public int[] NSL(int[] arr) {
        int n = arr.length;
        Stack<Integer> s = new Stack<>();
        int[] left = new int[n];

        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }

            left[i] = s.isEmpty() ? -1 : s.peek();
            s.push(i);
        }

        return left;
    }

    public int MAH(int[] arr) {
        int n = arr.length;

        int[] right = NSR(arr);
        int[] left = NSL(arr);

        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            int width = right[i] - left[i] - 1;
            int area = arr[i] * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public int maximalRectangle(char[][] matrix) {

        if (matrix == null || matrix.length == 0)
            return 0;

        int n = matrix.length;
        int m = matrix[0].length;

        int[] heights = new int[m];
        int maxArea = 0;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                if (matrix[i][j] == '1')
                    heights[j]++;
                else
                    heights[j] = 0;
            }

            maxArea = Math.max(maxArea, MAH(heights));
        }

        return maxArea;
    }
}