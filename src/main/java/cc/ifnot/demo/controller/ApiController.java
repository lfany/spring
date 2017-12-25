package cc.ifnot.demo.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class ApiController {

    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public HashMap<String, Object> get(@RequestParam String name) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("title", "hello world");
        map.put("name", name);
        return map;
    }
}
