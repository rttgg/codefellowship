package com.gebrehiwot.codefellowship;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

public class CodefellowshipApplicationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void contextLoads(){

    }

    @Test
    public void testRootRoute_containsCodefellowship() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.content().string(
                        org.hamcrest.Matchers.containsString("<h1>Codefellowship</h1>")));

    }

    @Test
    public void testSignupRoute_containsForm() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/signup"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.content().string(
                        org.hamcrest.Matchers.containsString("<form method=\"POST\" action=\"/users\">")));
//                <form method="POST" action="/users">
    }



}
