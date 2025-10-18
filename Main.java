import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

class ThreadSafeStack<E> {
    private final Deque<E> stack = new ArrayDeque<>();
    private final ReentrantLock lock = new ReentrantLock();

    public void push(E item) {
        lock.lock();
        try { stack.push(item); } 
        finally { lock.unlock(); }
    }

    public E pop() {
        lock.lock();
        try { return stack.isEmpty() ? null : stack.pop(); } 
        finally { lock.unlock(); }
    }

    public boolean isEmpty() {
        lock.lock();
        try { return stack.isEmpty(); } 
        finally { lock.unlock(); }
    }
}

public class Main {
    public static void main(String[] args) {
        ThreadSafeStack<Integer> s = new ThreadSafeStack<>();
        s.push(10);
        s.push(20);
        System.out.println("Popped: " + s.pop());
        System.out.println("Empty: " + s.isEmpty());
    }
}