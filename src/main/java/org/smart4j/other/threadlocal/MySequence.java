package org.smart4j.other.threadlocal;

/**
 * Created by shijiapeng on 16/12/14.
 */
public class MySequence implements Sequence {

    MyThreadLocal<Integer> numberContainer = new MyThreadLocal<Integer>() {
        @Override
        public Integer initialValue() {
            return 0;
        }
    };

    @Override
    public int getNumber() {
        numberContainer.set(numberContainer.get() + 1);
        return numberContainer.get();
    }

    public static void main(String[] args) {

        Sequence sequence = new MySequence();


        ClientThread clientThread1 = new ClientThread(sequence);
        ClientThread clientThread2 = new ClientThread(sequence);
        ClientThread clientThread3 = new ClientThread(sequence);

        clientThread1.start();
        clientThread2.start();
        clientThread3.start();
    }
}
