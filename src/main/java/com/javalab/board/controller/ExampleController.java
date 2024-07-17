package com.javalab.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExampleController {

    @RequestMapping("/ex02List")
    @ResponseBody
    public String getIds(@RequestParam List<Integer> ids) {
        return "Received IDs: " + ids;
    }
}