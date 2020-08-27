import java.util.Arrays;

public class java_sort {
    public static int[] compare(int[] arr) {
        int num = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, num);
//        int[] right = Arrays.copyOfRange(arr,num,-1);
        for (int i = 0; i < left.length; i++) {
            System.out.println(left[i]);
        }
        return left;
    }


    public static void main(String[] args) {
        //java的冒泡排序
        int[] arr1 = {1, 6, 3, 5, 7, 2};
//        for(int i = 1; i<arr1.length;i++){
//            for(int j=0;j<i;j++){
//                if(arr1[i] < arr1[j]){
//                    int num;
//                    num = arr1[i];
//                    arr1[i] = arr1[j];
//                    arr1[j] = num;
//                }
//            }
//        }
//        for(int a = 0; a<arr1.length;a++){
//            System.out.println(arr1[a]);
//        }
        // 快排
        int[] n = compare(arr1);


    }
}
