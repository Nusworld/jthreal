package cn.edu.ncu.erlys.liu.jmm;

public class FieldVisibility {
    volatile int a = 1;
    volatile int b = 2;
    int abc = 1;
    int abcd = 1;
    private void change() {
        abc = 7;
        abcd = 70;
        a = 3;
        b = a;
    }
    public static void main(String[] args) {
        while (true) {
            FieldVisibility test = new FieldVisibility();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    test.change();
                }
            }).start();


            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    test.print();
                }
            }).start();
        }


    }

    private void print() {
        if (b == 0) {
            System.out.println("abc = " + abc + " a = " + a + " abcd = " + abcd);
        }

    }



}
