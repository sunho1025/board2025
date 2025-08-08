package com.example.webPrograming.service;

import com.example.webPrograming.domain.Sample;

public interface SampleService {
    String testNoCache(Long id);
    String testCache(Long id);
    void testCacheClear(Long id);

}
