package org.smart4j.other.threadlocal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 模拟实现ThreadLocal
 * @Author shijiapeng
 * @date 2016/12/14 下午11:16
 * Created by shijiapeng on 16/12/14.
 */
public class MyThreadLocal<T> {


    Map<Thread, T> container = Collections.synchronizedMap(new HashMap<>());

    public void set(T value) {
        container.put(Thread.currentThread(), value);
    }


    public T get() {
        Thread thread = Thread.currentThread();
        T value = container.get(thread);
        if (value == null && !container.containsKey(thread)) {
            value = initialValue();
            container.put(thread, value);
        }

        return value;
    }

    public T initialValue() {
        return null;
    }
}
