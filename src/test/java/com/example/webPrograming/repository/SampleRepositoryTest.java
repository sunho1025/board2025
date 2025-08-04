package com.example.webPrograming.repository;

import com.example.webPrograming.domain.Sample;
import org.apache.ibatis.session.RowBounds;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;


@SpringBootTest
public class SampleRepositoryTest {
    @Autowired
    SampleRepository sampleRepository;

    @Autowired
    SampleMapper sampleMapper;

    @Test
    void findALLByTitle(){
        Map<String, Object> filter = new HashMap<>();
        filter.put("title", "t1");

        PageRequest pageable = PageRequest.of(0,2);
        Page<Sample> page = sampleRepository.findAll(SampleSpecs.search(filter), pageable);

        for(Sample s: page){
            System.out.println(s.getTitle());
        }
    }
    @Test
    void findOneByTitle(){
        List<Sample> samples = sampleRepository.findByTitleLike("%2");

        for(Sample s: samples){
            System.out.println(s.getTitle());
        }
    }

    @Test
    void findAll(){
        List<Sample> samples = sampleMapper.findAll();
        for(Sample sample:samples){
            System.out.println(sample.getTitle());
        }
    }

    @Test
    void findById(){
        Sample sample = sampleMapper.findById(1L);
        System.out.println(sample.getTitle());
        assertEquals(1,sample.getId());
    }
    @Test
    void findAllByTitle(){
        RowBounds rowBounds = new RowBounds(0, 10);
        List<Sample> samples=sampleRepository.findByTitle("t1");
        for(Sample sample: samples){
            System.out.println(sample.getTitle());
        }
    }

}
