package com.example.webPrograming.repository;

import com.example.webPrograming.domain.Sample;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;



@SpringBootTest
public class SampleRepositoryTest {
    @Autowired
    SampleRepsitory sampleRepsitory;

    @Test
    void findALL(){
        List<Sample> list = sampleRepsitory.findAll();
        assertEquals(2,list.size());
    }
}
