package cn.gsxt.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@ComponentScan("cn.gsxt")  //组件扫描
@PropertySource("classpath:jdbc.properties")
public class DataSourceConfiguration {

    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("{jdbc.password}")
    private String password;


    @Bean("dataSource") //spring会将当前方法的返回值以指定名称存储到容器中
    public DataSource getDataSource() throws Exception{
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
//        dataSource.setDriverClass("${jdbc.driver}");
//        dataSource.setJdbcUrl("${jdbc.url}");
//        dataSource.setUser("${jdbc.username}");
//        dataSource.setPassword("${jdbc.password}");
        dataSource.setDriverClass(driver);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
