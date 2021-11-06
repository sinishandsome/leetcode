import java.util.Deque;
import java.util.LinkedList;

/**
 * @author chenxin
 * @create 2021-10-19 11:20
 */
public class test_232 {
    public static void main(String[] args) {

    }
}

class MyQueue {
    Deque<Integer> inStack = new LinkedList<>();
    Deque<Integer> outStack = new LinkedList<>();
    public MyQueue() {

    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if (outStack.isEmpty()) {
            inToOut();
        }
        return outStack.pop();
    }

    public int peek() {
        if (outStack.isEmpty()) {
            inToOut();
        }
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    public void inToOut() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }
}
