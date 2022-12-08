package com.bdortho.stock.controller;

import com.fasterxml.jackson.core.io.DataOutputAsStream;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sun.net.www.protocol.https.HttpsURLConnectionImpl;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;

@Controller
@RequestMapping("/mess")
public class DemoMessController {

    @GetMapping("/create")
    public String create(){

        return "demo_model/index";
    }


}
