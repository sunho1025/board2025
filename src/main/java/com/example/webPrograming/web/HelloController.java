package com.example.webPrograming.web;

import com.example.webPrograming.service.boardItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.*;

@Controller
@RequestMapping(value="/hello")
public class HelloController {
    @Autowired
    boardItemService boardItemService;

    @RequestMapping(value = " ")
    public String hello(Model model){
        int sum = boardItemService.add(3, 5);
        List<String> myItems = new ArrayList<>();
        myItems.add("aaa");
        myItems.add("bbb");
        myItems.add("ccc");

        model.addAttribute("name", "홍길동");
        model.addAttribute("sum", sum);
        model.addAttribute("myItems", myItems);
        return "hello";
    }
}
