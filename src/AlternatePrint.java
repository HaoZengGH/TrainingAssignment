// Question: create 2 threads, print 1a2b3c...26z
import java.util.concurrent.CountDownLatch;
public class AlternatePrint {
    private static int numOne=1;
    private static char charTwo='a';
    public static void main(String[] args){
        CountDownLatch latch=new CountDownLatch(1);
        Object lock=new Object();

        Thread threadOne=new Thread(()-> {
            synchronized (lock){
                while(numOne<=26){
                    System.out.print(numOne);
                    numOne+=1;
                    try{
                        // wake threadTwo
                        latch.countDown();
                        lock.notify();
                        // block threadOne
                        lock.wait();
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }
        });

        Thread threadTwo=new Thread(()->{
            synchronized (lock){
                while(charTwo<='z'){
                    try{
                        System.out.print(charTwo);
                        charTwo++;
                        lock.notify();
                        lock.wait();
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }

                }
            }
        });

        threadOne.start();
        threadTwo.start();
    }
}