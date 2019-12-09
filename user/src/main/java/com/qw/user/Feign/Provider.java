package com.qw.user.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "provider",fallback = CallBack.class)
public interface Provider {

   @GetMapping(value = "/get")
   public String findname();
}
