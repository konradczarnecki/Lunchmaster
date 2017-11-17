package com.lunchmaster;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    @RequestMapping({ "/wall", "/login", "/profile", "/billing", "/restaurants" })
    public String bypassMVC() {

        return "forward:/index.html";
    }
}
