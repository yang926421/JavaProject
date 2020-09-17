package cn.gsxt.test;

public class Single {

//    private static final Single single = new Single();
//
//    private  Single(){
//
//    }
//
//    public Single getSingle() {
//        return single;
//    }

    private static Single single;

    private Single(){

    }

    public Single getSingle(){
        if (single == null){
            return new Single();
        }
        else{
            return single;
        }
    }
}
