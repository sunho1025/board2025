package com.example.webPrograming.web;

import com.example.webPrograming.domain.Sample;
import com.example.webPrograming.repository.SampleRepsitory;
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
    private SampleRepsitory sampleRepsitory;

    @GetMapping("/list")
    @ResponseBody
    public List<Sample> list(Model model){
        return sampleRepsitory.findAll();
    }
}
