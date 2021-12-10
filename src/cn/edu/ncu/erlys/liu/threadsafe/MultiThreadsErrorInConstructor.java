package cn.edu.ncu.erlys.liu.threadsafe;

import java.util.HashMap;
import java.util.Map;

public class MultiThreadsErrorInConstructor {
    private Map<String, String> states;

    public MultiThreadsErrorInConstructor() {
        states = new HashMap<>();
        states.put("1", "周一");
        states.put("2", "周二");
        states.put("3", "周三");
        states.put("4", "周四");
    }

    public Map<String, String> getStates() {
        return states;
    }

    public Map<String, String> getStatesImproved() {
        return new HashMap<>(states);
    }

    public static void main(String[] args) {
        MultiThreadsErrorInConstructor multiThreadsErrorPublishE = new MultiThreadsErrorInConstructor();
        Map<String, String> states = multiThreadsErrorPublishE.getStates();
//        System.out.println(states.get("1"));
//        states.remove("1");
//        System.out.println(states.get("1"));
        System.out.println(multiThreadsErrorPublishE.getStatesImproved().get("1"));
        multiThreadsErrorPublishE.getStatesImproved().remove("1");
        System.out.println(multiThreadsErrorPublishE.getStatesImproved().get("1"));
    }

}
