# 利用 spring aop 实现数据库事务

 * 经验之谈：
 *  不要用 前置、后置、异常、最终通知等注解形式，因为代码执行的顺序不是按我们想象的一样，这对于事务有致命的错误，因为最终通知（释放事务）比后置通知（关闭事务）执行早
 *  尽量使用环绕通知，自己完全控制增强逻辑