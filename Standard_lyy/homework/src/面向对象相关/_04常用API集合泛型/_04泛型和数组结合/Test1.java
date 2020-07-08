package 面向对象相关._04常用API集合泛型._04泛型和数组结合;

public class Test1 {
    public static void main(String[] args) {
        String[] s1 = {"A", "B", "C"};
        swap(s1, 0, 2);
        for (String s : s1) {
            System.out.println(s);
        }

        Integer[] i1 = {1, 6, 8, 4, 9};
        swap(i1, 0, 4);
        for (Integer integer : i1) {
            System.out.println(integer);
        }
    }

    public static <T> void swap(T[] arr, int i, int j){
        // 2.使用第三方变量的方式交换数组中的元素
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
