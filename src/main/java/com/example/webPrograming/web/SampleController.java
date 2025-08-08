package com.example.webPrograming.web;

import com.example.webPrograming.domain.Sample;
import com.example.webPrograming.repository.SampleRepository;
import com.example.webPrograming.service.SampleService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
    @GetMapping("/getParameter")
    public String getParameter(Model model, HttpServletRequest req){
        String title = req.getParameter("title");
        model.addAttribute("title",title);

        return "sample";
    }

    @GetMapping("/requestParam")
    public String requestParam(Model model, @RequestParam String title){
        model.addAttribute("title", title);
        return "sample";
    }

    @GetMapping("/pathVariable/{title}")
    public String pathVariable(Model model, @PathVariable String title){
        model.addAttribute("title",title);
        return "sample";
    }
    @GetMapping("/modelAttribute")
    public String modelAttribute(Model model, @ModelAttribute Sample sample){
        model.addAttribute("title",sample.getTitle());
        return "sample";
    }
    @PostMapping("/requestBody1")
    @ResponseBody
    public ResponseEntity<Sample> requestBody1(@RequestBody Map<String, Object> obj){
        Sample sample = new Sample();
        sample.setId(1L);
        sample.setTitle((String)obj.get("title"));
        return ResponseEntity.ok(sample);
    }

    @PostMapping("/requestBody2")
    @ResponseBody
    public Sample requestBody2(@RequestBody Sample sample){
        Sample s = new Sample();
        s.setId(1L);
        s.setTitle(sample.getTitle());
        return s;
    }
    @GetMapping("/selectOne")
    @ResponseBody
    public Sample selectOne(Model model, @RequestParam Long id){
        return sampleService.selectOne(id);
    }


}
