package com.lyy._10装饰设计模式;

//装饰模式。提高原始功能
public class BufferInput_demo extends InputStream_demo {
    private InputStream_demo is;

    public BufferInput_demo(InputStream_demo is) {
        this.is = is;
    }

    @Override
    public void read() {
        System.out.println("开启高效缓冲");
        //装饰类将原始类对象包装进来 先加强功能
        is.read();
    }

    @Override
    public void close() {
        is.close();
    }
}
