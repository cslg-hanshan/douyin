package com.h2sj.douyin.admin.security.filter;

import com.alibaba.fastjson.JSON;
import com.h2sj.douyin.admin.security.userdetails.CustomUserDetailsService;
import com.h2sj.douyin.common.utils.JwtUtils;
import com.h2sj.douyin.common.utils.Result;
import com.h2sj.douyin.common.utils.ResultCode;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    public JWTAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            String header = request.getHeader(AUTHORIZATION);
            if (header == null) {
                chain.doFilter(request, response);
                return;
            }
            header = header.trim();
            if (!StringUtils.startsWithIgnoreCase(header, JwtUtils.TOKEN_PREFIX)) {
                chain.doFilter(request, response);
                return ;
            }
            UsernamePasswordAuthenticationToken authRequest = getAuthentication(header);
            if (authRequest == null) throw new AuthenticationServiceException("身份认证错误");
            Authentication authenticate = this.getAuthenticationManager().authenticate(authRequest);
            SecurityContextHolder.getContext().setAuthentication(authenticate);
        }
        catch (Exception ex) {
            // jwt 验证异常
            ex.printStackTrace();
            SecurityContextHolder.clearContext();
            response.setCharacterEncoding("utf-8");
            response.setHeader("Content-Type","application/json");
            PrintWriter writer = response.getWriter();
            String ret = JSON.toJSONString(Result.failed(ResultCode.BADCREDENTIALS));
            writer.write(ret);
            writer.flush();
            return;
        }
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(String tokenHeader) {
        String token = tokenHeader.replace(JwtUtils.TOKEN_PREFIX, "");
        if (JwtUtils.isExpiration(token)) return null;
        Map<String, Object> claims = JwtUtils.praseToken(token);
        String username = claims.get("username").toString();
        String password = claims.get("password").toString();
        return new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>());
    }
}
