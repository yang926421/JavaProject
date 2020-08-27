package cn.gsxt.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

//标志该类是spring的核心配置文件
@Configuration
//<context:component-scan base-package="cn.gsxt"></context:component-scan>
@ComponentScan("cn.gsxt")  //组件扫描
//@PropertySource("classpath:jdbc.properties")
@Import(DataSourceConfiguration.class)
public class SpringConfiguration {

}
