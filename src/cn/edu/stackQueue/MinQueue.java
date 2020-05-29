package cn.edu.stackQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


/**
 * @auther NieBin
 * @create 2020-05-19 15:24
 *
 * 对于实现最小值队列问题，可以先将队列使用栈来实现，然后就将问题转换为最小值栈，这个问题出现在 编程之美：3.7
 */
class MinQueue {
    private Queue<Integer> dataQueue;
    private Stack<Integer> in;
    private Stack<Integer> out;
    private int currentSize;

    /**
     * initialize your data structure here.
     */
    public MinQueue() {
        dataQueue = new LinkedList<>();
        in = new Stack<>();
        out = new Stack<>();
        currentSize = in.size();
    }

    public void push(int x) {
        dataQueue.offer(x);
        while (!in.isEmpty() && x < in.peek()) {
            in.pop();
        }
        for (int i = in.size(); i <=currentSize ; i++) {
            in.add(x);
        }
    }

    public void pop() {
        dataQueue.poll();
        in2out();
        out.pop();
    }

    private void in2out(){
        if (out.isEmpty()){
            while (!in.isEmpty()){
                out.push(in.pop());
            }
        }
    }


    public int top() {
        return dataQueue.peek();
    }

    public int getMin() {
        return out.peek();
    }
}

