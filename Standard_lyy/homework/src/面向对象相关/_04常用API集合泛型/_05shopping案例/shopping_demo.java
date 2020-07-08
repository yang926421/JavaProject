//package 面向对象相关._04常用API集合泛型._05shopping案例;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class shopping_demo {
//    public static void main(String[] args) {
//        Goods g1 = new Goods("001", "少林核桃", 15.5, "斤");
//        Goods g2 = new Goods("002", "少林01", 14.5, "包");
//        Goods g3 = new Goods("003", "少林02", 245.5, "个");
//        Goods g4 = new Goods("004", "少林03", 159.5, "G");
//        List<Goods> list1 = new ArrayList<>();
//        list1.add(g1);
//        list1.add(g2);
//        list1.add(g3);
//        list1.add(g4);
//        System.out.println("========欢迎使用超市购物系统==========");
//        while (true) {
//            System.out.println("请输入你要进行的操作");
//            Scanner sc = new Scanner(System.in);
//            String s1 = sc.nextLine();
//            if (s1.equals("1")) {
//                buyGoods();
//                break;
//            } else if (s1.equals("2")) {
//                printStake();
//                break;
//            } else if (s1.equals("3")) {
//                System.out.println("感谢您使用超市购物系统,欢迎下次光临,拜拜");
//                // 退出购物系统
//                System.exit(0);
//                break;
//            }
//            else{
//                System.out.println("你输入的数字有误,请重新输入");
//                break;
//            }
//
//
//        }
//    }
//    public static void printStake(){
//        System.out.println("欢迎光临");
//        System.out.println("名称        售价        数量       金额 ");
//    }
//    public static void buyGoods(){
//        System.out.println("商品列表");
//        System.out.println("商品id         名称        单价        计价单位        ");
//        for (Goods goods : list1) {
//            System.out.println(goods.getId() + "          " + goods.getName() + "        " + goods.getPrice() + "    " +
//                    "     " + goods.getSimple_price());
//        }
//        String s2 = sc.nextLine();
//        if (s2.equals("end")){
//            System.out.println("您输入的商品不存在,请重新输入");
//        }
//        else{
//            System.out.println("购买结束");
//        }
//    }
//    }
//}
