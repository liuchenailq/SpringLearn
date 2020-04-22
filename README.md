# SpringLearn
Spring 学习场

## ioc
IOC:控制反转 由spring根据配置文件或者注解来创建对象，用户需要用对象的时候从spring容器中取
- [spring_ioc](https://github.com/liuchenailq/SpringLearn/tree/master/spring_ioc)
- [day02_eesy_02account_xmlioc](https://github.com/liuchenailq/SpringLearn/tree/master/day02_eesy_02account_xmlioc)
- [day02_eesy_03account_annoioc](https://github.com/liuchenailq/SpringLearn/tree/master/day02_eesy_03account_annoioc)

## aop
AOP：面向切面编程 由spring自动通过动态代理技术对切入点进行方法增强
- [利用动态代理解决重复代码](https://github.com/liuchenailq/SpringLearn/tree/master/day03_eesy_01account)
- [基于xml的aop](https://github.com/liuchenailq/SpringLearn/tree/master/day03_eesy_03springAOP)
- [基于注解的aop](https://github.com/liuchenailq/SpringLearn/tree/master/day03_eesy_05annotationAOP)
- [利用 spring aop 实现数据库事务 事务管理器是自己写的](https://github.com/liuchenailq/SpringLearn/tree/master/spring_curd)

## spring 事务控制
spring提供写好的事务管理器（事务的开启、提交、回滚、释放） 用户通过aop配置到哪些地方（业务层的方法）需要事务
- [熟悉 JdbcTemplate 操作](https://github.com/liuchenailq/SpringLearn/tree/master/day04_eesy_01jdbctemplate)
- [基于 xml 的声明式事务控制](https://github.com/liuchenailq/SpringLearn/tree/master/day04_eesy_05tx_xml)
- [基于 注解的spring事务控制](https://github.com/liuchenailq/SpringLearn/tree/master/day04_eesy_06tx_anno)