package cc.ifnot.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableAutoConfiguration
@RequestMapping("/web")
public class WebController {

    private Logger logger = LoggerFactory.getLogger(WebController.class);

    @RequestMapping("freemarker")
    public String freemarker(ModelMap map) {
        logger.info("info: web controller freemarker");
        map.put("title", "freemarker!");
        return "freemarker/index";
    }

    @RequestMapping("thymeleaf")
    public String thymeleaf(ModelMap map) {
        logger.info("info: web controller thymeleaf");
        map.put("title", "thymeleaf!");
        return "thymeleaf/index";
    }

    @RequestMapping("exception")
    public String exception(ModelMap map) throws Exception {
        throw new Exception("测试异常");
    }

    @RequestMapping("runtimeexception")
    public String runtimeexception(ModelMap map) {
        throw new RuntimeException("测试异常");
    }

}
