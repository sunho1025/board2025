//package com.example.webPrograming.service;
//
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;
//import org.springframework.stereotype.Service;
//
//import static java.lang.Thread.sleep;
//
//
//@Service
//public class SampleServiceCache implements SampleService {
//    @Override
//    public String testNoCache(Long id){
//        sleep(3);
//        return "No Cache";
//    }
//    @Override
//    @Cacheable(value="sample", key="#id")
//    public String testCache(Long id){
//        sleep(3);
//        return "Cache";
//    }
//
//    @Override
//    @CacheEvict(value="sample", key="#id")
//    public void testCacheClear(Long id){
//    }
//
//    private void sleep(int second){
//        try{
//            Thread.sleep(second*1000L);
//        } catch(InterruptedException e){
//            throw new RuntimeException(e);
//        }
//    }
//
//
//}
