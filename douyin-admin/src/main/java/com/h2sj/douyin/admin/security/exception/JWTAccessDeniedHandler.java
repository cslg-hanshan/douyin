package com.h2sj.douyin.admin.security.exception;

import com.alibaba.fastjson.JSON;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JWTAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);

        Map<String,Object> ret = new HashMap<>();
        ret.put("code",403);
        ret.put("msg","访问拒绝："+e.getMessage());
        String jsonString = JSON.toJSONString(ret);

        response.getWriter().write(jsonString);
        response.getWriter().flush();
    }
}
