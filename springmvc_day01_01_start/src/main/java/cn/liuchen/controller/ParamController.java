package cn.liuchen.controller;

import cn.liuchen.domain.Account;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/param")
public class ParamController {

    @RequestMapping("/testParam")
    public String testParam(String username, String password){
        System.out.println("请求参数绑定执行了...");
        System.out.println("username: " + username);
        System.out.println("password: " + password);
        return "success";
    }

    /**
     * 把数据封装到 Java Bean
     * @param account
     * @return
     */
    @RequestMapping("/saveAccount")
    public String saveAccount(Account account){
        System.out.println("请求参数绑定执行了...");
        System.out.println(account);
        return "success";
    }
}
