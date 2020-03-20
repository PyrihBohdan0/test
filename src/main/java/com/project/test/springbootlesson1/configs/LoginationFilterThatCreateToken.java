package com.project.test.springbootlesson1.configs;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.stream.Collectors;

public class LoginationFilterThatCreateToken implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("i intersept this request");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        String body = httpServletRequest.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

        System.out.println(body);
    }

    @Override
    public void destroy() {

    }
}

