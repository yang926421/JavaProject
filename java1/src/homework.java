//public class homework {
//    public static void main(String[] args) {
//        System.out.println("列表的转置");
//        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        //此方法比较麻烦  没啥意思  需要改进
//        for (int i = 0; i< a.length-1; i++){
//            for (int j = 0; j<a[i].length;j++){
//                //特殊判断 多余再进行变换的数据
//                if ((i<1&&j<1) | (i==1&&j==0)){
//                    continue;
//                }
//                int num;
//                num = a[i][j];
//                a[i][j] = a[j][i];
//                a[j][i] = num;
//            }
//        }
//        for(int m = 0; m<a.length; m++){
//            for(int n = 0; n<a[m].length;n++){
//                System.out.println(a[m][n]);
//            }
//        }
//    }
//}

//
//public class Eval { // 创建类
//    public static void main(String[] args) {
//        int arr[][]=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
//        System.out.println("数组原有内容：");
//        for(int i = 0;i<arr.length;i++){
//            for(int j=0;j<arr.length;j++){
//                System.out.print(arr[i][j]);
//            }
//            System.out.println();
//        }
//        System.out.println("行列互换后数组内容：");
//        for(int i = 0;i<arr.length;i++){
//            for(int j=0;j<arr.length;j++){
//                System.out.print(arr[j][i]);
//            }
//            System.out.println();
//        }
//    }
//}
