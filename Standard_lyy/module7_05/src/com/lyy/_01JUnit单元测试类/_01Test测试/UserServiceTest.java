package com.lyy._01JUnit单元测试类._01Test测试;

import org.junit.*;

public class UserServiceTest {
    @Before
    public void Before(){
        System.out.println("我是在每个测试方法前都会执行一次");
    }
    @After
    public void After(){
        System.out.println("我在每个测试方法之后都会执行一次");
    }

    // @BeforeClass：用来静态修饰方法，该方法会在所有测试方法之前只执行一次。
    @BeforeClass
    public static void beforeClass(){
        System.out.println("===beforeClass===");
    }

    // @AfterClass：用来静态修饰方法，该方法会在所有测试方法之后只执行一次。
    @AfterClass
    public static void afterClass(){
        System.out.println("===afterClass===");
    }


    @Test
   public void testLogin(){
        UserService userService = new UserService();
        String rs = userService.login("admin","123456");
        // 断言预期结果的正确性
        /**
         * 参数一   测试失败的提醒信息
         * 参数二  期望值
         * 参数三  实际值
         *
         * */
        Assert.assertEquals("登录方法有错误,需要修改","Success", rs);
   }

   @Test
    public void testChu(){
        UserService userService = new UserService();
        userService.chu(10, 0);
   }
}
