package com.codingpearls.springsecuritybasic;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringSecurityBasicApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testWelcomeEndpoint() throws Exception {
        // You can add actual test cases here
        // Example (with Spring MVC Test):
        // mockMvc.perform(get("/welcome").with(user("admin").password("password123")))
        //        .andExpect(status().isOk());
    }
}
