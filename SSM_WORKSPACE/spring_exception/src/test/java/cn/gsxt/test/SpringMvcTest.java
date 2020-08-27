package cn.gsxt.test;

import cn.gsxt.controller.DemoController;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:spring-mvc.xml")
public class SpringMvcTest {

    @Autowired
    private DemoController demoController;

    public void test1() throws Exception {
        demoController.show();
    }


}
