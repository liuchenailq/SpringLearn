# 基于 xml 的ioc 实现数据表的crud

- 熟悉利用xml配置bean
- 学会在spring中利用junit进行单元测试

## junit测试的原理
```java
1、应用程序的入口
	main方法
2、junit单元测试中，没有main方法也能执行
	junit集成了一个main方法
	该方法就会判断当前测试类中哪些方法有 @Test注解
	junit就让有Test注解的方法执行
3、junit不会管我们是否采用spring框架
	在执行测试方法时，junit根本不知道我们是不是使用了spring框架
	所以也就不会为我们读取配置文件/配置类创建spring核心容器
4、由以上三点可知
	当测试方法执行时，没有Ioc容器，就算写了Autowired注解，也无法实现注入
```

## spring 整合 junit
```java
spring整合Junit单元测试（替换Junit的main方法，可以加载容器）

    1. 导入spring整合junit的jar (spring_test)
    2. 使用Junit提供的一个注解（@RunWith）把原来的main方法替换为spring提供的
    3. 告知spring信息，创建容器的方法（xml或者配置类）
        @ContextConfiguration
            locations:指定xml文件的位置
            classes:指定配置类
            
如：
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
```