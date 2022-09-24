package com.yc.cn.shopproduct.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @GetMapping("/product/{pid}")
    public String product(@PathVariable("pid") Integer pid) {

        return "2224";
    }
}
