/*
 * Written by Doug Lea with assistance from members of JCP JSR-166
 * Expert Group and released to the public domain, as explained at
 * http://creativecommons.org/publicdomain/zero/1.0/
 */

package java.util.concurrent;

/**
 * An object that creates new threads on demand.  Using thread factories
 * removes hardwiring of calls to {@link Thread#Thread(Runnable) new Thread},
 * enabling applications to use special thread subclasses, priorities, etc.
 *
 * 根据需要创建新线程的对象。使用线程工厂就无需再手工编写对 new Thread 的调用了，从而允许应用程序使用特殊的线程
 * 子类、属性等等。
 *
 * <p>
 * The simplest implementation of this interface is just:
 * 此接口最简单的实现就是：
 *
 *  <pre> {@code
 * class SimpleThreadFactory implements ThreadFactory {
 *   public Thread newThread(Runnable r) {
 *     return new Thread(r);
 *   }
 * }}</pre>
 *
 * The {@link Executors#defaultThreadFactory} method provides a more
 * useful simple implementation, that sets the created thread context
 * to known values before returning it.
 * Executors.defaultThreadFactory() 方法提供了更有用的简单实现，即在返回线程前将已创建线程的上下文设置为已知的值。
 *
 * @since 1.5
 * @author Doug Lea
 */
public interface ThreadFactory {

    /**
     * Constructs a new {@code Thread}.  Implementations may also initialize
     * priority, name, daemon status, {@code ThreadGroup}, etc.
     * 构造一个新 Thread。实现也可能初始化属性、名称、守护程序状态、ThreadGroup 等等。
     *
     * @param r a runnable to be executed by new thread instance
     *          由新线程实例所执行的可运行线程
     *
     * @return constructed thread, or {@code null} if the request to
     *         create a thread is rejected
     *         构造的线程，如果请求创建线程被拒绝，则返回 null
     */
    Thread newThread(Runnable r);
}
