package cc.ifnot.demo.controller


import cc.ifnot.demo.bean.Base
import cc.ifnot.demo.bean.Hello
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

import java.util.concurrent.atomic.AtomicLong

@Controller
@EnableAutoConfiguration
@RequestMapping("/hello")
class SampleController {

    private val counter = AtomicLong()

    @RequestMapping("*")
    @ResponseBody
    fun index(): Base {
        return Base()
    }

    @RequestMapping("/hello")
    @ResponseBody
    fun hello(@RequestParam(value = "name", defaultValue = "world") name: String): Hello {
        return Hello(counter.incrementAndGet(), String.format("hello %s", name))
    }
}
