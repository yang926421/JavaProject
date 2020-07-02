package com.lyy._06递归;
/**

 递归的终点和公式转化
 已知f(X) = f(X+1) + 2
    f(1) = 1
 求f(10);
 因为我们只能根据第一天去求第二天,所以等式右边的值必须是已知的例如 f(2) = f(2-1)+2
 不能根据f(1) = f(2)+2
 f(x-1) = f(x-1+1)+2
f(x) = f(x-1)-1

 */
public class recursion_demo3 {

    public static void main(String[] args) {
        System.out.println(fun(10));


    }
    public static int fun(int x){
        if(x == 1){
            return 1;
        }
        else{
            return fun(x-1) -2;
        }
    }
}
