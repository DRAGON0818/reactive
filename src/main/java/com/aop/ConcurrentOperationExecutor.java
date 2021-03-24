package com.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.core.Ordered;
import org.springframework.dao.PessimisticLockingFailureException;

/**
 * @author whoami
 */
public class ConcurrentOperationExecutor implements Ordered {

    private static final int DEFAULT_MAX_RETRIES = 2;

    private int maxRetries = DEFAULT_MAX_RETRIES;

    private int order = 1;

    public void setMaxRetries(int maxRetries) {
        this.maxRetries = maxRetries;
    }

    @Override
    public int getOrder() {
        return this.order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public Object doConcurrentOperation(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        int numAttempts = 0;
        PessimisticLockingFailureException lockingFailureException;
        do{
            numAttempts ++;
            System.out.println("Try times : "+ numAttempts);
            try {
                return proceedingJoinPoint.proceed();
            } catch (PessimisticLockingFailureException exception) {
                lockingFailureException = exception;
            }
        }while (numAttempts <= this.maxRetries);
        System.out.println("Try error:" + numAttempts);
        System.out.println("访问次数达到限制");
        throw lockingFailureException;
    }
}

