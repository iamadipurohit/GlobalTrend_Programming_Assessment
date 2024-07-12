package Assignment.Third;


import org.springframework.stereotype.Component;


@Component
public class SampleService {

            @LogExecutionTime
            public void someMethod() {
                try {
                    // Simulate some work with a sleep
                    System.out.println("Starting work...");
                    Thread.sleep(2000);  // Sleep for 2 seconds
                    System.out.println("Work completed.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
}

