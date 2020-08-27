<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%

    /**
     判断是否是第一次访问，如果是第一次访问
     不是第一次访问则  展示之前访问的时间
     */
    //获取所有的cookie
    Cookie[] cookies = request.getCookies();
    boolean flag = false;//没有cookie为lastTime
    //2.遍历cookie数组
    if (cookies != null && cookies.length > 0) {
        //遍历cookies数组，有没有对应的cookie的值
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            if (name.equals("lastTime")) {
                flag = true;
                //获取上次登陆cookie对应的value
                String last_time = cookie.getValue();
                //先解码
                System.out.println("解码前");
                String value = URLDecoder.decode(last_time, "utf-8");
                //解码后在页面展示
                response.getWriter().write("<h1>欢迎回来，您上次的访问时间</h1>" + value);
                //将这次登陆的时间设置为cookied额值
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = new Date();
                String str_date = sdf.format(date);
                System.out.println("编码前" + str_date);
                //url进行编码
                str_date = URLEncoder.encode(str_date, "utf-8");
                System.out.println("编码后" + str_date);
                //URL解码：
                value = URLDecoder.decode(value, "utf-8");
                System.out.println("解码后：" + value);
                cookie.setValue(str_date);
                response.addCookie(cookie);


            }
        }
    }

    if (cookies == null || cookies.length == 0 || flag == false) {
        //第一次访问，没有cookie
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String str_date = sdf.format(date);
        //设置cookie
        System.out.println("编码前：" + str_date);
        //URL编码
        str_date = URLEncoder.encode(str_date, "utf-8");
        System.out.println("编码后：" + str_date);

        Cookie cookie = new Cookie("lastTime", str_date);
        //设置cookie的存活时间
        cookie.setMaxAge(60 * 60 * 24 * 30);//一个月
        response.addCookie(cookie);

        response.getWriter().write("<h1>您好，欢迎您首次访问</h1>");

    }


%>
</body>
</html>
