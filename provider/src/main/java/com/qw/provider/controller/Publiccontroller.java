package com.qw.provider.controller;

import com.qw.provider.services.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Publiccontroller {
    private final Provider provider;

    public Publiccontroller(Provider provider) {
        this.provider = provider;
    }

    @GetMapping(value = "/get")
    public String getprovider(){
        return provider.getprovider();

    }
}
