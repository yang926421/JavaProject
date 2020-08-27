package com.etc.Ayy_collection.list集合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class two_point_demo {

    public static void main(String[] args) {


        List<Integer> resultList = new ArrayList<>();
        resultList.add(1);
        resultList.add(4);
        resultList.add(6);
        resultList.add(44);
        resultList.add(45);
        resultList.add(76);
        resultList.add(79);
        //二分查找
        Scanner sc = new Scanner(System.in);
        Integer num = sc.nextInt();
        int start = 0;
        int end = resultList.size() - 1;
//        find(resultList, num);
        int index = find(resultList, num, start, end);
        if (index == (-1)) {
            System.out.println("找不到啊");
        } else {
            System.out.println(index + "是这个位置上的");
        }

    }

    //
    public static int find(List list1, int number, int start, int end) {
        int middle = (start + end) / 2;
        int num = (int) list1.get(middle);
        if (number > (int) list1.get(end)) {
            return -1;
        }
        if (number < (int) list1.get(start)) {
            return -1;
        }
        if (number < num) {
            end = middle - 1;
            find(list1, number, start, end);
        }
        if (number > num) {
            start = middle + 1;
            find(list1, number, start, end);
        } else {
            return middle;
        }
        return -1;
    }
//        int start = 0;
//        int end = list1.length -1;
//        while (start <= end){
//            int middle = (start + end) /2;
//            if (number < list1[middle]){
//                end = middle -1;
//            }
//            if (number > list1[middle]){
//                start = middle + 1;
//            }
//            else{
//                System.out.println("找到了" + middle);
//                return middle;
//            }
//        }
//        //如果上面语句执行完也没有找到,说明没有这个元素
//        System.out.println("找不到,没有这个元素");
//        return -1;
//    }
}
