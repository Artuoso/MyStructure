package com.uni.common.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
* Druid配置类
*
* @author Created by zc on 2019/11/24
*/
@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
public class DruidConfig {

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.maxActive}")
    private int maxActive;

    @Value("${spring.datasource.initialSize}")
    private int initialSize;

    @Value("${spring.datasource.maxWait}")
    private int maxWait;

    @Value("${spring.datasource.minIdle}")
    private int minIdle;

    /** 监控统计拦截的filters，如果去掉后监控界面sql将无法统计 */
    @Value("${spring.datasource.filters}")
    private String filters;

    /**
     * 注册 Servlet 组件
     *
     * @author Created by zc on 2019/11/24
     */
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        /*servletRegistrationBean.addInitParameter("allow", "192.168.1.3"); //白名单IP*/
        servletRegistrationBean.addInitParameter("loginUsername", "druid");
        servletRegistrationBean.addInitParameter("loginPassword", "druid");
        return servletRegistrationBean;
    }

    /**
     * 注册 Filter 组件
     *
     * @author Created by zc on 2019/11/24
     */
    @Bean
    public FilterRegistrationBean statFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        //验证所有请求
        filterRegistrationBean.addUrlPatterns("/*");
        //对 *.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/* 不进行验证
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }

    /**
     * 配置数据源
     *
     * @author Created by zc on 2019/11/24
     */
    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setMaxActive(maxActive);
        dataSource.setInitialSize(initialSize);
        try {
            dataSource.setFilters(filters);
        } catch (SQLException e) {
            //do nothing
        }
        dataSource.setMaxWait(maxWait);
        dataSource.setMinIdle(minIdle);
        return dataSource;
    }
}
