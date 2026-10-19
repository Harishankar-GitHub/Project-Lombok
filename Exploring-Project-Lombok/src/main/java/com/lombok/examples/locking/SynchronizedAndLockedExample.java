package com.lombok.examples.locking;

import lombok.Locked;
import lombok.Synchronized;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedAndLockedExample {
    private int synchronizedCounter;
    private int lockedCounter;

    private final Lock counterLock = new ReentrantLock();
    // @Synchronized and @Locked both generate a field named $lock by default, so they can't be mixed in one class
    // without naming a different lock field. Here, @Locked("counterLock") uses the field above.

    @Synchronized
    // Like the synchronized keyword, but locks on a private, generated $lock field instead of "this".
    // So, code outside this class can't take the same lock and cause a deadlock.
    public void incrementSynchronizedCounter() {
        synchronizedCounter++;
    }

    @Locked("counterLock")
    // Same idea, but uses a private java.util.concurrent.locks.ReentrantLock instead of a monitor.
    // Preferred on Java 21 with virtual threads, which a synchronized block can pin to their carrier thread.
    public void incrementLockedCounter() {
        lockedCounter++;
    }

    @Synchronized
    public int getSynchronizedCounter() {
        return synchronizedCounter;
    }

    @Locked("counterLock")
    public int getLockedCounter() {
        return lockedCounter;
    }
}
