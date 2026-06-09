class MinStack {
    Stack<Integer> s = new Stack<>();
    Stack<Integer> ss = new Stack<>();

    public MinStack() {

    }

    public void push(int value) {
        s.push(value);

        if (ss.isEmpty() || ss.peek() >= value) {
            ss.push(value);
        }
    }

    public void pop() {
        if (s.isEmpty()) {
            return;
        }

        int ans = s.pop();

        if (ss.peek() == ans) {
            ss.pop();
        }
    }

    public int top() {
        if (s.isEmpty()) {
            return -1;
        }

        return s.peek();
    }

    public int getMin() {
        if (ss.isEmpty()) {
            return -1;
        }

        return ss.peek();
    }
}