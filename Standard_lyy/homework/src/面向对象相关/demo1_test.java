package 面向对象相关;

//编程统计字符串"ABCD123!@#$%ab"中大写字母、小写字母、数字、其它字符的个数并打 印出来。
public class demo1_test {
    public static void main(String[] args) {
        String s1 = "ABCD123!@#$%ab";
        for (int i = 0; i< s1.length(); i++)
        {
            System.out.println(Integer.valueOf(s1.charAt(i)));
        }

    }

}
