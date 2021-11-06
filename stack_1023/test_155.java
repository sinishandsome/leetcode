import java.util.Deque;
import java.util.LinkedList;

/**
 * @author chenxin
 * @create 2021-10-23 16:39
 */

//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
//
//        push(x) —— 将元素 x 推入栈中。
//        pop()—— 删除栈顶的元素。
//        top()—— 获取栈顶元素。
//        getMin() —— 检索栈中的最小元素。
//
//        解释：
//        MinStack minStack = new MinStack();
//        minStack.push(-2);
//        minStack.push(0);
//        minStack.push(-3);
//        minStack.getMin();   --> 返回 -3.
//        minStack.pop();
//        minStack.top();      --> 返回 0.
//        minStack.getMin();   --> 返回 -2.


public class test_155 {
    public static void main(String[] args) {

    }
}

class MinStack {
    Deque<Integer> xStack;
    Deque<Integer> minStack;

    public MinStack() {
        xStack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        xStack.push(val);
        minStack.push(Math.min(minStack.peek(), val));
    }

    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
