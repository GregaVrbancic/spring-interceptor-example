package com.blogspot.gregsource.interceptor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: grega
 * Date: 12/9/13
 * Time: 5:49 PM
 */
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {
    private static Log logger = LogFactory.getLog(AuthenticationInterceptor.class);

    //intercept request before it reaches the controller
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){

        logger.info("Intercepting: " + request.getRequestURI());

        // Do some changes to the incoming request object
        updateRequest(request);

        return true;
    }

    /**
     * The data added to the request would most likely come from a database
     */
    private void updateRequest(HttpServletRequest request) {
        logger.info("Updating request object");
        request.setAttribute("commonData",
                "This string is required in every request");
    }
}