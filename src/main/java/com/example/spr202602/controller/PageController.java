package com.example.spr202602.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class PageController {
    @RequestMapping("/page1")
    public String page1(){
        System.out.println("page1!!!!");
        return "page1"; // 여기 스트링 값에 해당하는 ~~.html 파일을 찾아감!!
        // resources/templates 이 아래에 있어요!!
    }
    @RequestMapping("/add")
    public String add(@RequestParam int a, @RequestParam int b, Model model){
        System.out.println("add!!!! : " + a + "//" + b);
        int sum = 0;
        sum = a + b;
        System.out.println("sum : " + sum);
        model.addAttribute("sum", sum);
        model.addAttribute("a", a);
        model.addAttribute("b", b);

        Map<String, Object> map = new HashMap<>();
        map.put("a", a);
        map.put("b", b);
        map.put("sum", sum);
        model.addAttribute("map", map);
        return "add";
    }

    @ResponseBody //이거를 붙이면 REST CTRL 이 되는거!! 페이지 이동 없음!!
    @RequestMapping("/add2")
    public Map<String, Object> add2(int a, int b){
        Map<String, Object> map = new HashMap<>();
        int sum = a + b;
        map.put("sum", sum);
        map.put("a", a);
        map.put("b", b);
        return map;
    }
    //과제 버전 1
    @ResponseBody
    @RequestMapping("/string1")
    public String str_add(String a, String b){
        return a+b;
    }
    //과제 버전 2
    @RequestMapping("/multiple1")
    public String multiple(@RequestParam int a, @RequestParam int b, Model model){
        int result = a * b;
        model.addAttribute("a", a);
        model.addAttribute("b", b);
        model.addAttribute("result", result);

        Map<String,Integer> result_map = new HashMap<>();
        result_map.put("a", a);
        result_map.put("b", b);
        result_map.put("result", result);

        model.addAttribute("result_map",result_map);
        return "multiple";
    }
}