package com.openclassrooms.paymybuddy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

public class LoginControllerTests {
    private MockMvc mock;
   @Autowired
    private WebApplicationContext context;
   @Test
   public void userLoginTest() throws Exception {
           mock.perform(formLogin("/login").user("payMyBuddyUser").password("user123")).andExpect(authenticated());
   }

    @Test
    public void userLoginFail() throws Exception {
        mock.perform(formLogin("/login")
                        .user("payMyBuddyUser")
                        .password("password"))
                .andExpect(unauthenticated());
    }

    @BeforeEach
    public void setup() {
        mock = MockMvcBuilders // ---> pour évaluer les codes de réponse sur mon app test MVC
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }
}
