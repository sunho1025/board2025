package com.example.webPrograming.web;

import com.example.webPrograming.domain.Sample;
import com.example.webPrograming.repository.SampleRepository;
import com.example.webPrograming.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/sample")
public class SampleController {
    //의존성 주입 DI
    @Autowired
    private SampleRepository sampleRepository;

    @Autowired
    private SampleService sampleService;

    @GetMapping("/list")
    @ResponseBody
    public List<Sample> list(Model model){
        return sampleRepository.findAll();
    }

//    @GetMapping("/noTransactional")
//    @ResponseBody
//    public String noTransactional(Model model){
//        sampleService.testNoTransactional();
//        return "noTransactional";
//    }
//
//    @GetMapping("/Transactional")
//    @ResponseBody
//    public String transactional(Model model){
//        sampleService.testTransactional();
//        return "Transactional";
//    }
    @GetMapping("/noCache")
    @ResponseBody
    public String noCache(Model model){
        return sampleService.testNoCache(3L);
    }
    @GetMapping("/Cache")
    @ResponseBody
    public String Cache(Model model){
        return sampleService.testCache(3L);
    }

}
