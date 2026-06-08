class Solution {

    public ArrayList<Integer> NSL(int[] arr) {

        ArrayList<Integer> left = new ArrayList<>();
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < arr.length; i++) {

            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                left.add(-1);
            } else {
                left.add(st.peek());
            }

            st.push(i);
        }

        return left;
    }

    public ArrayList<Integer> NSR(int[] arr) {

        ArrayList<Integer> right = new ArrayList<>();
        Stack<Integer> st = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {

            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                right.add(arr.length);
            } else {
                right.add(st.peek());
            }

            st.push(i);
        }

        Collections.reverse(right);

        return right;
    }

    public int largestRectangleArea(int[] heights) {

        ArrayList<Integer> left = NSL(heights);
        ArrayList<Integer> right = NSR(heights);

        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {

            int width = right.get(i) - left.get(i) - 1;

            int area = heights[i] * width;

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}