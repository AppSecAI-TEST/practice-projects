package com.huang.thread._2_;

/**
 * Created by huang on 2017/6/22.
 */
public class WaitTest {
    private String flag = "true";

    class NotifyThread extends Thread {
        public NotifyThread(String name) {
            super(name);
        }

        public void run() {
            try {
                sleep(3000);//推迟3秒钟通知
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            flag = "false";
            flag.notify();
        }
    }

    ;

    class WaitThread extends Thread {
        public WaitThread(String name) {
            super(name);
        }

        public void run() {

            while (flag != "false") {
                System.out.println(getName() + " begin waiting!");
                long waitTime = System.currentTimeMillis();
                try {
                    flag.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                waitTime = System.currentTimeMillis() - waitTime;
                System.out.println("wait time :" + waitTime);
            }
            System.out.println(getName() + " end waiting!");

        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main Thread Run!");
        WaitTest test = new WaitTest();
        NotifyThread notifyThread = test.new NotifyThread("notify01");
        WaitThread waitThread01 = test.new WaitThread("waiter01");
        WaitThread waitThread02 = test.new WaitThread("waiter02");
        WaitThread waitThread03 = test.new WaitThread("waiter03");
        notifyThread.start();
        waitThread01.start();
        waitThread02.start();
        waitThread03.start();
    }
}
