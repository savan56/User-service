package com.savan.User_service.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ShoppingServer {

    @Autowired
    private RestTemplate template;

    @GetMapping("/payment/{price}")
    public String invokePayment(@PathVariable int price){
        String url = "http://PAYMENT-SERVICE/payment-provider/payNow/" + price;
        System.out.println("price : " + price);
        return template.getForObject(url,String.class);
    }

}
