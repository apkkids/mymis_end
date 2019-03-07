package com.apkkids.config;

import com.apkkids.bean.RespBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Author:      wxb
 * Project:     mymis_end
 * Create Date: 2019/3/7
 * Create Time: 17:24
 * Description: 处理访问资源时被拒绝后的操作，访问拒绝的异常来自MyAccessDecisionManager
 */
@Component
public class MyAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        PrintWriter out = httpServletResponse.getWriter();
        //构造一个RespBean
        RespBean respBean = RespBean.error(e.getMessage());
        //转为json字符串
        String msg = (new ObjectMapper()).writeValueAsString(respBean);
        //写入前端
        out.write(msg);
        out.flush();
        out.close();
    }
}
