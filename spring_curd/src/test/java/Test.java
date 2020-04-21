import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.IAccountService;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        IAccountService service = (IAccountService) ac.getBean("accountService");

        System.out.println(service.findAll().toString());
        service.transfer("aaa", "bbb", 100);
        System.out.println(service.findAll().toString());

    }
}
