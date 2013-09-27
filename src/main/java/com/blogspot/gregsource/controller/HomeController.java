package com.blogspot.gregsource.controller;

import com.blogspot.gregsource.entity.UserLogin;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * User: grega
 * Date: 26/8/13
 * Time: 6:17 PM
 */
@Controller
public class HomeController {

    private static Log logger = LogFactory.getLog(HomeController.class);

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("hello", "hello");
        return mv;

    }

    @RequestMapping(value = "/secure", method = RequestMethod.GET)
    public ModelAndView secure(HttpSession session) {
        logger.info("return secure view!");
        ModelAndView mv = new ModelAndView("secure");
        mv.addObject("userLogin", session.getAttribute("userLogin"));
        return mv;
    }

    @RequestMapping(value = "/secure/login", method = RequestMethod.GET)
    public ModelAndView secureLogin() {
        logger.info("return login view!");
        ModelAndView mv = new ModelAndView("login");
        mv.addObject("userLogin", new UserLogin());
        return mv;
    }

    @RequestMapping(value = "/secure/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpSession session) {
        logger.info("user logged out!");
        session.invalidate();
        return new ModelAndView("redirect:/secure");
    }

    @RequestMapping(value = "/secure/login", method = RequestMethod.POST)
    public ModelAndView formSubmit(@ModelAttribute("userLogin") UserLogin userLogin, HttpSession session) {
        logger.info("processing login form!");

        //check if fields are empty
        if (userLogin.getUsername().isEmpty() && userLogin.getPassword().isEmpty())
            return new ModelAndView("redirect:/secure/login");

        //here you would some authentication work

        //set user data to session
        session.setAttribute("userLogin", userLogin);
        return new ModelAndView("redirect:/secure");
    }
}