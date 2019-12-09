package com.qw.user.Controller;


import com.alibaba.fastjson.JSONObject;
import com.qw.user.Feign.Provider;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.alibaba.fastjson.JSON.parseObject;

@RestController
public class UserController {
   // private final RestTemplate restTemplate;

    private final String url="http://PROVIDER";

    private final Provider provider;
    private final DiscoveryClient discoveryClient;
    public UserController(DiscoveryClient discoveryClient, Provider provider) {
    //    this.restTemplate = restTemplate;
        this.discoveryClient = discoveryClient;
        this.provider = provider;
    }

    @CrossOrigin(origins = "*")
    @GetMapping(value = "buy")
    public JSONObject name()
    {
        List<ServiceInstance> serviceInstance = discoveryClient.getInstances("provider");
        ServiceInstance instance=serviceInstance.get(0);
        String string =provider.findname();
        String s="{\"url\":\""+instance.getHost()+":"+instance.getPort()+"\",\"name\":\"我是"+string+"\"}";
        return parseObject(s);
    }
}
