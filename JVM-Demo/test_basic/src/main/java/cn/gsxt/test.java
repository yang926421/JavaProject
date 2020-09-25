package cn.gsxt;

import java.util.Arrays;
import java.util.List;

public class test {
    public static void main(String[] args) {
        int[] a = {8, 9, 1, 10, 4, 6, 7};
//        for(int i = 0; i< a.length; i++){
//            System.out.println(a[i]);
//        }
//
//        int[][] nums = {{1, 2},{3, 4},{5, 6}};
//        for (int i = 0; i < nums.length; i++) {
//            System.out.println(nums[i][0]);
//            System.out.println(nums[i][1]);
//        }
//        String s = Arrays.toString(a);
//        Arrays.sort(a);
//        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(mao(a)));
        System.out.println(Arrays.toString(sortChoose(a)));
        fastChoose(a);
    }

    //冒泡排序
    public static int[] mao(int[] a){
        for (int i = 0; i < a.length -1; i++) {
            for (int j = 0; j< a.length-i-1;j++){
                if (a[j]>a[j+1]){
                    int num ;
                    num = a[j];
                    a[j] = a[j+1];
                    a[j+1] = num;
                }
            }
        }
        return a;
    }


    //选择排序
    public static int[] sortChoose(int[] a){
        for (int i =0; i< a.length-1;i++){
            for (int j = i+1; j< a.length;j++){
                if (a[i]<a[j]){
                    int num;
                    num = a[i];
                    a[i] = a[j];
                    a[j] = num;
                }
            }
        }
        return a;
    }

    //快排
    public static void fastChoose(int[] a){
       int num = a[a.length%2];
        int[] aLeft = null;
        int[] aRight = null;
        for (int i = 0; i <a.length ; i++) {
            int iLeft =0;
            int iRight = 0;
            if (a[i]<num){
                aLeft[iLeft++] = a[i];
            }
            else{
                aRight[iRight++] = a[i];
            }
        }
        System.out.println(Arrays.toString(aLeft));
        System.out.println(Arrays.toString(aRight));
    }

}
