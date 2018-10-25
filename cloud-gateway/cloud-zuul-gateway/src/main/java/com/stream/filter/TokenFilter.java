package com.stream.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Stream on 2018/9/3.
 */

@Slf4j
//@Service
public class TokenFilter extends ZuulFilter {

    /**
     * 过滤器的类型，它决定过滤器在请求的哪个生命周期中执行。
     * 这里定义为pre，代表会在请求被路由之前执行。
     *
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * filter执行顺序，通过数字指定。
     * 数字越大，优先级越低。
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 判断该过滤器是否需要被执行。这里我们直接返回了true，因此该过滤器对所有请求都会生效。
     * 实际运用中我们可以利用该函数来指定过滤器的有效范围。
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体逻辑
     *
     * @return
     */
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        log.info("getPathInfo:" + request.getPathInfo());
        log.info("getContextPath:" + request.getContextPath());
        log.info("getServletPath:" + request.getServletPath());
        log.info("getPathTranslated:" + request.getPathTranslated());
        log.info("getRequestURI:" + request.getRequestURI());
        log.info("getRequestURL:" + request.getRequestURL());
        log.info("getQueryString:" + request.getQueryString());
//        getPathInfo:null
//        getContextPath:
//        getServletPath:/user-server/user/queryGit
//        getPathTranslated:null
//        getRequestURI:/user-server/user/queryGit
//        getRequestURL:http://192.168.0.103:8080/user-server/user/queryGit
//        getQueryString:null
        String token = request.getParameter("token");
        if (request.getRequestURI().contains("token") && (token == null || token.isEmpty())) {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            ctx.setResponseBody("token is empty");
        }
        return null;
    }

}
