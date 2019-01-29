package thread;

/**
 * Created by zafar.imam on 03-10-2017.
 */

public class DeadlockDemo {

    public String str1 = "Java";
    public String str2 = "Android";

    public static void main(String arg[]){
        DeadlockDemo demo = new DeadlockDemo();
        demo.thread1.start();
        demo.thread2.start();

    }

    Thread thread1 = new Thread("Thread 1"){
        @Override
        public void run() {
            while (true){
                synchronized (str1){
                    synchronized (str2){
                        System.out.println(str1+" : "+str2);
                    }
                }
            }
        }
    };

    Thread thread2  = new Thread("Thread 2"){
        @Override
        public void run() {
          while (true){
              synchronized (str2){
                  synchronized (str1){
                      System.out.println(str2+" : "+str1);
                  }
              }
          }
        }
    };
}
