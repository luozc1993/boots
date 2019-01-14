package cn.luozc.oa.config;

import cn.luozc.oa.filter.LoginFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: luozhicong
 * @Description:
 * @Date: Create in 16:41 2019/1/14/014
 */
@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean LoginFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new LoginFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }
}
