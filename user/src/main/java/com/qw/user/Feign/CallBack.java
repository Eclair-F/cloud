package com.qw.user.Feign;

import org.springframework.stereotype.Component;

@Component
public class CallBack implements Provider{
    @Override
    public String findname() {
        return "触发熔断降级";
    }
}
