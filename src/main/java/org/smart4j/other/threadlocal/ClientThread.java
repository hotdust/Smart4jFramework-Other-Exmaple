package org.smart4j.other.threadlocal;

/**
 * Created by shijiapeng on 16/12/14.
 */
public class ClientThread extends Thread{

    private Sequence sequence;

    public ClientThread(Sequence sequence) {
        this.sequence = sequence;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + " => " + sequence.getNumber());
        }
    }
}
