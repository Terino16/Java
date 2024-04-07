// A.

// Write a Java program that implements a multi-threaded program which has three threads. The first thread generates a random integer every 1 second. If the value is even, the second thread computes the square of the number and prints. If the value is odd the third thread will print the value of the cube of the number.





import java.util.Random;

class RandomNumberGenerator extends Thread {
    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            int num = random.nextInt(100); 
            System.out.println("Generated number: " + num);
            if (num % 2 == 0) {
                SquareThread squareThread = new SquareThread(num);
                squareThread.start();
            } else {
                CubeThread cubeThread = new CubeThread(num);
                cubeThread.start();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class SquareThread extends Thread {
    private int num;

    public SquareThread(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        System.out.println("Square of " + num + " is: " + (num * num));
    }
}
class CubeThread extends Thread {
    private int num;

    public CubeThread(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        System.out.println("Cube of " + num + " is: " + (num * num * num));
    }
}

 class RunnableExample implements Runnable { 
    public void run () {
    for (int i = 1; i <= 100; i++) 
    {
        System.out.println("hi");
    } 
}
}



public class Threads {
    public static void main(String[] args) {
       RunnableExample runable=new RunnableExample();
    }
}
