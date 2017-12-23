package com.javasampleapproach.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WebController {

    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/helloworld")
    public String home() {
        return this.restTemplate.getForObject("http://helloworld/greeting", String.class);
    }

    @RequestMapping("/tide")
    public String getTideRest() {
        return this.restTemplate.getForObject("http://helloworld/features/ribbon", String.class);
    }
}