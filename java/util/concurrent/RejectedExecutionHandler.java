/*
 * Written by Doug Lea with assistance from members of JCP JSR-166
 * Expert Group and released to the public domain, as explained at
 * http://creativecommons.org/publicdomain/zero/1.0/
 */

package java.util.concurrent;

/**
 * A handler for tasks that cannot be executed by a {@link ThreadPoolExecutor}.
 * 无法由 ThreadPoolExecutor 执行的任务的处理程序。
 *
 * @since 1.5
 * @author Doug Lea
 */
public interface RejectedExecutionHandler {

    /**
     * Method that may be invoked by a {@link ThreadPoolExecutor} when
     * {@link ThreadPoolExecutor#execute execute} cannot accept a
     * task.  This may occur when no more threads or queue slots are
     * available because their bounds would be exceeded, or upon
     * shutdown of the Executor.
     *
     * 当 execute 不能接受某个任务时，可以由 ThreadPoolExecutor 调用的方法。因为超出其界限而没有更多可用的线
     * 程或队列槽时，或者关闭 Executor 时就可能发生这种情况。
     *
     * <p>In the absence of other alternatives, the method may throw
     * an unchecked {@link RejectedExecutionException}, which will be
     * propagated to the caller of {@code execute}.
     *
     * 在没有其他替代方法的情况下，该方法可能抛出未经检查的 RejectedExecutionException，而该异常将传播到
     * execute 的调用者。
     *
     * @param r the runnable task requested to be executed
     *          所请求执行的可运行任务。
     *
     * @param executor the executor attempting to execute this task
     *                 试图执行此任务的执行程序。
     *
     * @throws RejectedExecutionException if there is no remedy
     *         RejectedExecutionException - 如果没有补救方法。
     */
    void rejectedExecution(Runnable r, ThreadPoolExecutor executor);
}
