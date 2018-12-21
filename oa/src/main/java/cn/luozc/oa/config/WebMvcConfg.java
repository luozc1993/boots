package cn.luozc.oa.config;

import cn.luozc.oa.interceptor.WebInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/**
 * @Author: luozhicong
 * @Description:
 * @Date: Create in 15:46 2018/12/21/021
 */


/**
 * @author 彭伟
 * @Date 2018/9/27 15:56
 * mvc配置类
 */
@Configuration
public class WebMvcConfg implements WebMvcConfigurer {


    /**
     * @param registry 配置静态资源放行
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    /**
     * @param registry 添加拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加登录处理拦截器，拦截所有请求，登录请求除外
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(new WebInterceptor());
        //排除配置
        interceptorRegistration.excludePathPatterns("/error/*");
        interceptorRegistration.excludePathPatterns("/page/*");
        interceptorRegistration.excludePathPatterns("/login.html");
        //配置拦截策略
        interceptorRegistration.addPathPatterns("/**");
    }
}

