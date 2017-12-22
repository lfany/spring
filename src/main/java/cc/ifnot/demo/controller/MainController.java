package cc.ifnot.demo.controller;

import cc.ifnot.demo.bean.Base;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("")
public class MainController {

    @RequestMapping("*")
    @ResponseBody
    public Base main() {
        return new Base();
    }
}
