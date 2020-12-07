package com.lmx.www.dwlogger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class LogJsonControlle {

    private static final Logger logger = LoggerFactory.getLogger(LogJsonControlle.class);

    @PostMapping("/log")
    public void getLog(@RequestParam("log") String log) {
        JSONObject logJsonObj = JSON.parseObject(log);
        int randomInt = new Random().nextInt(3600 * 1000 * 5);
        logJsonObj.put("ts", System.currentTimeMillis() + randomInt);
        String logNew = logJsonObj.toJSONString();
        System.out.println(logNew);
        logger.warn(logNew);

    }
}
