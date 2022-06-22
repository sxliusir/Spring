package com.sxliusir.SpringBootOA.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@WebFilter(urlPatterns = "/*")
public class AccountFilter implements Filter {
    // 不需要登录的 URI
    private final String[] IGNORE_URI = {"/css/","/js/","/login","/images", "/fonts/","/swagger-ui.html", "static/css/", "static/js/", "swagger-resources", "/**/error", "v2/api-docs"};

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request =  (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;

        String uri = request.getRequestURI();
        // 当前访问的URI是不是 在Ignore列表里
        System.out.println("uri:" + uri);
        boolean pass = canPassIgnore(uri);
        if (pass) {
            // 在的话 放行
            chain.doFilter(request, response);
            return;
        }
        // 是否已登录，从session里找 Account

        Object account = request.getSession().getAttribute("userInfo");
        System.out.println("getSession userId:" + account);
        if (null == account) {
            // 没登录 跳转登录页面

            response.sendRedirect("/login/");
            return;
        }

        System.out.println("----filter----" + uri);
        chain.doFilter(request, response);
    }

    private boolean canPassIgnore(String uri) {
        // 判断 访问的URI 起始部分 是否包含 Ignore
        // 下级目录资源也能访问
        for (String val : IGNORE_URI) {
            if(uri.startsWith(val)) {
                return true;
            };
        }
        return false;
    }
}
