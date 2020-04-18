package ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.Service;

public class Client {

    public static void main(String[] args){
        // 自己创建对象并使用
        Service service = new Service();
        service.service();


        //  控制反转：交给Spring ioc 容器来创建对象，我们只需配置对象创建的细节
        // 第一步：获取ioc容器  容器自动读取配置文件并创建对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        // 第二步：根据id获取对象
        Service service1 = (Service) applicationContext.getBean("service");
        service1.service();
    }
}
