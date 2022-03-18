package com.pgiles.slacker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MetricsController {

    @GetMapping("/metrics")
    public String metrics(HttpServletRequest request) {
        return "redirect:/actuator/prometheus";
    }

}
