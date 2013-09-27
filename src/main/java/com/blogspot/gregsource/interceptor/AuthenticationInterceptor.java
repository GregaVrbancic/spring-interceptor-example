package com.blogspot.gregsource.interceptor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

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
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        logger.info("Intercepting: " + request.getRequestURI());

        //get session from request
        HttpSession session = request.getSession();
        logger.info(session.getAttribute("loginUser"));

        //check if user already have set attribute userLogin
        if (session.getAttribute("userLogin") != null)
            return true;

        String[] splitURI = request.getRequestURI().split("/");
        if (splitURI[splitURI.length - 1].equals("login"))
            return true;

        //if user is not logged in we redirect him to login
        logger.info("redirect to secure/login");
        response.sendRedirect("login");
        return false;
    }
}