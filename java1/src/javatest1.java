public class javatest1 {
    public static void main(String[] args) {
        System.out.println("这是在看些基础敲的代码");
        String s = "lyy is a da shuai bi";
        int index = s.indexOf('y');
        String s1 = "192@168@0@1";
        String[] arr1 = s1.split("@", 2);
        System.out.println(arr1);
        for (String a : arr1) {
            System.out.println("[" + a + "]");
        }
        /*
         * str.index("指定字符")   获取字符位置
         * str.charAt(index)  将获取index位置字符
         * str.substring(index)  从index截取到字符串最后
         * str.substring(begin_index, end_index) 截取指定长度
         * str.trim()  删除首尾空格
         * str.replace(old_char, new_char)  替换字符
         * str.startsWith()  判断以...开头
         * str.endsWith()
         * str.toLowerCase()
         * str.toUpperCase()
         * */
        System.out.println(index);
    }
}
