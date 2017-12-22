package cc.ifnot.demo.controller;

import cc.ifnot.demo.bean.Base;
import cc.ifnot.demo.bean.Demo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping
    public Base all() {
        return new Base();
    }

    @Value(value = "${ifnot.secret}")
    private String secret;

    @Value(value = "${ifnot.number}")
    private int id;

    @Value(value = "${ifnot.desc}")
    private String desc;

    // @RequestParam 简单类型的绑定，可以出来get和post
    @RequestMapping("/get")
    public HashMap<String, Object> get(@RequestParam(value = "name", defaultValue = "aa") String name) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("title", "hello world!");
        hashMap.put("name", name);
        hashMap.put("secret", secret);
        hashMap.put("id", id);
        hashMap.put("desc", desc);
        return hashMap;
    }

    // @PathVariable 获得请求url中的动态参数
    @RequestMapping(value = "/get/{id}/{name}")
    public Demo getDemo(@PathVariable(value = "id", required = false) int id, @PathVariable(value = "name", required = false) String name) {
        Demo demo = new Demo();
        demo.setId(id);
        demo.setName(name);
        demo.setDate(new Date());
        return demo;
    }

}
