package com.example.webPrograming.service;

import com.example.webPrograming.repository.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.example.webPrograming.domain.Sample;
import org.springframework.transaction.annotation.Transactional;

import static java.lang.Thread.sleep;


@Service
public class SampleServiceTmp implements SampleService {
    @Override
    public String testNoCache(Long id){
        sleep(3);
        return "No Cache";
    }
    @Override
    @Cacheable(value="sample", key="#id")
    public String testCache(Long id){
        sleep(3);
        return "Cache";
    }

    @Override
    @CacheEvict(value="sample", key="#id")
    public void testCacheClear(Long id){
    }

    private void sleep(int second){
        try{
            Thread.sleep(second*1000L);
        } catch(InterruptedException e){
            throw new RuntimeException(e);
        }
    }
    @Autowired
    private SampleRepository sampleRepository;

    @Override
    public Sample selectOne(Long id) {
        return sampleRepository.findById(id).orElse(null);
    }

    @Override
    public void testNoTransactional() {
        Sample sample = sampleRepository.findById(1l).get();
        sample.setTitle("update1");
        sampleRepository.save(sample);

        throw new RuntimeException("No Transactional Test");
    }

    @Transactional
    public void testTransactional(){
        Sample sample = sampleRepository.findById(1l).get();
        sample.setTitle("update1");
        sampleRepository.save(sample);

        throw new RuntimeException("No Transactional Test");
    }
}
