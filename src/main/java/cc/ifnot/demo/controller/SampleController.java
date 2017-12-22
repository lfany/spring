package cc.ifnot.demo.controller;


import cc.ifnot.demo.bean.Base;
import cc.ifnot.demo.bean.Hello;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.atomic.AtomicLong;

@Controller
@EnableAutoConfiguration
@RequestMapping("/hello")
public class SampleController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("*")
    @ResponseBody
    public Base index() {
        return new Base();
    }

    @RequestMapping("/hello")
    @ResponseBody
    public Hello hello(@RequestParam(value = "name", defaultValue = "world") String name) {
        return new Hello(counter.incrementAndGet(), String.format("hello %s", name));
    }
}
