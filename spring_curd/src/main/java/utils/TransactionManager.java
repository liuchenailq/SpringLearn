package utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * 和事务管理相关的工具类，它包含了，开启事务，提交事务，回滚事务和释放连接
 *
 * 经验之谈：
 *  不要用 前置、后置、异常、最终通知等注解形式，因为代码执行的顺序不是按我们想象的一样，这对于事务有致命的错误，因为最终通知（释放事务）比后置通知（关闭事务）执行早
 *  尽量使用环绕通知，自己完全控制增强逻辑
 */
@Component("transactionManager")
@Aspect
public class TransactionManager {
    @Autowired
    @Qualifier("connectionUtils")
    private ConnectionUtils connectionUtils;

    @Pointcut(value = "execution(* service.AccountServiceImpl.*(..))")
    private void pt1(){ }

    /**
     * 开启事务
     */
//    @Before("pt1()")
    public  void beginTransaction(){
        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
            System.out.println("开启事务: " + connectionUtils.getThreadConnection().toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 提交事务
     */
//    @AfterReturning("pt1()")
    public  void commit(){
        try {
            connectionUtils.getThreadConnection().commit();
            System.out.println("提交事务: " + connectionUtils.getThreadConnection().toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务
     */
//    @AfterThrowing("pt1()")
    public void rollback(){
        try {
            connectionUtils.getThreadConnection().rollback();
            System.out.println("回滚事务");
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    /**
     * 释放连接
     */
//    @After("pt1()")
    public void release(){
        try {
            connectionUtils.getThreadConnection().close();//还回连接池中
            connectionUtils.removeConnection();
            System.out.println("释放事务");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Around("pt1()")
    public Object aroundPringLog(ProceedingJoinPoint pjp){
        Object rtValue = null;
        try{
            Object[] args = pjp.getArgs();//得到方法执行所需的参数

            beginTransaction();

            rtValue = pjp.proceed(args);//明确调用业务层方法（切入点方法）

            commit();

            return rtValue;
        }catch (Throwable t){
            rollback();
            throw new RuntimeException(t);
        }finally {
            release();
        }
    }
}
