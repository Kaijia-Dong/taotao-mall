package com.taotao.filter;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

/**
 * @description:
 * @version:
 * @author: dongkaijia
 * @create: 2019-04-08 11:21
 **/
@Slf4j
public class Log4jFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("-----log4j 过滤器启动-----");
    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String uuidSession = (String) httpServletRequest.getSession().getAttribute("uuid");
        if (null == uuidSession || "" == uuidSession.trim()) {
            UUID uuid = UUID.randomUUID();
            String uuidStr = uuid.toString();
            httpServletRequest.getSession().setAttribute("uuid", uuidStr);
            uuidSession = (String) httpServletRequest.getSession().getAttribute("uuid");
        }
        MDC.put("uuid", uuidSession);
        filterChain.doFilter(httpServletRequest, servletResponse);
    }
}
