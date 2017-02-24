package com.homework.insurance;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.regex.Matcher;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by v_slo on 24/02/2017.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(DemoController.class)
public class DemoControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void loadInsurancePage() throws Exception {
        this.mockMvc.perform(get("/insurance").accept(MediaType.parseMediaType("application/xhtml+xml")))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("To calculate the price of your insurance, please follow the steps:")))
                .andExpect(content().string(containsString("Bike(Coverage 0-3k)")))
                .andExpect(content().string(containsString("Jewellery(Coverage 500-10k)")))
                .andExpect(content().string(containsString("Electronics(Coverage 500-6k)")))
                .andExpect(content().string(containsString("Sports Equipment (Coverage 0-20k)")))
                .andExpect(content().string(containsString("input type=\"submit\" value=\"Calculate\" />")));
    }


    @Test
    public void postToInsurancePage() throws Exception {
        this.mockMvc.perform(post("/insurance").param("module", "Jewellery").param("coverage","3000").accept(MediaType.parseMediaType("text/html")))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("For Jewellery insurance type and 3000 coverage the price will be 15")));
    }

}
