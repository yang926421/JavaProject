package 面向对象相关;

//编程统计字符串"ABCD123!@#$%ab"中大写字母、小写字母、数字、其它字符的个数并打 印出来。
public class demo1_test {
    private static int Big_count;
    private static int little_count;
    private static int num_count;
    private static int other_count;

    public static void main(String[] args) {
        String s1 = "ABCD123!@#$%ab";
        for (int i = 0; i < s1.length(); i++) {
            int num = Integer.valueOf(s1.charAt(i));
            if (num > 47 && num < 58) {
                num_count += 1;

            } else if (num > 64 && num < 90) {
                Big_count += 1;

            } else if (num > 96 && num < 122) {
                little_count += 1;

            } else {
                other_count += 1;
            }
        }
        System.out.println(Big_count);
        System.out.println(little_count);
        System.out.println(num_count);
        System.out.println(other_count);

    }

}
