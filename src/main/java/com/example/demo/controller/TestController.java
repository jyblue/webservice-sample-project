package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.TestRequestBodyDTO;

@RestController
@RequestMapping("test")
public class TestController {
    @GetMapping("/test")
    public String testMethod(@RequestBody TestRequestBodyDTO testRequestBodyDTO) {
        return "Hello World "+ testRequestBodyDTO.getMessage();
    }

    @GetMapping("/test3/{name}")
    public ResponseDTO<String> testResponse1(@PathVariable String name) {
        List<String> list = new ArrayList<>();
        list.add(name);
        return ResponseDTO.<String>builder().data(list).build();
    }

    @GetMapping("/test3")
    public ResponseDTO<String> testResponse(@RequestParam(required = false) String name) {
        List<String> list = new ArrayList<>();
        list.add(name);
        return ResponseDTO.<String>builder().data(list).build();
    }

    @GetMapping("/test4")
    public ResponseEntity<?> test23() {
        List<String> t = new ArrayList<>();
        t.add("testset");
        ResponseDTO<String> response = ResponseDTO.<String>builder().data(t).build();
        return ResponseEntity.badRequest().body(response);
    }

    @GetMapping("/good")
    public ResponseEntity<?> good() {
        List<String> list = new ArrayList<>();
        list.add("data1");
        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).
                build();

        return ResponseEntity.ok().body(response);
    }
}
