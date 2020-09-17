package cn.gsxt.demo01;

public class Proxy {
    private Host host;

    public Proxy(){

    }

    public Proxy(Host host){
     this.host = host;
    }

    public void rent(){
        seeHouse();
        host.rent();
        fare();
    }

    public void seeHouse(){
        System.out.println("中介带看房子");
    }

    public void fare(){
        System.out.println("收中介费");
    }


}
