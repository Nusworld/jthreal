package cn.edu.ncu.erlys.liu.threadsafe;

import java.util.HashMap;
import java.util.Map;

public class MultiThreadErrorInConstructor {
    private Map<String, String> states;

    public MultiThreadErrorInConstructor() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                states = new HashMap<>();
                states.put("1", "周一");
                states.put("2", "周二");
                states.put("3", "周三");
                states.put("4", "周四");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public Map<String, String> getStates() {
        return states;
    }

    public static void main(String[] args) {
        MultiThreadsErrorInConstructor multiThreadsErrorPublishE = new MultiThreadsErrorInConstructor();
        System.out.println(multiThreadsErrorPublishE.getStates().get("1"));
    }
}
