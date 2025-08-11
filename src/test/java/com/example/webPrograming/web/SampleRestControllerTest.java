package com.example.webPrograming.web;

import com.example.webPrograming.domain.Sample;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SampleRestControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testGetSample() throws Exception{
        URI uri = UriComponentsBuilder.fromPath("/sample/selectOne")
                .queryParam("id", 1)
                .build()
                .toUri();
        Sample response = restTemplate.getForObject(uri, Sample.class);

        assertEquals(1L, response.getId());
        assertEquals("update1", response.getTitle());
    }
}
