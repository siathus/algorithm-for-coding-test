package challenge.april_2021.week1.design_circular_queue;

class MyCircularQueue {

    private int front;
    private int rear;
    private int[] circularQueue;

    public MyCircularQueue(int k) {
        circularQueue = new int[k + 1];
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        rear = (rear + 1) % circularQueue.length;
        circularQueue[rear] = value;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        front = (front + 1) % circularQueue.length;
        return true;
    }

    public int Front() {
        if (isEmpty()) return -1;
        return circularQueue[(front + 1) % circularQueue.length];
    }

    public int Rear() {
        if (isEmpty()) return -1;
        return circularQueue[rear];
    }

    public boolean isEmpty() {
        if (front == rear)
            return true;
        else
            return false;
    }

    public boolean isFull() {
        if ((rear + 1) % circularQueue.length == front)
            return true;
        else
            return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
