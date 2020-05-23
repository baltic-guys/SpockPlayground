package com.play.controller;

import com.play.service.SummatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RootController {

    @Autowired
    private SummatorService summatorService;

    @GetMapping("/")
    String index(Model model) {
        model.addAttribute("var1", 0);
        model.addAttribute("var2", 0);
        model.addAttribute("var3", 0);
        return "index";
    }

    @GetMapping("/calc")
    String calc(@RequestParam("var1") String var1, @RequestParam("var2") String var2, Model model) {
        model.addAttribute("var1", var1);
        model.addAttribute("var2", var2);
        model.addAttribute("var3", summatorService.sum(var1, var2));
        return "index";
    }
}
