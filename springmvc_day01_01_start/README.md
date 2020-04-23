# 入门案例

- 熟悉环境搭建
- 前后端参数绑定

1. 请求参数的绑定说明
    1. 绑定机制
        1. 表单提交的数据都是k=v格式的 username=haha&password=123
        2. SpringMVC的参数绑定过程是把表单提交的请求参数，作为控制器中方法的参数进行绑定的
        3. 要求：提交表单的name和参数的名称是相同的
    2. 支持的数据类型
        1. 基本数据类型和字符串类型
        2. 实体类型（JavaBean）
        3. 集合数据类型（List、map集合等）
    2. 基本数据类型和字符串类型
        1. 提交表单的name和参数的名称是相同的
        2. 区分大小写
    3. 实体类型（JavaBean）
        1. 提交表单的name和JavaBean中的属性名称需要一致
        2. 如果一个JavaBean类中包含其他的引用类型，那么表单的name属性需要编写成：对象.属性 例如：address.name
    4. 给集合属性数据封装
        1. JSP页面编写方式：list[0].属性
```java

<form action="param/saveAccount" method="post">
    姓名：<input type="text" name="username" /> <br/>
    密码：<input type="text" name="password" /> <br/>
    金额：<input type="text" name="money" /> <br/>

    list的uname：<input type="text" name="users[0].uname" /> <br/>
    list的uage：<input type="text" name="users[0].uage" /> <br/>

    map的uname：<input type="text" name="userMap['one'].uname" /> <br/>
    map的uage：<input type="text" name="userMap['one'].uage" /> <br/>
    <input type="submit" value="提交" />
</form>



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
```
   