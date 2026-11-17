import java.util.*;

class MedianFinder {

    private PriorityQueue<Integer> left;
    private PriorityQueue<Integer> right;  

    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }

    public void addNum(int num) {

        left.offer(num);

        right.offer(left.poll());

        if (right.size() > left.size() + 1) {
            left.offer(right.poll());
        }
    }

    public double findMedian() {

        if (right.size() > left.size()) {
            return right.peek();
        }

        return ((double) left.peek() + right.peek()) / 2.0;
    }
}