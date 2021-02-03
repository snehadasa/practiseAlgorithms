package LeetCode.Easy;

public class Counter {

    Counter() {
    }

    private static int cnt = 0;

    public int getCnt() {
        return cnt;
    }

    public static void incrementCounter() {
        cnt++;
    }


    public static void main(String[] args) {
        Counter counter1 = new Counter();
        Counter.incrementCounter();


        Counter counter2 = new Counter();


        System.out.println(counter1.getCnt());
        System.out.println(counter2.getCnt());

    }
}
