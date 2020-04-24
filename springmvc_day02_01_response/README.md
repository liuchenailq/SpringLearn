## 后端响应前端

```java
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
    
 // jsp 取值 
 ${user.username}
 ${user.password}
 ${user.age}
```

## ResponseBody注解响应 json 数据

```java
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
```