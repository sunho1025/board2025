package com.example.webPrograming.service;

import com.example.webPrograming.domain.Sample;
import org.springframework.stereotype.Service;

public interface SampleService {
    String testNoCache(Long id);
    String testCache(Long id);
    void testCacheClear(Long id);

    Sample selectOne(Long id);

    void testNoTransactional();
}
