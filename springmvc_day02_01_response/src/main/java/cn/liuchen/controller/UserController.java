package cn.liuchen.controller;

import cn.liuchen.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * Controller方法返回字符串可以指定逻辑视图的名称，根据视图解析器为物理视图的地址。
     *
     * Model对象可以存储数据用于传给前端
     * @return
     */
    @RequestMapping("/testString")
    public String testString(Model model){
        System.out.println("testString执行了...");

        User user = new User();
        user.setUsername("刘臣");
        user.setPassword("123");
        user.setAge(24);
        model.addAttribute("user", user);
        return "success";
    }

    /**
     * 页面报错：  /springmvc_day02_01_response/WEB-INF/pages/user/testVoid.jsp
     *
     * 有默认的页面路径  不建议使用！！！
     *
     * 可以使用请求转发、重定向、直接利用response输出响应数据三种方法返回
     * @param model
     */
    @RequestMapping("/testVoid")
    public void testVoid(Model model){
        System.out.println("testVoid执行了...");
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        ModelAndView modelAndView = new ModelAndView();
        // 用调用视图解析器解析出真实jsp路径
        System.out.println("testModelAndView执行了...");
        modelAndView.setViewName("success");
        User user = new User();
        user.setUsername("刘臣");
        user.setPassword("123");
        user.setAge(24);
        modelAndView.addObject("user", user);
        return modelAndView;
    }


    /**
     * @RequestBody: 拿到请求体的内容, 如果参数为Java Bean对象，springmvc可以自动进行反序列化为对象
     * @ResponseBody： 将对象转为json数据回传前端
     *
     * Http请求报文由三部分组成：请求行、请求头、请求体（json数据，如表单提交的json参数，GET方法没有请求体）
     * @param body
     */
    @RequestMapping("/testJson")
    @ResponseBody
    public User testJson(@RequestBody User user){
        System.out.println("testJson执行了");
        System.out.println(user);

        user.setUsername("lq");
        return user;
    }
}
