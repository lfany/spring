package cc.ifnot.demo.controller

import cc.ifnot.demo.bean.Base
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping("")
class MainController {

    @RequestMapping("*")
    @ResponseBody
    fun main(): Base {
        return Base()
    }
}
