package leetcode.solution;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Solution1114 {
    class Foo {
        private ReentrantLock lock = new ReentrantLock();
        private Condition con12 = lock.newCondition();
        private Condition con23 = lock.newCondition();
        private volatile int state = 1;
        public Foo() {
        }
        public void first(Runnable printFirst) throws InterruptedException {
            lock.lock();
            try {
                printFirst.run();
                state++;
                con12.signal();
            } finally {
                lock.unlock();
            }
        }
        public void second(Runnable printSecond) throws InterruptedException {
            lock.lock();
            try {
                if (state != 2) {
                    con12.await();
                }
                printSecond.run();
                state++;
                con23.signal();
            } finally {
                lock.unlock();
            }
        }
        public void third(Runnable printThird) throws InterruptedException {
            lock.lock();
            try {
                if (state != 3) {
                    con23.await();
                }
                printThird.run();
            } finally {
                lock.unlock();
            }
        }
    }
}
