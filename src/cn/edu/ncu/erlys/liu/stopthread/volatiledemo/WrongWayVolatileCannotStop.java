package cn.edu.ncu.erlys.liu.stopthread.volatiledemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// 当陷入阻塞的时候
// volatile无法停止线程
// 例如，当生产者的生产速度很快，消费者消费速度很慢,所以胡出现阻塞队列满了以后，生产者会阻塞，等待
// 消费者进一步消费
public class WrongWayVolatileCannotStop {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue storage = new ArrayBlockingQueue(10);
        Producer producer = new Producer(storage);
        Thread producerThread = new Thread(producer);
        producerThread.start();
        Thread.sleep(1000);

        Consumer consumer = new Consumer(storage);

        while(consumer.needMoreNums()) {
            System.out.println(consumer.storage.take() + "被消费了");
            Thread.sleep(100);
        }
        System.out.println("消费者不需要更多数据了");

        // 一旦消费者不需要更多数据，应该要让生产者也停下来
        producer.canceled = true;
        System.out.println(producer.canceled);
    }
}

class Producer implements Runnable {
    public volatile boolean canceled = false;
    BlockingQueue storage;

    public Producer(BlockingQueue storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        try {
            int num = 0;
            while (num <= 100000 && !canceled) {
                if (num % 100 == 0) {
                    storage.put(num);
                    System.out.println(num + "是100的倍数, 被放到仓库中");
                    Thread.sleep(1);
                }
                num++;
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println("生产者停止运行");
        }
    }
}

class Consumer {
    BlockingQueue storage;

    public Consumer(BlockingQueue storage) {
        this.storage = storage;
    }

    public boolean needMoreNums(){
        return !(Math.random() > 0.95);
    }
}