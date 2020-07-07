package com.lyy._10装饰设计模式;

public class FileInputStream_demo extends InputStream_demo {
    @Override
    public void read() {
        System.out.println("读取数据");
    }

    @Override
    public void close() {
        System.out.println("关闭文件");
    }
}
