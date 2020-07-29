package cn.gsxt.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

//敏感词汇过滤器
@WebFilter("/*")
public class SensitiveWordsFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //创建代理对象 增强方法
        //动态代理只能为接口或者接口的实现类对象做代理,
         ServletRequest proxy_req = (ServletRequest) Proxy.newProxyInstance(req.getClass().getClassLoader(), req.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //增强getParameter()方法
                if(method.getName().equals("getParameter")){
                    //增强返回值
                    String values = (String) method.invoke(req, args);  //===>req.getParameter()
                    if (values != null){
                        for (String s : list) {
                            if(values.contains(s)){
                                values =  values.replaceAll(s,"***");
                            }
                        }
                    }
                    return values;
                }
                else{
                    return method.invoke(req, args);
                }
            }
        });
         //将增强过后的request对象传入servlet方法中
        chain.doFilter(proxy_req, resp);
    }

    private List<String> list = new ArrayList<>();  //敏感词汇的list集合
    public void init(FilterConfig config) throws ServletException {
        //只加载一次IO流将文件读取到一个list中
        //获取文件真实路径
        try{
            ServletContext servletContext = config.getServletContext();
            String realPath = servletContext.getRealPath("/WEB-INF/classes/敏感词汇.txt");
            //读取文件
            BufferedReader br = new BufferedReader(new FileReader(realPath));
            String line = null;
            while((line = br.readLine())!=null){
                list.add(line);
            }
            br.close();
            System.out.println(list);
        }
        catch (Exception e){
            e.printStackTrace();
        }




        //将文件数据添加到list

    }

}
