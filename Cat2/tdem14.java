import java.util.Arrays;

public class tdem14 {
    private static final int NUM_STUDENTS = 5;
    private static final int[] marks = new int[NUM_STUDENTS];
    private static int currentIndex = 0;

    public static void main(String[] args) {
        Thread[] threads = new Thread[NUM_STUDENTS];

        for (int i = 0; i < NUM_STUDENTS; i++) {
            threads[i] = new Thread(new MarkAdder(i));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("All students' marks added:");
        System.out.println(Arrays.toString(marks));
    }

    static class MarkAdder implements Runnable {
        private final int studentId;

        public MarkAdder(int studentId) {
            this.studentId = studentId;
        }

        @Override
        public void run() {
            synchronized (marks) {
                while (currentIndex != studentId) {
                    try {
                        marks.wait(); 
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                marks[currentIndex] = (studentId + 1) * 10;

                System.out.println("Mark added for student " + (studentId + 1) + ": " + marks[currentIndex]);

                currentIndex++; 
                marks.notifyAll(); 
            }
        }
    }
}