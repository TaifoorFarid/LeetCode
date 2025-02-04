import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    Queue<Integer> que1;
    Queue<Integer> que2;

    public MyStack() {
        que1 = new LinkedList<>();
        que2 = new LinkedList<>();
    }

    public void push(int x) {
        if (que1.isEmpty()) {
            que1.add(x);
            while (!que2.isEmpty()) {
                que1.add(que2.poll());
            }
        } else {
            que2.add(x);
            while (!que1.isEmpty()) {
                que2.add(que1.poll());
            }
        }
    }

    public int pop() {
        if (!que1.isEmpty()) {
            return que1.poll();
        } else if (!que2.isEmpty()) {
            return que2.poll();
        } else {
            return -1;
        }
    }

    public int top() {
        if (!que1.isEmpty()) {
            return que1.peek();
        } else if (!que2.isEmpty()) {
            return que2.peek();
        } else {
            return -1;
        }
    }

    public boolean empty() {
        return que1.isEmpty() && que1.isEmpty();
    }
}
