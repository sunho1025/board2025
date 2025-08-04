package com.example.webPrograming.web;

import com.example.webPrograming.domain.Sample;
import com.example.webPrograming.repository.SampleRepository;
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

    @GetMapping("/list")
    @ResponseBody
    public List<Sample> list(Model model){
        return sampleRepository.findAll();
    }
}
