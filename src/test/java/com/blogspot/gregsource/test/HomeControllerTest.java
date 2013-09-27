package com.blogspot.gregsource.test;

import com.blogspot.gregsource.config.WebConfig;
import com.blogspot.gregsource.entity.UserLogin;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Created with IntelliJ IDEA.
 * User: grega
 * Date: 12/9/13
 * Time: 5:10 PM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfig.class)
public class HomeControllerTest {
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @Before
    public void init() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    //Test for controller method home
    @Test
    public void testHomePage() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(view().name("home"));
    }

    //Test for controller method secure
    @Test
    public void testSecurePage() throws Exception {
        mockMvc.perform(get("/secure").sessionAttr("userLogin", new UserLogin("username", "password")))
                .andExpect(status().isOk())
                .andExpect(view().name("secure"));
    }

    //Test for controller method login
    @Test
    public void testSecureLogin() throws Exception {
        mockMvc.perform(get("/secure/login").sessionAttr("userLogin", new UserLogin("username", "password")))
                .andExpect(status().isOk())
                .andExpect(view().name("login"));
    }
}