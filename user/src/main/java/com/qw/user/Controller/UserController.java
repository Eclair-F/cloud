package com.qw.user.Controller;


import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import static com.alibaba.fastjson.JSON.*;

@RestController
public class UserController {
    private final RestTemplate restTemplate;

    public UserController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @CrossOrigin(origins = "*")
    @GetMapping(value = "buy")
    public JSONObject name()
    {
        String string = restTemplate.getForObject("http://PROVIDER/get", String.class);
        String s="{\"name\":\"我是"+string+"\"}";
        System.out.println(s);
        return parseObject(s);
    }
}
