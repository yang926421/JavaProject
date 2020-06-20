package com.java.genericity;

import java.util.ArrayList;

//通配符
public class generic_通配符 {
        public static void main(String[] args) {
            ArrayList<BMW> bmws = new ArrayList<>();
            bmws.add(new BMW());
            bmws.add(new BMW());
            bmws.add(new BMW());
            run(bmws);

            ArrayList<BENZ> benzs = new ArrayList<BENZ>();
            benzs.add(new BENZ());
            benzs.add(new BENZ());
            benzs.add(new BENZ());
            run(benzs);

        }
        //定义一个方法 可以让很多车都进来
        public static void run(ArrayList<? extends Car> cars){
            System.out.println("都可以,狗不可以");
        }

}

class Car{

}
class BMW extends Car{

}
class BENZ extends Car{

}

