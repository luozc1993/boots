package cn.luozc.oa.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: luozhicong
 * @Description:
 * @Date: Create in 15:16 2018/12/21/021
 */

@Configuration
public class WebInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //System.out.println(">>>MyInterceptor>>>>>>>在请求处理之前进行调用（Controller方法调用之前）");
        System.out.println("cn.luozc.oa.interceptor.WebInterceptor拦截到==>【" + request.getRequestURL()+"】");
        return true;// 只有返回true才会继续向下执行，返回false取消当前请求
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //System.out.println(">>>MyInterceptor>>>>>>>请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //System.out.println(">>>MyInterceptor>>>>>>>在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）");
    }
}
