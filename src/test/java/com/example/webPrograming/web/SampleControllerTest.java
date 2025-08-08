package com.example.webPrograming.web;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import com.example.webPrograming.domain.Sample;
import com.example.webPrograming.repository.SampleRepository;
import com.example.webPrograming.service.SampleService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SampleController.class)
class SampleControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private SampleRepository sampleRepository;

    @MockitoBean
    private SampleService sampleService;

    @Test
    void testGetSample() throws Exception {
        Sample sample = new Sample(1L, "title");
        Mockito.when(sampleService.selectOne(1L)).thenReturn(sample);

        mockMvc.perform(get("/sample/selectOne")
                    .param("id", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.title").value("title"))
                .andDo(print());
    }
}