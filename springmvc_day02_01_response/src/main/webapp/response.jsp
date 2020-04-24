<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/24
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.min.js"></script>
    <script>
        $(function () {
            $("#btn").click(function () {
               // 发送ajax请求
                $.ajax({
                    url:"user/testJson",
                    contentType:"application/json;charset=UTF-8",
                    data:'{"username":"liuchen","password":"123", "age":24}',
                    dataType:"json",
                    type:"post",
                    success:function(data){
                        alert(data);
                        alert(data.username);
                    }
                });
            });
        });
    </script>
</head>
<body>

    <a href="user/testString">方法返回字符串</a><br/>

    <a href="user/testVoid">方法返回Void</a> <br/>

    <a href="user/testModelAndView">方法返回ModelAndView</a> <br/>

    <button id="btn">发送ajax的请求</button> <br/>
</body>
</html>
