public class test1_sort选择 {
    public static void main(String[] args) {
        System.out.println("这是选择排序");
        int[] arr1 = {1, 4, 3, 6, 5, 8};
        for (int i = 1; i< arr1.length; i++){
            int index = 0;
            for (int j = 1; j<=arr1.length-i; j++){
                if (arr1[index] < arr1[j]){
                    index = j;
                }
            }
            // 交换位置
            int num;
             num = arr1[arr1.length-i];
             arr1[arr1.length - i] = arr1[index];
             arr1[index] = num;
        }
        for(int i:arr1){
            System.out.println(i);
        }
    }
}
