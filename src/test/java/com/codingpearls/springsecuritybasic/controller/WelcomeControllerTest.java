package com.codingpearls.springsecuritybasic.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
class WelcomeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(username = "user", roles = "USER")
    void testWelcomeEndpointWithAuth() throws Exception {
        mockMvc.perform(get("/welcome"))
               .andExpect(status().isOk())
               .andExpect(content().string("Welcome user! This is a secure endpoint."));
    }

    @Test
    void testWelcomeEndpointWithoutAuth() throws Exception {
        mockMvc.perform(get("/welcome"))
               .andExpect(status().isUnauthorized());
    }

    @Test
    @WithMockUser(username = "admin", roles = "ADMIN")
    void testWelcomeEndpointWithAdmin() throws Exception {
        mockMvc.perform(get("/welcome"))
               .andExpect(status().isOk())
               .andExpect(content().string("Welcome admin! This is a secure endpoint."));
    }

    @Test
    @WithMockUser(username = "guest", roles = "GUEST")
    void testWelcomeEndpointWithGuestRole() throws Exception {
        mockMvc.perform(get("/welcome"))
               .andExpect(status().isForbidden()); // Or update SecurityConfig if guests should have access
    }
}
