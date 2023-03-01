package com.pgiles.slacker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class MetricsController {

    @GetMapping("/metrics")
    public void getMetrics(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // forward will work transparently in all environments
        ServletContext servletContext = request.getServletContext();
        servletContext.getRequestDispatcher("/actuator/prometheus").forward(request, response);
    }
}
