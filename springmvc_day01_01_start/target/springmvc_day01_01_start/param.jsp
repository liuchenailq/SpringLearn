<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/23
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>请求参数绑定示例</title>
</head>
<body>
    <%--
    <a href="param/testParam?username=liuchen&password=123">请求参数绑定</a>
    --%>

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



</body>
</html>
