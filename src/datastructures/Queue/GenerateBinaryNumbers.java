package datastructures.Queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class GenerateBinaryNumbers {
    public void generate(int n) {
        Queue<String> queue = new ArrayDeque<>();
        queue.add("1");

        int index = 1;
        while (index <= n) {
            queue.add(queue.peek() + '0');
            queue.add(queue.peek() + '1');
            System.out.println(queue.poll() + ' ');
            index++;
        }
    }

    public static void main(String[] args) {
        int n = 16;
        GenerateBinaryNumbers res = new GenerateBinaryNumbers();
        res.generate(n);
    }
}
