package cc.ifnot.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web")
public class WebController {

    private Logger logger = LoggerFactory.getLogger(WebController.class);

    @RequestMapping("index")
    public String index(ModelMap map) {
        logger.info("info: web controller");
        map.put("title", "hello world!");
        return "index";
    }

}
