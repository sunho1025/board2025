//package com.example.webPrograming.service;
//
//import com.example.webPrograming.domain.Sample;
//import com.example.webPrograming.repository.SampleRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//public class SampleServiceTransaction implements SampleService {
//    @Autowired
//    private SampleRepository sampleRepository;
//
//    @Override
//    public void testNoTransactional() {
//        Sample sample = sampleRepository.findById(1l).get();
//        sample.setTitle("update1");
//        sampleRepository.save(sample);
//
//        throw new RuntimeException("No Transactional Test");
//    }
//
//    @Transactional
//    public void testTransactional(){
//        Sample sample = sampleRepository.findById(1l).get();
//        sample.setTitle("update1");
//        sampleRepository.save(sample);
//
//        throw new RuntimeException("No Transactional Test");
//    }
//
//}
