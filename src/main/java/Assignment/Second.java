package Assignment;

import java.util.ArrayList;
import java.util.List;

public class Second {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(89);
        list.add(67);
        list.add(73);

        Thread thread1 = new Thread(() -> {
            for (Integer i : list) {
                System.out.println("Thread 1: " + i);
                try {
                    Thread.sleep(100); // Simulate some work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            list.add(4); // Modifying the list while thread1 is iterating
            System.out.println("Thread 2: Added 4 to the list");
        });

        thread1.start();
        thread2.start();
    }
}
