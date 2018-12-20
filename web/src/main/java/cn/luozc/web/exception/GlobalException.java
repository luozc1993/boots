package cn.luozc.web.exception;

import cn.luozc.domain.JsonData;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常处理
 *
 * @Author: luozhicong
 * @Description:
 * @Date: Create in 13:10 2018/12/20/020
 */
@ControllerAdvice
public class GlobalException {


    /**
     *
     * @param request   request
     * @param excrption excrption
     * @return return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JsonData globalErrorHandler(HttpServletRequest request, Exception excrption){

        Map<String , Object> map = new HashMap<>();
        map.put("message",excrption.getMessage());
        map.put("url",request.getRequestURL());
        return JsonData.fail(map,"请求错误");
    }


}
